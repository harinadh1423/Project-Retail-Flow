package com.project.retailproject.controller;

import com.project.retailproject.dto.PaymentDTO;
import com.project.retailproject.dto.PaymentResponseDTO;
import com.project.retailproject.model.Payment;
import com.project.retailproject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/insertPayment")
    public ResponseEntity<PaymentResponseDTO> insertPayment(@RequestBody PaymentDTO paymentDTO) {
        Payment p = paymentService.insertPayment(paymentDTO.getPayment());
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.setPayment(p);
        dto.setStatusCode(201);
        dto.setMessage("Payment created successfully");
        return ResponseEntity.status(201).body(dto);
    }

    @PutMapping("/updatePayment")
    public ResponseEntity<PaymentResponseDTO> updatePayment(@RequestBody PaymentDTO paymentDTO) {
        Payment p = paymentService.updatePayment(paymentDTO.getPayment());
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.setPayment(p);
        dto.setStatusCode(200);
        dto.setMessage("Payment updated successfully");
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/getPayment/{id}")
    public ResponseEntity<PaymentResponseDTO> getPayment(@PathVariable Long id) {
        Payment p = paymentService.getPayment(id);
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.setPayment(p);
        dto.setStatusCode(200);
        dto.setMessage("Found payment with ID: " + id);
        return ResponseEntity.status(200).body(dto);
    }

    @DeleteMapping("/deletePayment/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return "Payment with ID deleted successfully";
    }

    @GetMapping("/getAllPayments")
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.status(200).body(payments);
    }

    @GetMapping("/fetchAllPagination")
    public ResponseEntity<Page<Payment>> getAllPaymentsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "paymentId") String sorting,
            @RequestParam(defaultValue = "true") boolean asc
    ){
        Sort sort = asc
                ? Sort.by(sorting).ascending()
                : Sort.by(sorting).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Payment> payments = paymentService.getAllPaymentsPaginated(pageable);

        return ResponseEntity.ok(payments);
    }


}
