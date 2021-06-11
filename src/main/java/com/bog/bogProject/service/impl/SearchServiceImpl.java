package com.bog.bogProject.service.impl;

import com.bog.bogProject.repository.UserRepository;
import com.bog.bogProject.repository.VaccineRepository;
import com.bog.bogProject.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SearchServiceImpl implements SearchService {
    private VaccineRepository vaccineRepository;
    private UserRepository userRepository;

    @Override
    public List<Object> search(String typed) {
        return Stream.concat(vaccineRepository.search(typed).stream(),
                userRepository.search(typed).stream()).collect(Collectors.toList());
    }

    @Autowired
    public void setVaccineRepository(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
