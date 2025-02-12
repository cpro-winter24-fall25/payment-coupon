package net.javaguides.springboot.controller;

import net.javaguides.springboot.entity.Payment;
import net.javaguides.springboot.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    // Constructor for dependency injection
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Create Payment REST API
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment savedPayment = paymentService.createPayment(payment);
        return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
    }

    // Get Payment by ID REST API
    // Example: http://localhost:8080/api/payments/1
    @GetMapping("{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") Long paymentId) {
        Payment payment = paymentService.getPaymentById(paymentId);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    // Get All Payments REST API
    // Example: http://localhost:8080/api/payments
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    // Update Payment REST API
    @PutMapping("{id}")
    // Example: http://localhost:8080/api/payments/1
    public ResponseEntity<Payment> updatePayment(@PathVariable("id") Long paymentId,
                                                 @RequestBody Payment payment) {
        payment.setId(paymentId);
        Payment updatedPayment = paymentService.updatePayment(payment);
        return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
    }

    // Delete Payment REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePayment(@PathVariable("id") Long paymentId) {
        paymentService.deletePayment(paymentId);
        return new ResponseEntity<>("Payment successfully deleted!", HttpStatus.OK);
    }
}
