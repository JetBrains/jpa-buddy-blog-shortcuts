package com.example.blog.controllers;


import com.example.blog.dtos.UserDto;
import com.example.blog.entities.User;
import com.example.blog.mappers.UserMapper;
import com.example.blog.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserController(UserRepository userRepository,
                          UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @GetMapping("/users/{lastname}")
    public List<UserDto> findByName(@PathVariable String lastname){
        List<User> userList = userRepository.findByLastname(lastname);
        return userList.stream().map(userMapper::toDto).collect(Collectors.toList());
    }
}
