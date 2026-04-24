package com.project.retailproject.service;



import com.project.retailproject.db.UserRepository;
import com.project.retailproject.dto.UserDTO;
import com.project.retailproject.dto.UserResponseDTO;
import com.project.retailproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User insertUser(User user) {
       return userRepository.save(user);

    }


    public User updateUser(User user) {
        return userRepository.save(user);

    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User getUser(int id) {
        return userRepository.findById(id).get();
    }

    public List<User> getUsers() {
        return userRepository.findAll();

    }

    public Page<User>  getAllUserPaginated(Pageable pageable) {
        return userRepository.findAll(pageable);
    }






}
