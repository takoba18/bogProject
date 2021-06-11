package com.bog.bogProject.entity;

import javax.persistence.*;

@Entity
@Table(name = "vaccines")
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private long count;

    private String company;

    public Vaccine() {
    }

    public Vaccine(String name, long count, String company) {
        this.name = name;
        this.count = count;
        this.company = company;
    }

    public long getId() {
        return id;
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
