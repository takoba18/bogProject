package com.bog.bogProject.service;

import com.bog.bogProject.entity.User;
import com.bog.bogProject.model.request.UserRequest;
import com.bog.bogProject.model.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest request);

    List<User> getUsers();

    void deleteUser(Long id);

    UserResponse updateUser(Long id, UserRequest request);

}
