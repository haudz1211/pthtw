/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;
import com.drl.services.BaiVietService;
import com.drl.services.HoatDongService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ADMIN
 */
@Controller
@ControllerAdvice
public class IndexBVController {

    @Autowired
    private HoatDongService hoatDongService;
    @Autowired
    private BaiVietService baiVietService;

    @RequestMapping("/indexbv")
    public String index(Model model,
            @RequestParam Map<String, String> params) {
        model.addAttribute("baiViets", this.baiVietService.getBaiViets(params));
        return "indexbv";//Tìm trong tiles
    }
    
    @ModelAttribute//Tất cả các response trong Controller này sẽ có thông tin này, gắn ControllerAdvice sẽ dùng ModelAt tribute chung cho các controller khác
    public void commonAttribute(Model model,
            @RequestParam Map<String, String> params) {
        model.addAttribute("hoatDongs", this.hoatDongService.getHoatDongs(params));
    }

}
