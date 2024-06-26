/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.pojo.BaiViet;
import com.drl.services.BaiVietService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ADMIN
 */
@Controller
public class BaiVietController {
    @Autowired
    private BaiVietService baiVietService;

    @GetMapping("/home/baiviets")
    public String createView(Model model) {
        model.addAttribute("baiViet", new BaiViet());
        return "baiviets";
    }
    
  
    

    @PostMapping("/home/baiviets")
    public String createHoatDong(@ModelAttribute(value = "baiViet") @Valid BaiViet bv,
            BindingResult rs) { //1. ModelAttribute có 2 công dụng : + 1 là xài chung, 2 là gửi backing beans    Sau đó đóng gói lại đối tượng HoatDong h(Desireilizer)
        //Tất cả lõi sẽ hiện ở BindingResult rs
        if (!rs.hasErrors()) {
            try {
                this.baiVietService.addOrUpdate(bv);
                return "redirect:/";
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        System.err.println(rs);
        return "baiviets";
    }

    @GetMapping("/home/baiviets/{baivietId}")
    public String updateView(Model model, @PathVariable(value = "baivietId") int id) {
        model.addAttribute("baiViet", this.baiVietService.getBaiVietByIDd(id));

        return "baiviets";}
    
//     BaiViet baiViet = this.baiVietService.getBaiVietByIDd(id);
//        if (baiViet != null) {
//            model.addAttribute("baiViet", baiViet);
//        } else {
//            // Xử lý nếu không tìm thấy bài viết
//            return "redirect:/home/baiviets";
//        }
//        return "baiviets";
//    }
}
