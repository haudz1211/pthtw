/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.formatters;

import com.drl.pojo.Lop;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ADMIN
 */
public class LopFormatter implements Formatter<Lop>{

    @Override
    public String print(Lop lop, Locale locale) {
        return String.valueOf(lop.getId());
    }

    @Override
    public Lop parse(String id, Locale locale) throws ParseException {
        Lop c = new Lop();
        c.setId(Integer.parseInt(id));
        return c;
    }
    
    
}
