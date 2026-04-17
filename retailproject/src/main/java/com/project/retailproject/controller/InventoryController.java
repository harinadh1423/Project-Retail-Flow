package com.project.retailproject.controller;


import com.project.retailproject.dto.InventoryDTO;
import com.project.retailproject.dto.InventoryResponseDTO;
import com.project.retailproject.model.Inventory;
import com.project.retailproject.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;


    @PostMapping("/addInventory")
    public ResponseEntity<InventoryResponseDTO> addInventory(InventoryDTO inventoryDTO) {
        Inventory inventory =inventoryService.addInventory(inventoryDTO.getInventory());
        InventoryResponseDTO inventoryResponseDTO = new InventoryResponseDTO();
        inventoryResponseDTO.setInventory(inventory);
        inventoryResponseDTO.setMessage("success");
        inventoryResponseDTO.setStatusCode(200);
        return ResponseEntity.ok(inventoryResponseDTO);
    }



    @PutMapping("/updateInventory")
    public ResponseEntity<InventoryResponseDTO> updateInventory(@RequestBody InventoryDTO inventoryDTO) {
        Inventory updatedInventory = inventoryService.updateInventory(inventoryDTO.getInventory());
        InventoryResponseDTO inventoryResponseDTO = new InventoryResponseDTO();
        inventoryResponseDTO.setInventory(updatedInventory);
        inventoryResponseDTO.setMessage("Inventory updated successfully");
        inventoryResponseDTO.setStatusCode(200);
        return ResponseEntity.ok(inventoryResponseDTO);
    }

    @PutMapping("/byInventoryId")
    public ResponseEntity<InventoryResponseDTO> getInventory(@RequestBody InventoryDTO inventoryDTO) {
        Inventory inventory = inventoryService.getInventoryById(inventoryDTO.getInventory().getInventoryId());
        InventoryResponseDTO inventoryResponseDTO = new InventoryResponseDTO();
        inventoryResponseDTO.setInventory(inventory);
        inventoryResponseDTO.setMessage("success");
        inventoryResponseDTO.setStatusCode(200);
        return  ResponseEntity.ok(inventoryResponseDTO);


    }

    @DeleteMapping("/deleteInventory")
    public ResponseEntity<InventoryResponseDTO> deleteInventory(@RequestBody InventoryDTO inventoryDTO) {
        inventoryService.deleteInventory(inventoryDTO.getInventory());
        InventoryResponseDTO inventoryResponseDTO = new InventoryResponseDTO();
        inventoryResponseDTO.setMessage("success");
        inventoryResponseDTO.setStatusCode(200);
        return ResponseEntity.ok(inventoryResponseDTO);


    }




}
