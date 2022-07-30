package com.ironhack.edgeservice.controller.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private Set<RoleDTO> roles;
}
