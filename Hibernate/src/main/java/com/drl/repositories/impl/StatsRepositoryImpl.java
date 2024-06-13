/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.pojo.Dieu;
import com.drl.pojo.HoatDong;
import com.drl.pojo.HocKi;
import com.drl.pojo.HocKiNamHoc;
import com.drl.pojo.Khoa;
import com.drl.pojo.Lop;
import com.drl.pojo.NamHoc;
import com.drl.pojo.NguoiDung;
import com.drl.pojo.SinhVien;
import com.drl.pojo.SinhVienHoatDong;
import com.drl.repositories.StatsRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author DELL
 */
@Transactional
@Repository
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Object[]> statsDiemRenLuyenTheoKhoa() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();

        // Subquery
        CriteriaQuery<Object[]> subquery = cb.createQuery(Object[].class);
        Root<SinhVienHoatDong> svhdRoot = subquery.from(SinhVienHoatDong.class);
        Join<SinhVienHoatDong, SinhVien> sv = svhdRoot.join("sinhVienId");
        Join<SinhVienHoatDong, HoatDong> hd = svhdRoot.join("hoatDongId");
        Join<HoatDong, Dieu> d = hd.join("dieuId");
        Join<SinhVien, Lop> l = sv.join("lopId");
        Join<Lop, Khoa> k = l.join("khoaId");
        Join<SinhVien, NguoiDung> nd = sv.join("nguoiDung");
        Join<HoatDong, HocKiNamHoc> hn = hd.join("hocKiNamHocId");
        Join<HocKiNamHoc, HocKi> hk = hn.join("hocKiId");
        Join<HocKiNamHoc, NamHoc> nh = hn.join("namHocId");

        subquery.multiselect(
                sv.get("id"),
                nd.get("ho"),
                nd.get("ten"),
                k.get("ten"),
                cb.selectCase()
                        .when(cb.gt(cb.sum(hd.get("diem")), d.get("diemToiDa")), d.get("diemToiDa"))
                        .otherwise(cb.sum(hd.get("diem")))
        );

        subquery.where(
                cb.and(
                        cb.like(hk.get("hocKi"), "1"),
                        cb.equal(nh.get("namHoc"), 2024)
                )
        );

        subquery.groupBy(
                sv.get("id"),
                nd.get("ho"),
                nd.get("ten"),
                k.get("ten")
        );

        Query<Object[]> query = session.createQuery(subquery);
        List<Object[]> results = query.getResultList();

        return results;
    }
}
