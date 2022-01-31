package com.example.busticketsservice.controler;

import com.example.busticketsservice.model.dto.AuthReqDto;
import com.example.busticketsservice.persistence.entity.UserEntity;
import com.example.busticketsservice.security.jwt.JwtTokenFactory;
import com.example.busticketsservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {

    private final JwtTokenFactory jwtTokenFactory;

    private final UserService userService;


    public AuthenticationController (JwtTokenFactory jwtTokenFactory, UserService userService) {
        this.jwtTokenFactory = jwtTokenFactory;
        this.userService = userService;
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthReqDto reqDto){
        try {
            String email = reqDto.getEmail();
            UserEntity user = userService.findByEmail(email);
            if (user == null) {
                throw new UsernameNotFoundException("User with email: " + email + " not found");
            }
            String token = jwtTokenFactory.createToken(email, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("email", email);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }

        }
}
