/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.pojo.SinhVien;
import com.drl.pojo.SinhVienHoatDong;
import com.drl.repositories.StatsRepository;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private Environment env;
    @Autowired
    private LocalSessionFactoryBean factory;

//    public List<Object[]> statsDiemRenLuyenTheoKhoa(String subquery) {
//        Session session = this.factory.getObject().getCurrentSession();
//
////        String subquery = "SELECT sv.id AS id, nd.ho AS ho, nd.ten AS ten, k.ten AS khoa, "
////                + "CASE WHEN SUM(hd.diem) > d.diemToiDa THEN d.diemToiDa ELSE SUM(hd.diem) END AS diem_tong "
////                + "FROM SinhVienHoatDong svhd "
////                + "JOIN SinhVien sv ON sv.id = svhd.sinhVienId "
////                + "JOIN HoatDong hd ON hd.id = svhd.hoatDongId "
////                + "JOIN Dieu d ON d.id = hd.dieuId "
////                + "JOIN Lop l ON l.id = sv.lopId "
////                + "JOIN NguoiDung nd ON nd.id = sv.nguoiDungId "
////                + "JOIN Khoa k ON k.id = l.khoaId "
////                + "JOIN HocKiNamHoc hn ON hn.id = hd.hocKiNamHocId "
////                + "JOIN HocKi hk ON hk.id = hn.hocKiId "
////                + "JOIN NamHoc nh ON nh.id = hn.namHocId "
////                + "WHERE hk.hocKi = '1' AND nh.namHoc = 2024 "
////                + "GROUP BY sv.id, nd.ho, nd.ten, k.ten";
////
////
////    String mainQuery = "SELECT subquery.khoa, SUM(subquery.diem_tong) AS tong_diem "
////                    + "FROM (" + subquery + ") AS subquery "
////                    + "GROUP BY subquery.khoa";
////
////    Query<Object[]> query = session.createQuery(mainQuery, Object[].class);
////    return query.getResultList();
//    
//   
//        return null;
//}
//
//    @Override
//    public List<Object[]> statsDiemRenLuyenTheoKhoa() {
//    return  null;
//    }
//    @Override
//    public List<SinhVien> getSinhViens(Map<String, String> params) {
//        Session s = this.factory.getObject().openSession();
//            CriteriaBuilder b = s.getCriteriaBuilder();//Muốn lấy điều kiện
//            CriteriaQuery<SinhVien> q = b.createQuery(SinhVien.class);//Tạo những lệnh truy vấn đến bảng nào
//
//            Root r = q.from(SinhVien.class);//Muốn lấy trường (column)
//            q.select(r);
//            List<Predicate> predicates = new ArrayList<>();
//            String kw = params.get("kw");
//            if (kw != null && !kw.isEmpty()) {
//                predicates.add(b.like(r.get("ten"), "%" + kw + "%")); //1% đầu tiên là format, %% đầu cuối tiếp theo là để phân biệt  %% trong sql
//            }
//            //Chon thu can muon loc hien tai chon lop
//            String lopId = params.get("lopId");
//            if (lopId != null && !lopId.isEmpty()) {
//                predicates.add(b.equal(r.get("lopId"), Integer.valueOf(lopId)));
//            }
//            q.where(predicates.toArray(Predicate[]::new));
//            
//
//            q.orderBy(b.desc(r.get("id")));
//            Query query = s.createQuery(q);
//
//            String p = params.get("page");
//            if (p != null && !p.isEmpty()) {
//                int pageSize = Integer.parseInt(env.getProperty("sinhVien.pageSize"));
//                int start = (Integer.parseInt(p) - 1) * pageSize;
//                query.setFirstResult(start);
//                query.setMaxResults(pageSize);
//            }
//            List<SinhVien> sinhViens = query.getResultList();
//            return sinhViens;
//    }
//
//    @Override
//    public SinhVien getSinhVienByIDd(int id) {
//         Session s = this.factory.getObject().getCurrentSession();
//         return s.get(SinhVien.class, id);
//    }
//
//    @Override
//    public void addOrUpdate(SinhVien sv) {
//         Session s = this.factory.getObject().getCurrentSession();
//            if (sv.getId() > 0) {
//                s.update(sv);
//            } else {
//                s.save(sv);
//            }
//    }
//
//    @Override
//    public void deleteHoatDong(int id) {
//         Session s = this.factory.getObject().getCurrentSession();
//            SinhVien sv = this.getSinhVienByIDd(id);
//            s.delete(sv);
//    }

    @Override
    public List<SinhVienHoatDong> getSinhVienHoatDongs(Map<String, String> params) {
        Session s = this.factory.getObject().openSession();
            CriteriaBuilder b = s.getCriteriaBuilder();//Muốn lấy điều kiện
            CriteriaQuery<SinhVienHoatDong> q = b.createQuery(SinhVienHoatDong.class);//Tạo những lệnh truy vấn đến bảng nào

            Root r = q.from(SinhVienHoatDong.class);//Muốn lấy trường (column)
            q.select(r);
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(r.get("ten"), "%" + kw + "%")); //1% đầu tiên là format, %% đầu cuối tiếp theo là để phân biệt  %% trong sql
            }
            //Chon thu can muon loc hien tai chon lop
            String sinhVienId = params.get("sinhVienId");
            if (sinhVienId != null && !sinhVienId.isEmpty()) {
                predicates.add(b.equal(r.get("sinhVienId"), Integer.valueOf(sinhVienId)));
            }
            q.where(predicates.toArray(Predicate[]::new));
            

            q.orderBy(b.desc(r.get("id")));
            Query query = s.createQuery(q);

            String p = params.get("page");
            if (p != null && !p.isEmpty()) {
                int pageSize = Integer.parseInt(env.getProperty("sinhVienHoatDong.pageSize"));
                int start = (Integer.parseInt(p) - 1) * pageSize;
                query.setFirstResult(start);
                query.setMaxResults(pageSize);
            }
            List<SinhVienHoatDong> sinhVienHoatDongs = query.getResultList();
            return sinhVienHoatDongs;
    }

    @Override
    public void addOrUpdate(SinhVienHoatDong svhd) {
         Session s = this.factory.getObject().getCurrentSession();
            if (svhd.getId() > 0) {
                s.update(svhd);
            } else {
                s.save(svhd);
            }
    }

    @Override
    public SinhVienHoatDong getSinhVienHoatDongByIDd(int id) {
        Session s = this.factory.getObject().getCurrentSession();
         return s.get(SinhVienHoatDong.class, id);
    }

    @Override
    public void deleteHoatDong(int id) {
        Session s = this.factory.getObject().getCurrentSession();
            SinhVienHoatDong svhd = this.getSinhVienHoatDongByIDd(id);
            s.delete(svhd);
    }

}
