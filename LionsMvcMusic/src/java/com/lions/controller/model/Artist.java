/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name="Artist", schema = "HAKI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artist.findAll", query = "SELECT a FROM Artist a"),
    @NamedQuery(name = "Artist.findByArtistid", query = "SELECT a FROM Artist a WHERE a.artistid = :artistid"),
    @NamedQuery(name = "Artist.findByName", query = "SELECT a FROM Artist a WHERE a.name = :name")})
public class Artist implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name="artistid",nullable = false, precision = 20, scale = 0)
    private BigDecimal artistid;
    @Basic(optional = false)
    @Column(name="name",nullable = false, length = 100)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artistid")
    private Collection<Album> albumCollection;

    public Artist() {
    }

    public Artist(BigDecimal artistid) {
        this.artistid = artistid;
    }

    public Artist(BigDecimal artistid, String name) {
        this.artistid = artistid;
        this.name = name;
    }

    public BigDecimal getArtistid() {
        return artistid;
    }

    public void setArtistid(BigDecimal artistid) {
        this.artistid = artistid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Album> getAlbumCollection() {
        return albumCollection;
    }

    public void setAlbumCollection(Collection<Album> albumCollection) {
        this.albumCollection = albumCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artistid != null ? artistid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artist)) {
            return false;
        }
        Artist other = (Artist) object;
        if ((this.artistid == null && other.artistid != null) || (this.artistid != null && !this.artistid.equals(other.artistid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lions.controller.model.Artist[ artistid=" + artistid + " ]";
    }
    
}
