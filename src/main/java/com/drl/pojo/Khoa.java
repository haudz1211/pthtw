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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "khoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Khoa.findAll", query = "SELECT k FROM Khoa k"),
    @NamedQuery(name = "Khoa.findById", query = "SELECT k FROM Khoa k WHERE k.id = :id"),
    @NamedQuery(name = "Khoa.findByTen", query = "SELECT k FROM Khoa k WHERE k.ten = :ten")})
public class Khoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ten")
    private String ten;
    @OneToMany(mappedBy = "khoaId")
    private Set<HoatDong> hoatDongSet;
    @OneToMany(mappedBy = "khoaId")
    private Set<Lop> lopSet;
    @OneToMany(mappedBy = "khoaId")
    private Set<TroLySinhVien> troLySinhVienSet;
    @OneToMany(mappedBy = "khoaId")
    private Set<SinhVien> sinhVienSet;

    public Khoa() {
    }

    public Khoa(Integer id) {
        this.id = id;
    }

    public Khoa(Integer id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @XmlTransient
    public Set<HoatDong> getHoatDongSet() {
        return hoatDongSet;
    }

    public void setHoatDongSet(Set<HoatDong> hoatDongSet) {
        this.hoatDongSet = hoatDongSet;
    }

    @XmlTransient
    public Set<Lop> getLopSet() {
        return lopSet;
    }

    public void setLopSet(Set<Lop> lopSet) {
        this.lopSet = lopSet;
    }

    @XmlTransient
    public Set<TroLySinhVien> getTroLySinhVienSet() {
        return troLySinhVienSet;
    }

    public void setTroLySinhVienSet(Set<TroLySinhVien> troLySinhVienSet) {
        this.troLySinhVienSet = troLySinhVienSet;
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
        if (!(object instanceof Khoa)) {
            return false;
        }
        Khoa other = (Khoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drl.pojo.Khoa[ id=" + id + " ]";
    }

}
