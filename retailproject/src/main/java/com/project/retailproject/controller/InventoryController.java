package com.project.retailproject.controller;


import com.project.retailproject.dto.InventoryDTO;
import com.project.retailproject.dto.InventoryResponseDTO;
import com.project.retailproject.model.Inventory;
import com.project.retailproject.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;


    @PostMapping("/addInventory")
    public ResponseEntity<InventoryResponseDTO> addInventory(@RequestBody InventoryDTO inventoryDTO) {
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



    @DeleteMapping("/deleteInventory/{inventoryId}")
    public String deleteInventory(@PathVariable Long inventoryId) {
        inventoryService.deleteInventory(inventoryId);
        return "inventory  deleted successfully";
    }
    @GetMapping("/fetch/{inventoryId}")
    public ResponseEntity<InventoryResponseDTO> getInventoryById(@PathVariable Long inventoryId){
        Inventory fetchdata=inventoryService.getInventoryById(inventoryId);
        InventoryResponseDTO dto=new InventoryResponseDTO();
        dto.setMessage("inventory with id"+inventoryId +"fetched successfully");
        dto.setStatusCode(200);
        dto.setInventory(fetchdata);
        return  ResponseEntity.status(200).body(dto);

    }
    @GetMapping("/fetchAll")
    public ResponseEntity<List<Inventory>> getAllInventory(){
        List<Inventory> data=inventoryService.getAllInventory();
        return  ResponseEntity.status(200).body(data);
    }
    @GetMapping("/fetchAllPagination")
    public ResponseEntity<Page<Inventory>> getAllInventoryWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Inventory> inventoryPage = inventoryService.getAllInventoryWithPagination(page, size);
        return ResponseEntity.ok(inventoryPage);
    }




}
