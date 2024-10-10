package com.spring_shop_backend.repository;

import com.spring_shop_backend.model.ProductModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProductRepository {

    private final Logger log = LoggerFactory.getLogger(ProductRepository.class);
    private final RowMapper<ProductModel> rowMapper = (rs, rowNum) ->
            new ProductModel(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getString("image1"),
                    rs.getString("image2"),
                    rs.getString("image3")
            );
    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        log.info("ProductRepository instantiated");
    }

    public List<ProductModel> getAll() {
        List<ProductModel> products = jdbcTemplate.query("SELECT * FROM products", rowMapper);
        log.info("[Get All]: {}", products);
        return products;
    }

    public ProductModel findById(Long id) {
        ProductModel productModel = jdbcTemplate.queryForObject("SELECT * FROM products WHERE id = ?", rowMapper, id);
        log.info("[Find By Id]: {}", productModel);
        return productModel;
    }

    public ProductModel findByName(String name) {
        ProductModel productModel = jdbcTemplate.queryForObject("SELECT * FROM products WHERE name = ?", rowMapper, name);
        log.info("[Find By Name]: {}", productModel);
        return productModel;
    }

    public void save(ProductModel productModel) {
       try{
           int insert;
           if (productModel.getId() == null) {
               insert = jdbcTemplate.update("INSERT INTO products (name,description,price,image1,image2,image3) VALUES (?,?,?,?,?,?)",
                       productModel.getName(),productModel.getDescription(),productModel.getPrice()
                       ,productModel.getImage1(),productModel.getImage2(),productModel.getImage3());
           }
           else {
               insert = jdbcTemplate.update("UPDATE products SET name = ?, description = ?, price = ?, image1 = ?, image2 = ?, image3 = ? WHERE id = ?",
                       productModel.getName(), productModel.getDescription(), productModel.getPrice(),
                       productModel.getImage1(), productModel.getImage2(), productModel.getImage3(), productModel.getId());
           }
           log.info("[Save]: {}", insert);
       }catch (Exception e) {log.error(e.getMessage());}
    }

    public void delete(Long id) {
        int delete = jdbcTemplate.update("DELETE FROM products WHERE id = ?", id);
        log.info("[Delete]: {}", delete);
    }
}
