/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services;

import com.drl.pojo.BaiViet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface BaiVietService {
    List<BaiViet> getBaiViets(Map<String, String> params);
    void addOrUpdate(BaiViet bv);
    BaiViet getBaiVietByIDd(int id);
    void deleteBaiViet(int id);
}
