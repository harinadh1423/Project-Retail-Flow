package com.project.retailproject.controller;

import com.project.retailproject.dto.PurchaseOrderDTO;
import com.project.retailproject.dto.PurchaseOrderResponseDTO;
import com.project.retailproject.model.PurchaseOrder;
import com.project.retailproject.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @PostMapping("/insert")
    public ResponseEntity<PurchaseOrderResponseDTO> insertPurchaseOrder(@RequestBody PurchaseOrderDTO purchaseOrderDTO){
        PurchaseOrder po=this.purchaseOrderService.insertPurchaseOrder(purchaseOrderDTO.getPurchaseOrder());
        PurchaseOrderResponseDTO dto=new PurchaseOrderResponseDTO();
        dto.setPurchaseOrder(po);
        dto.setStatusCode(201);
        dto.setMessage("Purchase order inserted successfully");
        return ResponseEntity.status(201).body(dto);
    }

    @PutMapping("/update")
    public ResponseEntity<PurchaseOrderResponseDTO> updatePurchaseOrder(@RequestBody PurchaseOrderDTO purchaseOrderDTO){
        PurchaseOrder po=this.purchaseOrderService.updatePurchaseOrder(purchaseOrderDTO.getPurchaseOrder());
        PurchaseOrderResponseDTO dto=new PurchaseOrderResponseDTO();
        dto.setPurchaseOrder(po);
        dto.setStatusCode(200);
        dto.setMessage("Purchase order updated successfully.");
        return ResponseEntity.status(200).body(dto);
    }

    @DeleteMapping("/delete")
    public String deletePurchaseOrder(@PathVariable Long id){
        purchaseOrderService.deletePurchaseOrder(id);
        return "Purchase order deleted successfully";
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<PurchaseOrderResponseDTO> getPurchaseOrder(@PathVariable Long id){
        PurchaseOrder po=this.purchaseOrderService.getPurchaseOrderById(id);
        PurchaseOrderResponseDTO dto=new PurchaseOrderResponseDTO();
        dto.setPurchaseOrder(po);
        dto.setStatusCode(201);
        dto.setMessage("Found Purchase order with ID: "+id);
        return ResponseEntity.status(201).body(dto);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders(){
        List<PurchaseOrder> orders=purchaseOrderService.getAllPurchaseOrders();
        return ResponseEntity.status(200).body(orders);
    }
}
