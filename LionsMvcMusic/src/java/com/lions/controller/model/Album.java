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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="Album", schema = "HAKI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findByAlbumid", query = "SELECT a FROM Album a WHERE a.albumid = :albumid"),
    @NamedQuery(name = "Album.findByTitle", query = "SELECT a FROM Album a WHERE a.title = :title"),
    @NamedQuery(name = "Album.findByPrice", query = "SELECT a FROM Album a WHERE a.price = :price"),
    @NamedQuery(name = "Album.findByAlbumarturl", query = "SELECT a FROM Album a WHERE a.albumarturl = :albumarturl")})
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name="albumid",nullable = false, precision = 20, scale = 0)
    private BigDecimal albumid;
    @Basic(optional = false)
    @Column(name="title",nullable = false, length = 120)
    private String title;
    @Basic(optional = false)
    @Column(name="price",nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    @Column(name="albumarturl",length = 1000)
    private String albumarturl;
    @JoinColumn(name = "ARTISTID", referencedColumnName = "ARTISTID", nullable = false)
    @ManyToOne(optional = false)
    private Artist artistid;
    @JoinColumn(name = "GENREID", referencedColumnName = "GENREID", nullable = false)
    @ManyToOne(optional = false)
    private Genre genreid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "albumid")
    private Collection<Orderdetail> orderdetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "albumid")
    private Collection<Cart> cartCollection;

    public Album() {
    }

    public Album(BigDecimal albumid) {
        this.albumid = albumid;
    }

    public Album(BigDecimal albumid, String title, BigDecimal price) {
        this.albumid = albumid;
        this.title = title;
        this.price = price;
    }

    public BigDecimal getAlbumid() {
        return albumid;
    }

    public void setAlbumid(BigDecimal albumid) {
        this.albumid = albumid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAlbumarturl() {
        return albumarturl;
    }

    public void setAlbumarturl(String albumarturl) {
        this.albumarturl = albumarturl;
    }

    public Artist getArtistid() {
        return artistid;
    }

    public void setArtistid(Artist artistid) {
        this.artistid = artistid;
    }

    public Genre getGenreid() {
        return genreid;
    }

    public void setGenreid(Genre genreid) {
        this.genreid = genreid;
    }

    @XmlTransient
    public Collection<Orderdetail> getOrderdetailCollection() {
        return orderdetailCollection;
    }

    public void setOrderdetailCollection(Collection<Orderdetail> orderdetailCollection) {
        this.orderdetailCollection = orderdetailCollection;
    }

    @XmlTransient
    public Collection<Cart> getCartCollection() {
        return cartCollection;
    }

    public void setCartCollection(Collection<Cart> cartCollection) {
        this.cartCollection = cartCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (albumid != null ? albumid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.albumid == null && other.albumid != null) || (this.albumid != null && !this.albumid.equals(other.albumid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lions.controller.model.Album[ albumid=" + albumid + " ]";
    }
    
}
