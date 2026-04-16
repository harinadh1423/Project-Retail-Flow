package com.project.retailproject.controller;

import com.project.retailproject.dto.UserDTO;
import com.project.retailproject.dto.UserResponseDTO;
import com.project.retailproject.model.User;
import com.project.retailproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/insertUser")
    public ResponseEntity<UserResponseDTO> addUserDetails(@RequestBody UserDTO userDTO) {
        User user =  userService.insertUser(userDTO.getUser());
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUser(user);
        userResponseDTO.setMessage("Successfully added the user");
        userResponseDTO.setStatusCode(200);
        return ResponseEntity.ok().body(userResponseDTO);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<UserResponseDTO> updateUserDetails(@RequestBody UserDTO userDTO) {
        User user =  userService.updateUser(userDTO.getUser());
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUser(user);
        userResponseDTO.setMessage("Successfully updated the user");
        userResponseDTO.setStatusCode(200);
        return ResponseEntity.ok().body(userResponseDTO);
    }

    @GetMapping("/userById")
    public ResponseEntity<UserResponseDTO> getById(@RequestBody UserDTO userDTO) {
        User user = userService.getUser(userDTO.getUser().getUserId());
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUser(user);
        userResponseDTO.setMessage("Successfully retrieved the user");
        userResponseDTO.setStatusCode(200);
        return ResponseEntity.ok().body(userResponseDTO);
    }

    public void deleteUser(@RequestBody UserDTO userDTO) {
        userService.deleteUser(userDTO.getUser().getUserId());
    }

}
