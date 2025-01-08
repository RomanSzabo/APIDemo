package com.example.APIDemo.dto;

import java.util.Date;

public class User {

    private int id;
    private String name;
    private String surname;
    private String enterpriseId;
    private Date createdAt;
    private Date modifiedAt;

    public User(int id, String name, String surname, String enterpriseId, Date createdAt, Date modifiedAt) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.enterpriseId = enterpriseId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
