package com.spring_shop_backend.controller;


import com.spring_shop_backend.model.ProductModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/products")
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    ProductController() {
        log.info("ProductController created");
    }
    byte[][] getImages() throws IOException {
        List<byte[]> images = new ArrayList<>();
        images.add(Files.readAllBytes(Paths.get("src/main/resources/static/images/rabbit1.jpg")));
        images.add(Files.readAllBytes(Paths.get("src/main/resources/static/images/rabbit2.jpg")));
        images.add(Files.readAllBytes(Paths.get("src/main/resources/static/images/rabbit3.jpg")));
        return images.toArray(new byte[images.size()][]);
    }
    List<ProductModel> getProducts() throws IOException {
        log.info("ProductController getProducts");
        List<ProductModel> products = new ArrayList<>();
        products.add(new ProductModel(1L, "prod1", "qwerty", 44.6, getImages()));
        products.add(new ProductModel(1L, "prod1", "qwerty", 44.6, getImages()));
        products.add(new ProductModel(1L, "prod1", "qwerty", 44.6, getImages()));
        products.add(new ProductModel(1L, "prod1", "qwerty", 44.6, getImages()));
        return products;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<ProductModel>> allProducts() throws IOException {
        log.info("ProductController all");
        return ResponseEntity.ok(getProducts());
    }

    @GetMapping(path = "/image")
    public ResponseEntity<byte[]> getImage() throws IOException {
        byte[] image = Files.readAllBytes(Paths.get("src/main/resources/static/images/rabbit1.jpg"));
        log.info("ProductController getImage");
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
//        return ResponseEntity.ok(image);
    }
}

