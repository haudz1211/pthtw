/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.drl.services;

import com.drl.pojo.SinhVien;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface StatsService {

    List<Object[]> statsDiemRenLuyenTheoKhoa();

    List<SinhVien> getSinhViens();
//    public List<SinhVien> getSinhViens();
}
