package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAll();
    public Product getById(Long id);
    public Product create(Product product);
    public Product edit(Product product, Long id);
    public String deleteProduct(Long id);
}
