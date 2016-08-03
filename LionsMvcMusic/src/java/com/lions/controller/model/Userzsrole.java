/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lions.controller.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="UserzsRole", schema = "HAKI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userzsrole.findAll", query = "SELECT u FROM Userzsrole u"),
    @NamedQuery(name = "Userzsrole.findByRoleid", query = "SELECT u FROM Userzsrole u WHERE u.roleid = :roleid"),
    @NamedQuery(name = "Userzsrole.findByRolename", query = "SELECT u FROM Userzsrole u WHERE u.rolename = :rolename")})
public class Userzsrole implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name="roleid",nullable = false, precision = 20, scale = 0)
    private BigDecimal roleid;
    @Basic(optional = false)
    @Column(name="rolename",nullable = false, length = 20)
    private String rolename;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID", nullable = false)
    @ManyToOne(optional = false)
    private Userzs userid;

    public Userzsrole() {
    }

    public Userzsrole(BigDecimal roleid) {
        this.roleid = roleid;
    }

    public Userzsrole(BigDecimal roleid, String rolename) {
        this.roleid = roleid;
        this.rolename = rolename;
    }

    public BigDecimal getRoleid() {
        return roleid;
    }

    public void setRoleid(BigDecimal roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Userzs getUserid() {
        return userid;
    }

    public void setUserid(Userzs userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleid != null ? roleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userzsrole)) {
            return false;
        }
        Userzsrole other = (Userzsrole) object;
        if ((this.roleid == null && other.roleid != null) || (this.roleid != null && !this.roleid.equals(other.roleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lions.controller.model.Userzsrole[ roleid=" + roleid + " ]";
    }
    
}
