/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name="Orders", schema = "HAKI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByOrderid", query = "SELECT o FROM Orders o WHERE o.orderid = :orderid"),
    @NamedQuery(name = "Orders.findByOrderdate", query = "SELECT o FROM Orders o WHERE o.orderdate = :orderdate"),
    @NamedQuery(name = "Orders.findByUsername", query = "SELECT o FROM Orders o WHERE o.username = :username"),
    @NamedQuery(name = "Orders.findByFirstname", query = "SELECT o FROM Orders o WHERE o.firstname = :firstname"),
    @NamedQuery(name = "Orders.findByLastname", query = "SELECT o FROM Orders o WHERE o.lastname = :lastname"),
    @NamedQuery(name = "Orders.findByAdress", query = "SELECT o FROM Orders o WHERE o.adress = :adress"),
    @NamedQuery(name = "Orders.findByCity", query = "SELECT o FROM Orders o WHERE o.city = :city"),
    @NamedQuery(name = "Orders.findByState", query = "SELECT o FROM Orders o WHERE o.state = :state"),
    @NamedQuery(name = "Orders.findByPostalcode", query = "SELECT o FROM Orders o WHERE o.postalcode = :postalcode"),
    @NamedQuery(name = "Orders.findByPhone", query = "SELECT o FROM Orders o WHERE o.phone = :phone"),
    @NamedQuery(name = "Orders.findByEmail", query = "SELECT o FROM Orders o WHERE o.email = :email"),
    @NamedQuery(name = "Orders.findByTotal", query = "SELECT o FROM Orders o WHERE o.total = :total")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name="orderid",nullable = false, precision = 20, scale = 0)
    private BigDecimal orderid;
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderdate;
    @Basic(optional = false)
    @Column(name="username",nullable = false, length = 50)
    private String username;
    @Basic(optional = false)
    @Column(name="firstname",nullable = false, length = 50)
    private String firstname;
    @Basic(optional = false)
    @Column(name="lastname",nullable = false, length = 50)
    private String lastname;
    @Basic(optional = false)
    @Column(name="adress",nullable = false, length = 100)
    private String adress;
    @Basic(optional = false)
    @Column(name="city",nullable = false, length = 100)
    private String city;
    @Basic(optional = false)
    @Column(name="state",nullable = false, length = 100)
    private String state;
    @Basic(optional = false)
    @Column(name="postalcode",nullable = false)
    private long postalcode;
    @Basic(optional = false)
    @Column(name="phone",nullable = false)
    private BigInteger phone;
    @Basic(optional = false)
    @Column(name="email",nullable = false, length = 100)
    private String email;
    private BigInteger total;
    @Basic(optional = false)
    @Column(name="userid",nullable = false,precision = 20, scale = 0)
    private BigDecimal userid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Userzs> userzsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderid")
    private Collection<Orderdetail> orderdetailCollection;

    public Orders() {
    }

    public Orders(BigDecimal orderid) {
        this.orderid = orderid;
    }

    public Orders(BigDecimal orderid, String username, String firstname, String lastname, String adress, String city, String state, long postalcode, BigInteger phone, String email,BigDecimal userid) {
        this.orderid = orderid;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.adress = adress;
        this.city = city;
        this.state = state;
        this.postalcode = postalcode;
        this.phone = phone;
        this.email = email;
        this.userid=userid;
    }

    public BigDecimal getOrderid() {
        return orderid;
    }

    public void setOrderid(BigDecimal orderid) {
        this.orderid = orderid;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(long postalcode) {
        this.postalcode = postalcode;
    }

    public BigInteger getPhone() {
        return phone;
    }

    public void setPhone(BigInteger phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }
    public BigDecimal getUserid()
    {
        return userid;
    }
    public void setUserid(BigDecimal userid)
    {
        this.userid=userid;
    }

    @XmlTransient
    public Collection<Orderdetail> getOrderdetailCollection() {
        return orderdetailCollection;
    }
    

    @XmlTransient
    public Collection<Userzs> getUserzsCollection()
    {
        return userzsCollection;
    }
    public void setUserzsCollection(Collection<Userzs> userzsCollection)
    {
        this.userzsCollection=userzsCollection;
    }
    public void setOrderdetailCollection(Collection<Orderdetail> orderdetailCollection) {
        this.orderdetailCollection = orderdetailCollection;
    }
   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lions.controller.model.Orders[ orderid=" + orderid + " ]";
    }
    
}
