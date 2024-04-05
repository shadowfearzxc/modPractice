package com.example.webservice.rest;

import com.example.webservice.security.jwt.dto.JwtRequest;
import com.example.webservice.security.jwt.dto.JwtResponse;
import com.example.webservice.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {
    private AuthService authService;
    @PostMapping("/auth")
    public JwtResponse createToken(@RequestBody JwtRequest jwtRequest) {
        return authService.createToken(jwtRequest);
    }
}
