package com.bog.bogProject.controller;

import com.bog.bogProject.entity.User;
import com.bog.bogProject.model.request.UserRequest;
import com.bog.bogProject.model.response.UserResponse;
import com.bog.bogProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id,
                                   @RequestBody UserRequest request) {

        return userService.updateUser(id, request);
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

