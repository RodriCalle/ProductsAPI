package com.example.newapi.resource;

public class UserResource {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    public Long getId() {
        return id;
    }

    public UserResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserResource setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserResource setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserResource setPassword(String password) {
        this.password = password;
        return this;
    }
}
