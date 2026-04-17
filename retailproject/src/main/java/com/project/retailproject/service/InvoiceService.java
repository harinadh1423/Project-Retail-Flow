package com.project.retailproject.service;

import com.project.retailproject.db.InvoiceRepository;
import com.project.retailproject.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return invoiceRepository.findById(id).get();
    }
    public List<Invoice> findAllInvoice(Invoice invoice){
        return invoiceRepository.findAll();
    }
}
