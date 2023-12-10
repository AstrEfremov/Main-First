package com.firstProject.firstMain.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MainController {
    @GetMapping("/unsecured12")
    public String unsecuredData(){
        return "index";
    }
    @GetMapping("/secured")
    public String securedData(){
        return "index";
    }



}
