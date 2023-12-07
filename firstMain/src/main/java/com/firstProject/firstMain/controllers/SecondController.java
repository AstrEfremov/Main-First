package com.firstProject.firstMain.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class SecondController {
        @GetMapping("/auth")
        public String unsecuredData(){
            return "login";
        }
        @GetMapping("/unsecured1")
        public String unsecuredData1(){
            return "task-form";
        }
        @GetMapping("/authenticateTheUser")
        public String registrationSuccessful(){
            return "registration-confirmation";
        }
}
