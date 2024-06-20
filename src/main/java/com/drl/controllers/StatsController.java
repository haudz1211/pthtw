/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.pojo.SinhVien;
import com.drl.services.LopService;
import com.drl.services.SinhVienHoatDongService;

import com.drl.services.StatsService;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.eclipse.persistence.internal.libraries.antlr.runtime.misc.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
@ControllerAdvice
public class StatsController {

    @Autowired
    private StatsService statsService;
    @Autowired
    private LopService lopService;
    @Autowired
    private SinhVienHoatDongService sinhVienHoatDongService;

    @RequestMapping("/stats")
    public String index(Model model,
            @RequestParam Map<String, String> params) {
        model.addAttribute("stats", this.statsService.getSinhViens(params));
        return "stats";//Tìm trong tiles
    }

    @ModelAttribute//Tất cả các response trong Controller này sẽ có thông tin này, gắn ControllerAdvice sẽ dùng ModelAt tribute chung cho các controller khác
    public void commonAttribute(Model model) {
        model.addAttribute("lops", this.lopService.getLops());
        model.addAttribute("sinhVienHoatDongs", this.sinhVienHoatDongService.getSinhVienHoatDongs());

    }
}
