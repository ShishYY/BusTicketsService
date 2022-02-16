package com.example.busticketsservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String login;

    private String email;

    private List<String> role;
}
