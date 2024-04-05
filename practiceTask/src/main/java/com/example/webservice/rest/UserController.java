package com.example.webservice.rest;

import com.example.webservice.model.security.CustomUser;
import com.example.webservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private UserRepository userRepository;
    @GetMapping("/users")
    @PreAuthorize("hasAuthority('read') && hasAuthority('write')")
    public List<CustomUser> getAllUsers() {
        return userRepository.findAll();
    }
}
