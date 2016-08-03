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
@Table(catalog = "", schema = "HAKI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userzs.findAll", query = "SELECT u FROM Userzs u"),
    @NamedQuery(name = "Userzs.findByUserid", query = "SELECT u FROM Userzs u WHERE u.userid = :userid"),
    @NamedQuery(name = "Userzs.findByUsername", query = "SELECT u FROM Userzs u WHERE u.username = :username"),
    @NamedQuery(name = "Userzs.findByFirstname", query = "SELECT u FROM Userzs u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "Userzs.findByLastname", query = "SELECT u FROM Userzs u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "Userzs.findByUserrole", query = "SELECT u FROM Userzs u WHERE u.userrole = :userrole")})
public class Userzs implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name="userid",nullable = false, precision = 20, scale = 0)
    private BigDecimal userid;
    @Basic(optional = false)
    @Column(name="username",nullable = false, length = 100)
    private String username;
    @Basic(optional = false)
    @Column(name="firstname",nullable = false, length = 100)
    private String firstname;
    @Basic(optional = false)
    @Column(name="lastname",nullable = false, length = 100)
    private String lastname;
    @Basic(optional = false)
    @Column(name="userrole",nullable = false)
    private BigInteger userrole;
    @Basic(optional = false)
    @Column(name="password",nullable = false, length = 100)
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Userzsrole> userzsroleCollection;
    @JoinColumn(name = "Orderid", referencedColumnName = "userid", nullable = false)
    @ManyToOne(optional = false)
    private Orders orderid;

    public Userzs() {
    }

    public Userzs(BigDecimal userid) {
        this.userid = userid;
    }

    public Userzs(BigDecimal userid, String username, String firstname, String lastname, BigInteger userrole,String password) {
        this.userid = userid;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userrole = userrole;
        this.password=password;
    }

    public BigDecimal getUserid() {
        return userid;
    }

    public void setUserid(BigDecimal userid) {
        this.userid = userid;
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

    public BigInteger getUserrole() {
        return userrole;
    }

    public void setUserrole(BigInteger userrole) {
        this.userrole = userrole;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }

    @XmlTransient
    public Collection<Userzsrole> getUserzsroleCollection() {
        return userzsroleCollection;
    }

    public void setUserzsroleCollection(Collection<Userzsrole> userzsroleCollection) {
        this.userzsroleCollection = userzsroleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userzs)) {
            return false;
        }
        Userzs other = (Userzs) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lions.controller.model.Userzs[ userid=" + userid + " ]";
    }
    
}
