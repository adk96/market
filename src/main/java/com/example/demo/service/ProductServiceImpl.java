package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        try {
           return productRepository.getById(id);
        }catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product edit(Product newProduct, Long id) {
        Product oldProduct = null;
        try {
            oldProduct  = productRepository.getById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setCount(newProduct.getPrice());
        oldProduct.setDescription(newProduct.getDescription());
        oldProduct.setTitle(newProduct.getTitle());
        productRepository.save(oldProduct);
        return oldProduct;
    }

    @Override
    public String deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return "Во время удаления даннеых произошла ошибка";
        }
        return "Обьект с id " + id + " успешно удален";
    }
}
