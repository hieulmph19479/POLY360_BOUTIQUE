package com.example.website_sportclothings_ph25462.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class test {

    @GetMapping("/test")
    public String test(){
        return "/admin/test";
    }
}
