/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name="Cart", schema = "HAKI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c"),
    @NamedQuery(name = "Cart.findByRecordid", query = "SELECT c FROM Cart c WHERE c.recordid = :recordid"),
    @NamedQuery(name = "Cart.findByCartid", query = "SELECT c FROM Cart c WHERE c.cartid = :cartid"),
    @NamedQuery(name = "Cart.findByCount", query = "SELECT c FROM Cart c WHERE c.count = :count"),
    @NamedQuery(name = "Cart.findByDatecreated", query = "SELECT c FROM Cart c WHERE c.datecreated = :datecreated")})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name="recordid",nullable = false, precision = 20, scale = 0)
    private BigDecimal recordid;
    @Basic(optional = false)
    @Column(name="cartid",nullable = false)
    private BigInteger cartid;
    @Basic(optional = false)
    @Column(name="count",nullable = false)
    private BigInteger count;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @JoinColumn(name = "Albumid", referencedColumnName = "Albumid", nullable = false)
    @ManyToOne(optional = false)
    private Album albumid;

    public Cart() {
    }

    public Cart(BigDecimal recordid) {
        this.recordid = recordid;
    }

    public Cart(BigDecimal recordid, BigInteger cartid, BigInteger count) {
        this.recordid = recordid;
        this.cartid = cartid;
        this.count = count;
    }

    public BigDecimal getRecordid() {
        return recordid;
    }

    public void setRecordid(BigDecimal recordid) {
        this.recordid = recordid;
    }

    public BigInteger getCartid() {
        return cartid;
    }

    public void setCartid(BigInteger cartid) {
        this.cartid = cartid;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Album getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Album albumid) {
        this.albumid = albumid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recordid != null ? recordid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.recordid == null && other.recordid != null) || (this.recordid != null && !this.recordid.equals(other.recordid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lions.controller.model.Cart[ recordid=" + recordid + " ]";
    }
    
}
