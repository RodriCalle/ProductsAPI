package com.example.newapi.domain.service;

import com.example.newapi.domain.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    User createUser(User user);
    User getUser(Long id);
    User updateUser(Long id, User userDetails);
    ResponseEntity<?> deleteUser(User user);

    List<User> getAllUsers();
}
