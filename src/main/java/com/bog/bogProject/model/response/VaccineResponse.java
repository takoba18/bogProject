package com.bog.bogProject.model.response;

import com.bog.bogProject.entity.Vaccine;
import com.bog.bogProject.model.request.VaccineRequest;

public class VaccineResponse extends VaccineRequest {
    private Long id;

    public VaccineResponse(Vaccine vaccine) {
        super(vaccine.getName(), vaccine.getCount(), vaccine.getCompany());
        id = vaccine.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
