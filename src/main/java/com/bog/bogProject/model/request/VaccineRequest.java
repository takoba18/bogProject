package com.bog.bogProject.model.request;

public class VaccineRequest {
    private String name;

    private long count;

    private String company;

    public VaccineRequest() {
    }

    public VaccineRequest(String name, long count, String company) {
        this.name = name;
        this.count = count;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
