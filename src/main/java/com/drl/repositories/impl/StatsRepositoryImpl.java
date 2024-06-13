/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.repositories.StatsRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author DELL
 */
@Transactional
@Repository
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    public List<Object[]> statsDiemRenLuyenTheoKhoa(String subquery) {
        Session session = this.factory.getObject().getCurrentSession();

//        String subquery = "SELECT sv.id AS id, nd.ho AS ho, nd.ten AS ten, k.ten AS khoa, "
//                + "CASE WHEN SUM(hd.diem) > d.diemToiDa THEN d.diemToiDa ELSE SUM(hd.diem) END AS diem_tong "
//                + "FROM SinhVienHoatDong svhd "
//                + "JOIN SinhVien sv ON sv.id = svhd.sinhVienId "
//                + "JOIN HoatDong hd ON hd.id = svhd.hoatDongId "
//                + "JOIN Dieu d ON d.id = hd.dieuId "
//                + "JOIN Lop l ON l.id = sv.lopId "
//                + "JOIN NguoiDung nd ON nd.id = sv.nguoiDungId "
//                + "JOIN Khoa k ON k.id = l.khoaId "
//                + "JOIN HocKiNamHoc hn ON hn.id = hd.hocKiNamHocId "
//                + "JOIN HocKi hk ON hk.id = hn.hocKiId "
//                + "JOIN NamHoc nh ON nh.id = hn.namHocId "
//                + "WHERE hk.hocKi = '1' AND nh.namHoc = 2024 "
//                + "GROUP BY sv.id, nd.ho, nd.ten, k.ten";
//
//
//    String mainQuery = "SELECT subquery.khoa, SUM(subquery.diem_tong) AS tong_diem "
//                    + "FROM (" + subquery + ") AS subquery "
//                    + "GROUP BY subquery.khoa";
//
//    Query<Object[]> query = session.createQuery(mainQuery, Object[].class);
//    return query.getResultList();
    
   
        return null;
}

    @Override
    public List<Object[]> statsDiemRenLuyenTheoKhoa() {
    return  null;
    }

}
