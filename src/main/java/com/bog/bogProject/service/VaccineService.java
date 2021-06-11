package com.bog.bogProject.service;

import com.bog.bogProject.entity.Vaccine;
import com.bog.bogProject.model.request.VaccineRequest;
import com.bog.bogProject.model.response.VaccineResponse;

import java.util.List;

public interface VaccineService {

    VaccineResponse createVaccine(VaccineRequest request);

    List<Vaccine> getVaccines();

    void deleteVaccine(Long id);

    VaccineResponse updateVaccine(Long id, VaccineRequest request);

    Object getVaccineDescription(String name);
}
