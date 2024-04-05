package com.example.webservice.service;

import com.example.webservice.model.security.CustomUser;
import com.example.webservice.repository.UserRepository;
import com.example.webservice.security.jwt.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Пользователя с username:" + username + " не существует")
        );
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(jwtProvider.mapAuthorityToGrantedAuthorityString(user.getRole().getAuthorities()))
                .build();
    }
}
