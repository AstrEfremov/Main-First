package com.firstProject.firstMain.controllers;

import com.firstProject.firstMain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/showAllUsers")
    public String showUserList(Model model){
        model.addAttribute("list",userService.showAllUsers());
        return "showAllUsers";
    }
}
