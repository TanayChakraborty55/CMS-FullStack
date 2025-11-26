package com.capgemini.CourseManagementSysstem.controller;

import com.capgemini.CourseManagementSysstem.dto.AuthRequest;
import com.capgemini.CourseManagementSysstem.dto.AuthResponse;
import com.capgemini.CourseManagementSysstem.dto.RegisterRequest;
import com.capgemini.CourseManagementSysstem.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest req){
        return ResponseEntity.ok(authService.login(req));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest req){
        return new ResponseEntity<>(authService.register(req), HttpStatus.CREATED);
    }
}
