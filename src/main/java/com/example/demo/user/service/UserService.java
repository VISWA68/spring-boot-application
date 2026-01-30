package com.example.demo.user.service;

import com.example.demo.user.dto.UserCreateRequest;
import com.example.demo.user.dto.UserResponse;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public UserResponse createUser(UserCreateRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(
            passwordEncoder.encode(request.getPassword())
        );

        User savedUser = userRepository.save(user);

        return new UserResponse(
            savedUser.getId(),
            savedUser.getName(),
            savedUser.getEmail()
        );
    }

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserResponse(
            user.getId(),
            user.getName(),
            user.getEmail()
        );
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                ))
                .toList();
    }
}

