/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.pojo.BaiViet;
import com.drl.repositories.BaiVietRepository;
import com.drl.services.BaiVietService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class BaiVietServiceImpl implements BaiVietService {

    @Autowired
    private BaiVietRepository baiVietRepo;

    @Override
    public List<BaiViet> getBaiViets(Map<String, String> params) {
        return this.baiVietRepo.getBaiViets(params);
    }

    @Override
    public void addOrUpdate(BaiViet bv) {
        this.baiVietRepo.addOrUpdate(bv);

    }

    @Override
    public BaiViet getBaiVietByIDd(int id) {
        return this.baiVietRepo.getBaiVietByIDd(id);

    }

    @Override
    public void deleteBaiViet(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
