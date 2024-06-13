/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "hoc_ki")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HocKi.findAll", query = "SELECT h FROM HocKi h"),
    @NamedQuery(name = "HocKi.findById", query = "SELECT h FROM HocKi h WHERE h.id = :id"),
    @NamedQuery(name = "HocKi.findByHocKi", query = "SELECT h FROM HocKi h WHERE h.hocKi = :hocKi")})
public class HocKi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "hoc_ki")
    private String hocKi;
    @OneToMany(mappedBy = "hocKiId")
    private Set<HocKiNamHoc> hocKiNamHocSet;

    public HocKi() {
    }

    public HocKi(Integer id) {
        this.id = id;
    }

    public HocKi(Integer id, String hocKi) {
        this.id = id;
        this.hocKi = hocKi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHocKi() {
        return hocKi;
    }

    public void setHocKi(String hocKi) {
        this.hocKi = hocKi;
    }

    @XmlTransient
    public Set<HocKiNamHoc> getHocKiNamHocSet() {
        return hocKiNamHocSet;
    }

    public void setHocKiNamHocSet(Set<HocKiNamHoc> hocKiNamHocSet) {
        this.hocKiNamHocSet = hocKiNamHocSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HocKi)) {
            return false;
        }
        HocKi other = (HocKi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drl.pojo.HocKi[ id=" + id + " ]";
    }
    
}
