package com.example.busticketsservice.security;

import com.example.busticketsservice.persistence.entity.UserEntity;
import com.example.busticketsservice.security.jwt.JwtUser;
import com.example.busticketsservice.security.jwt.JwtUserFactory;
import com.example.busticketsservice.service.serviceimpl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserServiceImpl userService;

    public JwtUserDetailsService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.findByEmail(username);
        log.info("Successfully loaded user with email{}",username);
        return JwtUserFactory.create(user);
    }
}
