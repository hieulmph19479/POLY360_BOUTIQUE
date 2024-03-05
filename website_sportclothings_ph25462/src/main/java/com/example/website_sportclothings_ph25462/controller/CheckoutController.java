package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.GioHangChiTiet;
import com.example.website_sportclothings_ph25462.service.GioHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CheckoutController {

//    @Autowired
//    private GioHangChiTietService gioHangChiTietService;

    @GetMapping("/showCheckout")
    public String showCheckout(Model model) {

//        List<GioHangChiTiet> cart = gioHangChiTietService.getCartItems(); // ??

//        model.addAttribute("cartItems", cartItems);


        return "/checkout/checkout";
    }

}
