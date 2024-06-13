/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.repositories.StatsRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Transactional
@Repository
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Object[]> statsDiemRenLuyenTheoKhoa() {
        Session s = this.factory.getObject().getCurrentSession();
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT subquery.id, subquery.ho, subquery.ten, subquery.khoa, SUM(subquery.diem_tong) AS tong_diem ");
        hql.append("FROM ( ");
        hql.append("    SELECT sv.id, nd.ho, nd.ten, k.ten AS khoa, ");
        hql.append("           CASE WHEN SUM(hd.diem) > d.diemToiDa THEN d.diemToiDa ELSE SUM(hd.diem) END AS diem_tong ");
        hql.append("    FROM SinhVienHoatDong svhd ");
        hql.append("    JOIN svhd.sinhVienId sv ");
        hql.append("    JOIN svhd.hoatDongId hd ");
        hql.append("    JOIN hd.dieuId d ");
        hql.append("    JOIN sv.lopId l ");
        hql.append("    JOIN sv.nguoiDung nd ");
        hql.append("    JOIN l.khoaId k ");
        hql.append("    JOIN hd.hocKiNamHocId hn ");
        hql.append("    JOIN hn.hocKiId hk ");
        hql.append("    JOIN hn.namHocId nh ");
        hql.append("    WHERE hk.hocKi LIKE '1' AND nh.namHoc = 2024 ");
        hql.append("    GROUP BY sv.id, nd.ho, nd.ten, k.ten ");
        hql.append(") AS subquery ");
        hql.append("GROUP BY subquery.id, subquery.ho, subquery.ten, subquery.khoa ");

        Query<Object[]> query = s.createQuery(hql.toString(), Object[].class);

        return query.getResultList();
    }
}
