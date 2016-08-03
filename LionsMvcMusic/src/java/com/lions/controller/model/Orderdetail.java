/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name="OrderDetail", schema = "HAKI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderdetail.findAll", query = "SELECT o FROM Orderdetail o"),
    @NamedQuery(name = "Orderdetail.findByOrderdetailid", query = "SELECT o FROM Orderdetail o WHERE o.orderdetailid = :orderdetailid"),
    @NamedQuery(name = "Orderdetail.findByQuantity", query = "SELECT o FROM Orderdetail o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "Orderdetail.findByUnitprice", query = "SELECT o FROM Orderdetail o WHERE o.unitprice = :unitprice")})
public class Orderdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name="orderdetailid",nullable = false, precision = 20, scale = 0)
    private BigDecimal orderdetailid;
    @Basic(optional = false)
    @Column(name="quantity",nullable = false)
    private BigInteger quantity;
    @Basic(optional = false)
    @Column(name="unitprice",nullable = false, precision = 10, scale = 2)
    private BigDecimal unitprice;
    @JoinColumn(name = "Albumid", referencedColumnName = "Albumid", nullable = false)
    @ManyToOne(optional = false)
    private Album albumid;
    @JoinColumn(name = "Orderid", referencedColumnName = "Orderid", nullable = false)
    @ManyToOne(optional = false)
    private Orders orderid;

    public Orderdetail() {
    }

    public Orderdetail(BigDecimal orderdetailid) {
        this.orderdetailid = orderdetailid;
    }

    public Orderdetail(BigDecimal orderdetailid, BigInteger quantity, BigDecimal unitprice) {
        this.orderdetailid = orderdetailid;
        this.quantity = quantity;
        this.unitprice = unitprice;
    }

    public BigDecimal getOrderdetailid() {
        return orderdetailid;
    }

    public void setOrderdetailid(BigDecimal orderdetailid) {
        this.orderdetailid = orderdetailid;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public Album getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Album albumid) {
        this.albumid = albumid;
    }

    public Orders getOrderid() {
        return orderid;
    }

    public void setOrderid(Orders orderid) {
        this.orderid = orderid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderdetailid != null ? orderdetailid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderdetail)) {
            return false;
        }
        Orderdetail other = (Orderdetail) object;
        if ((this.orderdetailid == null && other.orderdetailid != null) || (this.orderdetailid != null && !this.orderdetailid.equals(other.orderdetailid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lions.controller.model.Orderdetail[ orderdetailid=" + orderdetailid + " ]";
    }
    
}
