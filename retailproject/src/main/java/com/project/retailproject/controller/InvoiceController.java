package com.project.retailproject.controller;

import com.project.retailproject.dto.InvoiceDTO;
import com.project.retailproject.dto.InvoiceResponseDTO;
import com.project.retailproject.model.Invoice;
import com.project.retailproject.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @PostMapping("/insert")
    public ResponseEntity<InvoiceResponseDTO> insertInvoice(@RequestBody InvoiceDTO invoiceDTO){
        Invoice i=this.invoiceService.insertInvoice(invoiceDTO.getInvoice());
        InvoiceResponseDTO invoiceResponseDTO=new InvoiceResponseDTO();
        invoiceResponseDTO.setInvoice(i);
        invoiceResponseDTO.setStatusCode(201);
        invoiceResponseDTO.setMessage("Invoice Successfully Added");
        return  ResponseEntity.status(210).body(invoiceResponseDTO);

    }
    @PutMapping("/update")
    public ResponseEntity<InvoiceResponseDTO> updateInvoice(@RequestBody InvoiceDTO invoiceDTO){
        Invoice i=this.invoiceService.updateInvoice(invoiceDTO.getInvoice());
        InvoiceResponseDTO dto=new InvoiceResponseDTO();
        dto.setInvoice(i);
        dto.setStatusCode(201);
        dto.setMessage("Invoice updated Successfully");
        return ResponseEntity.status(201).body(dto);
    }
    @DeleteMapping("/delete")
    public String deleteInvoice(@PathVariable Long invoiceId){
        invoiceService.deleteInvoice(invoiceId);
        return  "Invoice deleted Successfully";
    }

    @GetMapping("/fetch/{invoiceId}")
    public ResponseEntity<InvoiceResponseDTO> findInvoiceById(@PathVariable Long invoiceId){
        Invoice i=invoiceService.findInvoiceById(invoiceId);
        InvoiceResponseDTO dto=new InvoiceResponseDTO();
        dto.setInvoice(i);
        dto.setStatusCode(200);
        dto.setMessage("Found invoice with ID: "+invoiceId);
        return ResponseEntity.status(200).body(dto);

    }
    @GetMapping("/fetchAll")
    public ResponseEntity<List<Invoice>> findAllInvoice(){
        List<Invoice> i=invoiceService.findAllInvoice();
        return ResponseEntity.status(200).body(i);
    }


}
