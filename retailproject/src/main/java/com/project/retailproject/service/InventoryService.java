package com.project.retailproject.service;


import com.project.retailproject.db.InventoryRepository;
import com.project.retailproject.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }
    public Inventory updateInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public void deleteInventory(Inventory inventory) {
        inventoryRepository.delete(inventory);
    }

    public Inventory getInventoryById(Long inventoryId) {
        return inventoryRepository.getReferenceById(inventoryId);
    }
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }
}
