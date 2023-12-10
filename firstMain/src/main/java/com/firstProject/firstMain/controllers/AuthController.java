package com.firstProject.firstMain.controllers;

import com.firstProject.firstMain.dtos.JwtRequest;
import com.firstProject.firstMain.dtos.RegistrationUserDto;
import com.firstProject.firstMain.dtos.UserDto;
import com.firstProject.firstMain.entities.User;
import com.firstProject.firstMain.repositories.RoleRepository;
import com.firstProject.firstMain.repositories.UserRepository;
import com.firstProject.firstMain.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/login")
    public String loginUser(){
        return "login";
    }

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        return authService.createAuthToken(authRequest);
    }
    @GetMapping("/info")
    public String userDate(Principal principal){
        return principal.getName();
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("systemUser", new RegistrationUserDto());
        return "registration-form";
    }
    @PostMapping("/registration")
    public String createNewUser(RegistrationUserDto userDto) {
        authService.createNewUser(userDto);
        return "redirect:/viewTaskList";
    }

}
