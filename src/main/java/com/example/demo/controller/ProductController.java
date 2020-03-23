package com.example.demo.controller;


import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @GetMapping("/get/all")
    public List<Product> getAllProducts(){return productService.getAll();}

    @GetMapping("/get/{id}")
    public Product getById(@PathVariable ("id") Long id) {return productService.getById(id);}

    @PostMapping("/save")
    public Product saveNew(@RequestBody Product product) {return productService.create(product);}

    @PutMapping("/edit/{id}")
    public Product editById(@RequestBody Product product, @PathVariable ("id") Long id) {return productService.edit(product, id);}

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable ("id") Long id) {return productService.deleteProduct(id);}

}
