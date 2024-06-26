/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.formatters;

import com.drl.pojo.HoatDong;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author ADMIN
 */
public class StringToHoatDongConverter implements Converter<String, HoatDong>{

    @Override
    public HoatDong convert(String hoatDongId) {
         // Thực hiện việc chuyển đổi từ String sang HoatDong
        // Ví dụ: tạo một đối tượng HoatDong từ ID của HoatDong
        HoatDong hoatDong = new HoatDong();
        hoatDong.setId(Integer.parseInt(hoatDongId)); // Giả sử source là ID của HoatDong
        return hoatDong;
    }
    
}
