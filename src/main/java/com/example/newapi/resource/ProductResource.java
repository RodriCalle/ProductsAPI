package com.example.newapi.resource;

import javax.persistence.Column;

public class ProductResource {
    private Long id;

    private String name;

    private String description;

    private double unit_price;

    public Long getId() {
        return id;
    }

    public ProductResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public ProductResource setUnit_price(double unit_price) {
        this.unit_price = unit_price;
        return this;
    }
}
