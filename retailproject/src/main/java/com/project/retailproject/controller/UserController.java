package com.project.retailproject.controller;

import com.project.retailproject.dto.UserDTO;
import com.project.retailproject.dto.UserResponseDTO;
import com.project.retailproject.model.User;
import com.project.retailproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/insertUser")
    public ResponseEntity<UserResponseDTO> insertUser(UserDTO userDTO) {
        User user =  userService.insertUser(userDTO.getUser());
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUser(user);
        userResponseDTO.setMessage("success");
        userResponseDTO.setStatusCode(200);
        return ResponseEntity.ok().body(userResponseDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<UserResponseDTO> updateUser(UserDTO userDTO) {
        User user =  userService.updateUser(userDTO.getUser());
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUser(user);
        userResponseDTO.setMessage("success");
        userResponseDTO.setStatusCode(200);
        return ResponseEntity.ok().body(userResponseDTO);
    }
}
