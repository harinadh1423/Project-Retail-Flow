package com.project.retailproject.controller;

import com.project.retailproject.dto.SaleDTO;
import com.project.retailproject.dto.SaleResponseDTO;
import com.project.retailproject.model.Sale;
import com.project.retailproject.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleservice;



    @PostMapping("/insert")
    public ResponseEntity<SaleResponseDTO> insertSale(@RequestBody SaleDTO saleDTO){
        Sale s=this.saleservice.insertSale(saleDTO.getSale());
        SaleResponseDTO dto=new SaleResponseDTO();
        dto.setSale(s);
        dto.setStatusCode(201);
        dto.setMessage("Sale created successfully.");
        return ResponseEntity.status(201).body(dto);
    }

    @PutMapping("/update")
    public ResponseEntity<SaleResponseDTO> updateSale(@RequestBody SaleDTO saleDTO){
        Sale s=this.saleservice.updateSale(saleDTO.getSale());
        SaleResponseDTO dto=new SaleResponseDTO();
        dto.setSale(s);
        dto.setStatusCode(200);
        dto.setMessage("Sale updated successfully.");
        return ResponseEntity.status(200).body(dto);
    }

    @DeleteMapping("/delete/{saleId}")
    public ResponseEntity<String> deleteSale(@PathVariable Long saleId) {
        saleservice.deleteSale(saleId);
        return ResponseEntity.ok().body("Sale deleted successfully.");
    }

    @GetMapping("/fetch/{saleId}")
    public ResponseEntity<SaleResponseDTO> getSale(@PathVariable Long saleId ) {
        Sale s = saleservice.getSaleById(saleId);
        SaleResponseDTO dto = new SaleResponseDTO();
        dto.setSale(s);
        dto.setStatusCode(200);
        dto.setMessage("Found sale with ID: " + saleId);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<Sale>> getAllSales() {
        List<Sale> sales = saleservice.getAllSales();
        return ResponseEntity.ok().body(sales);
    }



    @GetMapping("/fetchAllPagination")
    public ResponseEntity<Page<Sale>> getAllSalesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "saleId") String sorting,
            @RequestParam(defaultValue = "true") boolean asc
    ) {
        Sort sort = asc
                ? Sort.by(sorting).ascending()
                : Sort.by(sorting).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Sale> sales = saleservice.getAllSalesPaginated(pageable);

        return ResponseEntity.ok(sales);
    }







}
