package com.project.retailproject.service;


import com.project.retailproject.db.InventoryRepository;
import com.project.retailproject.db.ProductRepository;
import com.project.retailproject.model.Inventory;
import com.project.retailproject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public Inventory addInventory(Inventory inventory) {
        Integer pid = inventory.getProduct().getProductId();
        Product existingProduct = productRepository.findById(pid)
                .orElseThrow(() -> new RuntimeException("Inventory not found with id: " + pid));

        inventory.setProduct(existingProduct);
        return inventoryRepository.save(inventory);
    }
    public Inventory updateInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public void deleteInventory(Long inventoryId) {
        inventoryRepository.deleteById(inventoryId);
    }

    public Inventory getInventoryById(Long inventoryId) {
        return inventoryRepository.getReferenceById(inventoryId);
    }
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }
    public Page<Inventory> getAllInventoryWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return inventoryRepository.findAll(pageable);
    }
}
