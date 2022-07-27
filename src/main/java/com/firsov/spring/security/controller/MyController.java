package com.firsov.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String getInfoForAll(){
        return "view_for_all";
    }

    @GetMapping("/boss_page")
    public String getPageForBoss(){
        return "view_for_boss";
    }

    @GetMapping("/admin_page")
    public String getPageForAdmin(){
        return "view_for_admin";
    }

}
