package com.spring_shop_backend.controller;

import com.spring_shop_backend.model.ProductModel;
import com.spring_shop_backend.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductRepository productRepository;

    ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
        log.info("ProductController created");
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<ProductModel>> allProducts() throws IOException {
        log.info("ProductController all");
        List<ProductModel> products = productRepository.getAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/getById")
    public ResponseEntity<ProductModel> getProductById(@RequestParam("id") Long id) throws IOException {
        log.info("ProductController getProductById");
        ProductModel product = productRepository.findById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping(path = "/image")
    public ResponseEntity<byte[]> getImage() throws IOException {
        byte[] image = Files.readAllBytes(Paths.get("src/main/resources/static/images/rabbit1.jpg"));
        log.info("ProductController getImage");
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
//        return ResponseEntity.ok(image);
    }





//    void testSave()  {
//        byte[][] images = null;
//        try {
//            images = getImages();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        ProductModel pm = new ProductModel(null, "Rabbit3", "qwertyqwertyqwertyqwertyqwerty", 444.6, images[0],images[1],images[2]);
//        productRepository.save(pm);
//    }
//
//    byte[][] getImages() throws IOException {
//        List<byte[]> images = new ArrayList<>();
//        images.add(Files.readAllBytes(Paths.get("src/main/resources/static/images/rabbit1.jpg")));
//        images.add(Files.readAllBytes(Paths.get("src/main/resources/static/images/rabbit2.jpg")));
//        images.add(Files.readAllBytes(Paths.get("src/main/resources/static/images/rabbit3.jpg")));
//        return images.toArray(new byte[images.size()][]);
//    }
//
//    List<ProductModel> getProducts() throws IOException {
//        log.info("ProductController getProducts");
//        byte[][] images = getImages();
//        List<ProductModel> products = new ArrayList<>();
//        products.add(new ProductModel(1L, "prod1", "qwertyqwertyqwertyqwertyqwerty", 44.6,
//                images[0],images[1],images[2]));
//        products.add(new ProductModel(2L, "prod2", "qwertyqwertyqwertyqwertyqwerty", 414.6,
//                images[0],images[1],images[2]));
//        products.add(new ProductModel(3L, "prod3", "qwertyqwertyqwertyqwertyqwerty", 414.6,
//                images[0],images[1],images[2]));
//        products.add(new ProductModel(4L, "prod4", "qwertyqwertyqwertyqwertyqwerty", 544.6,
//                images[0],images[1],images[2]));
//        return products;
//    }
}

