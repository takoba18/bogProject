package com.bog.bogProject.controller;

import com.bog.bogProject.entity.Vaccine;
import com.bog.bogProject.model.request.VaccineRequest;
import com.bog.bogProject.model.response.VaccineResponse;
import com.bog.bogProject.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/vaccine")
public class VaccineController {

    private VaccineService vaccineService;

    @GetMapping
    public List<Vaccine> getVaccines() {
        return vaccineService.getVaccines();
    }

    @PostMapping
    public VaccineResponse createVaccine(@RequestBody VaccineRequest request) {
        return vaccineService.createVaccine(request);
    }

    @DeleteMapping("/{id}")
    public void deleteVaccine(@PathVariable Long id) {
        vaccineService.deleteVaccine(id);
    }

    @PutMapping("/{id}")
    public VaccineResponse updateVaccine(@PathVariable Long id,
                                         @RequestBody VaccineRequest request) {
        return vaccineService.updateVaccine(id, request);
    }

    @GetMapping("{name}/description")
    public Object getVaccineDescription(@PathVariable String name) {
        return vaccineService.getVaccineDescription(name);
    }

    @Autowired
    public void setVaccineService(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

}
