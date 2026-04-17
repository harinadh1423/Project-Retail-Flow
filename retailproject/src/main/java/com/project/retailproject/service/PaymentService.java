package com.project.retailproject.service;

import com.project.retailproject.db.PaymentRepository;
import com.project.retailproject.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment insertPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePayment(int id) {
        paymentRepository.deleteById((long) id);
    }

    public Payment getPayment(int id) {
        return paymentRepository.findById((long) id).orElse(null);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}


