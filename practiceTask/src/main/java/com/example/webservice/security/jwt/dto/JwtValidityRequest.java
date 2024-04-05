package com.example.webservice.security.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtValidityRequest {
    private String token;
}
