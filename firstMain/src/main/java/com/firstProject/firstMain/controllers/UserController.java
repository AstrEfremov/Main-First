package com.firstProject.firstMain.controllers;

import com.firstProject.firstMain.dtos.RegistrationUserDto;
import com.firstProject.firstMain.dtos.UserDto;
import com.firstProject.firstMain.entities.Task;
import com.firstProject.firstMain.entities.User;
import com.firstProject.firstMain.repositories.RoleRepository;
import com.firstProject.firstMain.repositories.UserRepository;
import com.firstProject.firstMain.service.AuthService;
import com.firstProject.firstMain.service.TaskService;
import com.firstProject.firstMain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;


    @GetMapping("/showAllUsers/{id}")
    public String showUserList(@PathVariable Long id, Model user, Model task){
        user.addAttribute("list",userService.showAllUsers());
        task.addAttribute("task", taskService.getTaskById(id));
        return "showAllUsers";
    }
    @PostMapping("/updateUser")
    public String updateUser(Task task){
        System.out.println(task);
        return "redirect:/viewTaskList";
    }
}
