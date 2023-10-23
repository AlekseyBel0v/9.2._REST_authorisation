package com.belov.restauthorisation.model;

import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List <Authorities> authorities = new ArrayList<>();
    @NotBlank
    @Size(min = 2, max = 20)
    private String name;
    @NotBlank
    @Size(min = 2, max = 20)
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User add(Authorities authority) {
        this.authorities.add(authority);
        return this;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
