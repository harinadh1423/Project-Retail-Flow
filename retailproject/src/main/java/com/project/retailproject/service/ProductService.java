package com.project.retailproject.service;


import com.project.retailproject.db.ProductRepository;
import com.project.retailproject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
    public void deleteProduct(Product product) {
        productRepository.delete(product);

    }

    public Product getProduct(int id) {
        return productRepository.findById(id).get();
    }
}
