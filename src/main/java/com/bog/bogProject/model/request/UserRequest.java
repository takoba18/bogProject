package com.bog.bogProject.model.request;

public class UserRequest {
    private String firstName;

    private String lastName;

    private String email;

    private String personalId;

    private String phone;

    private String birthdate;

    private Long vaccineId;

    public UserRequest() {
    }

    public UserRequest(String firstName, String lastName, String email, String personalId, String phone, String birthdate, Long vaccineId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.personalId = personalId;
        this.phone = phone;
        this.birthdate = birthdate;
        this.vaccineId = vaccineId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Long getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Long vaccineId) {
        this.vaccineId = vaccineId;
    }
}
