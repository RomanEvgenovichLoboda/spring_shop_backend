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
    private byte[][] images;
}
