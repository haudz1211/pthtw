/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.drl.repositories;

import com.drl.pojo.SinhVien;
import com.drl.pojo.SinhVienHoatDong;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface StatsRepository {

    //List<Object[]> statsDiemRenLuyenTheoKhoa();
    List<SinhVienHoatDong> getSinhVienHoatDongs(Map<String, String> params);
    void addOrUpdate(SinhVienHoatDong svhd); 
    SinhVienHoatDong getSinhVienHoatDongByIDd(int id);
    void deleteHoatDong(int id);


}
