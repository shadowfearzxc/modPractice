package com.example.webservice.model.security;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomUser {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
