/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.pojo.BaiViet;
import com.drl.repositories.BaiVietRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class BaiVietRepositoryImpl implements BaiVietRepository{
    @Autowired
    private Environment env;

    @Autowired
    private LocalSessionFactoryBean factory;
        
    
    
    @Override
    public List<BaiViet> getBaiViets(Map<String, String> params) {
         Session s = this.factory.getObject().openSession();
            CriteriaBuilder b = s.getCriteriaBuilder();//Muốn lấy điều kiện
            CriteriaQuery<BaiViet> q = b.createQuery(BaiViet.class);//Tạo những lệnh truy vấn đến bảng nào

            Root r = q.from(BaiViet.class);//Muốn lấy trường (column)
            q.select(r);
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(r.get("ten"), "%" + kw + "%")); //1% đầu tiên là format, %% đầu cuối tiếp theo là để phân biệt  %% trong sql
            }
            
            String hoatDongId = params.get("hoatDongId");
            if (hoatDongId != null && !hoatDongId.isEmpty()) {
                predicates.add(b.equal(r.get("hoatDongId"), Integer.valueOf(hoatDongId)));
            }
            q.where(predicates.toArray(Predicate[]::new));
            

            q.orderBy(b.desc(r.get("id")));
            Query query = s.createQuery(q);

            String p = params.get("page");
            if (p != null && !p.isEmpty()) {
                int pageSize = Integer.parseInt(env.getProperty("baiViet.pageSize"));
                int start = (Integer.parseInt(p) - 1) * pageSize;
                query.setFirstResult(start);
                query.setMaxResults(pageSize);
            }
            List<BaiViet> baiViets = query.getResultList();
            return baiViets;

    }

    @Override
    public void addOrUpdate(BaiViet bv) {
         Session s = this.factory.getObject().getCurrentSession();
            if (bv.getId() > 0) {
                s.update(bv);
            } else {
                s.save(bv);
            }
    }

    @Override
    public BaiViet getBaiVietByIDd(int id) {
         Session s = this.factory.getObject().getCurrentSession();
         return s.get(BaiViet.class, id);
    }

    @Override
    public void deleteBaiViet(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
