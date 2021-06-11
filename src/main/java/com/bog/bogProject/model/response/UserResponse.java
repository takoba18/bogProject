package com.bog.bogProject.model.response;

import com.bog.bogProject.entity.User;
import com.bog.bogProject.model.request.UserRequest;

public class UserResponse extends UserRequest {

    private Long id;

    public UserResponse(User user) {
        super(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPersonalId(),
                user.getPhone(), user.getBirthdate(), user.getVaccineId());
        id = user.getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
