package com.project.retailproject.controller;

import com.project.retailproject.dto.CatalogDTO;
import com.project.retailproject.dto.CatalogResponseDTO;
import com.project.retailproject.model.Catalog;
import com.project.retailproject.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    @PostMapping("/insertCatalog")
    public ResponseEntity<CatalogResponseDTO> addCatalog(@RequestBody CatalogDTO catalogDTO){
        Catalog catalog = catalogService.insertCatalog(catalogDTO.getCatalog());
        CatalogResponseDTO catalogResponseDTO = new CatalogResponseDTO();
        catalogResponseDTO.setCatalog(catalog);
        catalogResponseDTO.setMessage("Successfully inserted the catalog");
        catalogResponseDTO.setStatusCode(200);
        return ResponseEntity.ok().body(catalogResponseDTO);
    }
    @PutMapping("/updateCatalog")
    public ResponseEntity<CatalogResponseDTO> updateCatalog(@RequestBody CatalogDTO catalogDTO){
        Catalog catalog = catalogService.updateCatalog(catalogDTO.getCatalog());
        CatalogResponseDTO catalogResponseDTO = new CatalogResponseDTO();
        catalogResponseDTO.setCatalog(catalog);
        catalogResponseDTO.setMessage("Successfully updated the catalog");
        catalogResponseDTO.setStatusCode(200);
        return ResponseEntity.ok().body(catalogResponseDTO);
    }

    @GetMapping("/getAllCatalogs")
    public ResponseEntity<List<Catalog>> getAllCatalogs(){
        List<Catalog> catalogs = catalogService.getAllCatalog();
        return ResponseEntity.ok().body(catalogs);
    }

    @GetMapping("/getCatalog/{id}")
    public ResponseEntity<CatalogResponseDTO> getCatalogById(@PathVariable Long id){
        Catalog catalog = catalogService.getCatalogById(id);
        CatalogResponseDTO catalogResponseDTO = new CatalogResponseDTO();
        catalogResponseDTO.setCatalog(catalog);
        catalogResponseDTO.setStatusCode(200);
        catalogResponseDTO.setMessage("Successfully retrieved the catalog");
        return ResponseEntity.ok().body(catalogResponseDTO);
    }

    @DeleteMapping("/deleteCatalog/{id}")
    public ResponseEntity<String> deleteCatalog(@PathVariable Long id){
        catalogService.deleteCatalog(id);
        return ResponseEntity.ok().body("Successfully deleted the catalog");
    }
}
