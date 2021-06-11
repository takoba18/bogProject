package com.bog.bogProject.service.impl;

import com.bog.bogProject.entity.User;
import com.bog.bogProject.entity.Vaccine;
import com.bog.bogProject.model.request.UserRequest;
import com.bog.bogProject.model.response.UserResponse;
import com.bog.bogProject.repository.UserRepository;
import com.bog.bogProject.repository.VaccineRepository;
import com.bog.bogProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private VaccineRepository vaccineRepository;

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = new User();
        Vaccine vaccine = vaccineRepository.findById(request.getVaccineId()).orElseThrow(() -> new RuntimeException("There is no vaccine with that id"));
        if (vaccine.getCount() == 0)
            throw new NullPointerException("We are out of this vaccine, choose another one");
        user.setVaccineId(request.getVaccineId());
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setBirthdate(request.getBirthdate());
        user.setPersonalId(request.getPersonalId());
        user.setPhone(request.getPhone());
        user = userRepository.save(user);
        long count = vaccine.getCount();
        vaccine.setCount(count - 1);
        return new UserResponse(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(userRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no user with that id")));
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no user with that id"));
        Vaccine vaccine = vaccineRepository.findById(request.getVaccineId()).orElseThrow(() -> new RuntimeException("There is no vaccine with that id"));
        if (request.getFirstName() != null) {
            user.setFirstName(request.getFirstName());
        }
        if (request.getLastName() != null) {
            user.setLastName(request.getLastName());
        }
        if (request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }
        if (request.getPersonalId() != null) {
            user.setPersonalId(request.getPersonalId());
        }
        if (request.getPhone() != null) {
            user.setPhone(request.getPhone());
        }
        if (request.getBirthdate() != null) {
            user.setBirthdate(request.getBirthdate());
        }
        if (request.getVaccineId() != null && !request.getVaccineId().equals(user.getVaccineId())) {
            long count = vaccine.getCount();
            if (count != 0) {
                user.setVaccineId(request.getVaccineId());
                vaccine.setCount(count - 1);
            } else
                throw new NullPointerException("We are out of that vaccine, choose another one");
        }
        return new UserResponse(userRepository.save(user));
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setVaccineRepository(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }
}
