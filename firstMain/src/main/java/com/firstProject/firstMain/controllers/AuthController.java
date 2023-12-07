package com.firstProject.firstMain.controllers;

import com.firstProject.firstMain.dtos.JwtRequest;
import com.firstProject.firstMain.dtos.RegistrationUserDto;
import com.firstProject.firstMain.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        return authService.createAuthToken(authRequest);
    }
    @GetMapping("/admin")
    public String adminData(){
        return "login";
    }

    @GetMapping("/info")
    public String userDate(Principal principal){
        return principal.getName();
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDto registrationUserDto) {
        return authService.createNewUser(registrationUserDto);
    }
}
