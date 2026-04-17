package com.project.retailproject.service;

import com.project.retailproject.db.CatalogRepository;
import com.project.retailproject.model.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {
    @Autowired
    private CatalogRepository catalogRepository;

    public Catalog insertCatalog(Catalog catalog) {
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
}
