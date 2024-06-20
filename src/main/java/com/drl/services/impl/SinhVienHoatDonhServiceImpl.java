/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.pojo.SinhVienHoatDong;
import com.drl.repositories.SinhVienHoatDongRepository;
import com.drl.services.SinhVienHoatDongService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class SinhVienHoatDonhServiceImpl implements SinhVienHoatDongService {

    @Autowired
    private SinhVienHoatDongRepository sinhVienHoatDongRepo;

    @Override
    public List<SinhVienHoatDong> getSinhVienHoatDongs() {
        return this.sinhVienHoatDongRepo.getSinhVienHoatDongs();

    }

}
