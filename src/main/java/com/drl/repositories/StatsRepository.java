/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.drl.repositories;

import com.drl.pojo.SinhVien;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface StatsRepository {

    //List<Object[]> statsDiemRenLuyenTheoKhoa();
    List<SinhVien> getSinhViens(Map<String, String> params);

    SinhVien getSinhVienByIDd(int id);


}
