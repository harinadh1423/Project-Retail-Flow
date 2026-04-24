package com.project.retailproject.service;

import com.project.retailproject.db.InvoiceRepository;
import com.project.retailproject.model.Invoice;
import com.project.retailproject.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;
    public Invoice insertInvoice(Invoice invoice){

        return invoiceRepository.save(invoice);
    }

    public Invoice updateInvoice(Invoice invoice){

        return invoiceRepository.save(invoice);
    }
    public void deleteInvoice(Long id){

        invoiceRepository.deleteById(id);
    }

    public Invoice findInvoiceById(Long id){
        return invoiceRepository.findById(id).orElseThrow(()->new RuntimeException("Invoice not found with ID: "+id));
    }
    public List<Invoice> findAllInvoice(){

        return invoiceRepository.findAll();
    }

    public Page<Invoice> getAllInvoicesPaginated(Pageable pageable) {
        return invoiceRepository.findAll(pageable);
    }

}

