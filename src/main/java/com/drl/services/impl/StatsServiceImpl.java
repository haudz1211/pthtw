/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.pojo.SinhVien;
import com.drl.pojo.SinhVienHoatDong;
import com.drl.repositories.StatsRepository;
import com.drl.services.StatsService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Service
@Transactional
public class StatsServiceImpl implements StatsService {

    @Autowired
    private StatsRepository statsRepo;

//    @Override
//    public List<Object[]> statsDiemRenLuyenTheoKhoa() {
//        return this.statsRepo.statsDiemRenLuyenTheoKhoa();
//
//    }
//
//    @Override
//    public List<SinhVien> getSinhViens() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//    @Override
//    public List<SinhVien> getSinhViens(Map<String, String> params) {
//        return this.statsRepo.getSinhViens(params);
//
//    }
//
//    @Override
//    public SinhVien getSinhVienByIDd(int id) {
//        return this.statsRepo.getSinhVienByIDd(id);
//
//    }

    @Override
    public List<SinhVienHoatDong> getSinhVienHoatDongs(Map<String, String> params) {
                return this.statsRepo.getSinhVienHoatDongs(params);

    }

    @Override
    public void addOrUpdate(SinhVienHoatDong svhd) {
                this.statsRepo.addOrUpdate(svhd);

    }

    @Override
    public SinhVienHoatDong getSinhVienHoatDongByIDd(int id) {
        return this.statsRepo.getSinhVienHoatDongByIDd(id);
    }

    @Override
    public void deleteSinhVienHoatDong(int id) {
//                this.statsRepo.deleteSinhVienHoatDong(id);

    }
    

}
