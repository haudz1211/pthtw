/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.formatters;

import com.drl.pojo.SinhVien;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ADMIN
 */
public class SinhVienFormatter implements Formatter<SinhVien> {

    @Override
    public String print(SinhVien sinhVien, Locale locale) {
        return String.valueOf(sinhVien.getId());

    }

    @Override
    public SinhVien parse(String id, Locale locale) throws ParseException {
         SinhVien c = new SinhVien();
        c.setId(Integer.parseInt(id));
        return c;
    }

}
