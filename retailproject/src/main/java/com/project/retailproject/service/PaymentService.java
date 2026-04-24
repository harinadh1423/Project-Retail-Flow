package com.project.retailproject.service;

import com.project.retailproject.db.InvoiceRepository;
import com.project.retailproject.db.PaymentRepository;
import com.project.retailproject.model.Invoice;
import com.project.retailproject.model.Payment;
import com.project.retailproject.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;

    public Payment insertPayment(Payment payment) {
        Invoice invoice= invoiceRepository.
                findById(payment.getInvoice().getInvoiceId())
                .orElseThrow(()->new RuntimeException("Invoice not found"));
        if(invoice.getStatus().equals("CANCELLED")){
            throw new RuntimeException("Cannot pay a cancelled invoice!");
        }
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Payment payment) {

        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {

        paymentRepository.deleteById(id);
    }

    public Payment getPayment(Long id) {

        return paymentRepository.findById(id).orElse(null);
    }

    public List<Payment> getAllPayments() {

        return paymentRepository.findAll();
    }

    public Page<Payment> getAllPaymentsPaginated(Pageable pageable) {
        return paymentRepository.findAll(pageable);
    }
}


