package com.bog.bogProject.service.impl;

import com.bog.bogProject.entity.Vaccine;
import com.bog.bogProject.model.request.VaccineRequest;
import com.bog.bogProject.model.response.VaccineResponse;
import com.bog.bogProject.repository.VaccineRepository;
import com.bog.bogProject.service.VaccineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService {


    @Value("${vaccine.description.url}")
    private String vaccineDescUrl;

    private VaccineRepository vaccineRepository;

    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(VaccineServiceImpl.class);

    @Override
    public VaccineResponse createVaccine(VaccineRequest request) {
        Vaccine vaccine = new Vaccine();
        vaccine.setCompany(request.getCompany());
        vaccine.setCount(request.getCount());
        vaccine.setName(request.getName());
        vaccineRepository.save(vaccine);
        return new VaccineResponse(vaccine);
    }

    @Override
    public List<Vaccine> getVaccines() {
        return vaccineRepository.findAll();
    }

    @Override
    public void deleteVaccine(Long id) {
        vaccineRepository.delete(vaccineRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no vaccine with that id")));
    }

    @Override
    public VaccineResponse updateVaccine(Long id, VaccineRequest request) {
        Vaccine vaccine = vaccineRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no vaccine with that id"));
        if (request.getCompany() != null)
            vaccine.setCompany(request.getCompany());
        if (request.getCount() != 0)
            vaccine.setCount(request.getCount());
        if (request.getName() != null)
            vaccine.setName(request.getName());
        return new VaccineResponse(vaccineRepository.save(vaccine));
    }

    @Override
    public Object getVaccineDescription(String name) {
        String url = String.format("%s/%s", vaccineDescUrl, name);
        ResponseEntity<Object> responseEntity =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        }
                );
        try {
            Object object = responseEntity.getBody();
            return object;
        } catch (Exception e) {
            logger.error("Exception:", e.getMessage());
            return null;
        }
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setVaccineRepository(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }
}
