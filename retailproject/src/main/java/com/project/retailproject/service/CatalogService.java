package com.project.retailproject.service;

import com.project.retailproject.db.CatalogRepository;
import com.project.retailproject.db.ProductRepository;
import com.project.retailproject.model.Catalog;
import com.project.retailproject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {
    @Autowired
    private CatalogRepository catalogRepository;

    @Autowired
    private ProductRepository productRepository;

    public Catalog insertCatalog(Catalog catalog) {
        Integer pid = catalog.getProduct().getProductId();
        Product existingProduct = productRepository.findById(pid)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + pid));

        catalog.setProduct(existingProduct);
        return catalogRepository.save(catalog);
    }


    public Catalog updateCatalog(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    public void deleteCatalog(Long id) {
         catalogRepository.deleteById(id);
    }

    public Catalog getCatalogById(Long id) {
        return catalogRepository.findById(id).get();
    }
    public List<Catalog> getAllCatalog() {
        return catalogRepository.findAll();
    }

    public Page<Catalog> getAllCatalogsWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return catalogRepository.findAll(pageable);
    }
}
