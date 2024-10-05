package com.spring_shop_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductModel {
    private Long id;
    private String name;
    private String description;
    private double price;
//    private byte[][] images;
    private byte[] image1;
    private byte[] image2;
    private byte[] image3;
    @Override
    public String toString() {
        return "Name: " + name + ", Description: " + description + ", Price: " + price +
                ", Image1: " + image1.length + ", Image2: " + image2.length + ", Image3: " + image3.length;
    }
}
