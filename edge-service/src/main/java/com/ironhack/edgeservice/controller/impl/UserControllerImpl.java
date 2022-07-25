package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.dto.RoleDTO;
import com.ironhack.edgeservice.controller.dto.UserDTO;
import com.ironhack.edgeservice.controller.interfaces.UserController;
import com.ironhack.edgeservice.model.Role;
import com.ironhack.edgeservice.model.User;
import com.ironhack.edgeservice.repository.UserRepository;
import com.ironhack.edgeservice.service.interfaces.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO register(@RequestBody UserDTO userDTO) {
        return userService.store(userDTO);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO login(@AuthenticationPrincipal User user) {
        log.info("Login successful");
       ;
        user.setPassword(null); // NEVER RETURN PASSWORD
        return userToDTO(userRepository.findByUsername(user.getUsername()).get());
    }

    private UserDTO userToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoles(user.getRoles().stream().map(this::roleToDTO).collect(Collectors.toSet()));

        return userDTO;
    }

    private RoleDTO roleToDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName(role.getRoleName());

        return roleDTO;
    }

}
