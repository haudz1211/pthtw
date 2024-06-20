/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;
import com.drl.pojo.SinhVien;

import com.drl.services.StatsService;
import java.util.Arrays;
import java.util.List;
import org.eclipse.persistence.internal.libraries.antlr.runtime.misc.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author DELL
 */
@Controller
public class StatsController {
    @Autowired
    private StatsService statsService;
    
    @GetMapping("/stats")
    public String statsView(Model model) {
        // Giả sử statsService có phương thức getSinhViens() để lấy danh sách sinh viên
        List<SinhVien> sinhViens = statsService.getSinhViens();
        model.addAttribute("sinhViens", sinhViens);
        
        return "stats";
    }
}


