package com.example.newapi.resource;

import javax.persistence.Column;

public class SaveProductResource {
    private String name;

    private String description;

    private double unit_price;

    public String getName() {
        return name;
    }

    public SaveProductResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveProductResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public SaveProductResource setUnit_price(double unit_price) {
        this.unit_price = unit_price;
        return this;
    }
}
