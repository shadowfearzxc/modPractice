package com.example.webservice.security.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JwtRequest {
    private String username;
    private String password;
}
