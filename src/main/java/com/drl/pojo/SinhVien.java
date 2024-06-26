    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "sinh_vien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SinhVien.findAll", query = "SELECT s FROM SinhVien s"),
    @NamedQuery(name = "SinhVien.findById", query = "SELECT s FROM SinhVien s WHERE s.id = :id"),
    @NamedQuery(name = "SinhVien.findByHo", query = "SELECT s FROM SinhVien s WHERE s.ho = :ho"),
    @NamedQuery(name = "SinhVien.findByTen", query = "SELECT s FROM SinhVien s WHERE s.ten = :ten"),
    @NamedQuery(name = "SinhVien.findByNamSinh", query = "SELECT s FROM SinhVien s WHERE s.namSinh = :namSinh"),
    @NamedQuery(name = "SinhVien.findByGioiTinh", query = "SELECT s FROM SinhVien s WHERE s.gioiTinh = :gioiTinh"),
    @NamedQuery(name = "SinhVien.findByNienKhoa", query = "SELECT s FROM SinhVien s WHERE s.nienKhoa = :nienKhoa")})
public class SinhVien implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "khoa_id")
    private int khoaId;
    
 
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
       @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ho")
    private String ho;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ten")
    private String ten;
    @Column(name = "nam_sinh")
    private Integer namSinh;
    @Column(name = "gioi_tinh")
    private Short gioiTinh;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "nienKhoa")
    private int nienKhoa;
    @JoinColumn(name = "lop_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lop lopId;
    @JoinColumn(name = "nam_hoc_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NamHoc namHocId;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private NguoiDung nguoiDung;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sinhVienId")
    private Set<SinhVienHoatDong> sinhVienHoatDongSet;

    public SinhVien() {
    }

    public SinhVien(Integer id) {
        this.id = id;
    }

    public SinhVien(Integer id, String ho, String ten,int namSinh, short gioiTinh, int nienKhoa) {
        this.id = id;
        this.ho=ho;
        this.ten=ten;
        this.namSinh=namSinh;
        this.gioiTinh=gioiTinh;
        this.nienKhoa = nienKhoa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }
    
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
     public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
     public short getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(short gioiTinh ) {
        this.gioiTinh = gioiTinh;
    }
    
    public int getNienKhoa() {
        return nienKhoa;
    }

    public void setNienKhoa(int nienKhoa) {
        this.nienKhoa = nienKhoa;
    }

    public Lop getLopId() {
        return lopId;
    }

    public void setLopId(Lop lopId) {
        this.lopId = lopId;
    }

    public NamHoc getNamHocId() {
        return namHocId;
    }

    public void setNamHocId(NamHoc namHocId) {
        this.namHocId = namHocId;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    @XmlTransient
    public Set<SinhVienHoatDong> getSinhVienHoatDongSet() {
        return sinhVienHoatDongSet;
    }

    public void setSinhVienHoatDongSet(Set<SinhVienHoatDong> sinhVienHoatDongSet) {
        this.sinhVienHoatDongSet = sinhVienHoatDongSet;
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
        if (!(object instanceof SinhVien)) {
            return false;
        }
        SinhVien other = (SinhVien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drl.pojo.SinhVien[ id=" + id + " ]";
    }

    public int getKhoaId() {
        return khoaId;
    }

    public void setKhoaId(int khoaId) {
        this.khoaId = khoaId;
    }

}
