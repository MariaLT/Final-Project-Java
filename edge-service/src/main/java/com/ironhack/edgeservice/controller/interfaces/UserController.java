package com.ironhack.edgeservice.controller.interfaces;



import com.ironhack.edgeservice.controller.dto.UserDTO;
import com.ironhack.edgeservice.model.User;

import java.util.List;

public interface UserController {
    UserDTO register(UserDTO userDTO);
    List<UserDTO> findAll();
    UserDTO login(User user);
    List<User> findAllUsers();
}
