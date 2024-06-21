/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.formatters;

import com.drl.pojo.SinhVienHoatDong;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ADMIN
 */
public class SinhVienHoatDongFormatter implements Formatter<SinhVienHoatDong> {

    @Override
    public String print(SinhVienHoatDong sinhVienHoatDong, Locale locale) {
                return String.valueOf(sinhVienHoatDong.getId());

    }

    @Override
    public SinhVienHoatDong parse(String id, Locale locale) throws ParseException {
        SinhVienHoatDong c = new SinhVienHoatDong();
        c.setId(Integer.parseInt(id));
        return c;
    }
     
}
