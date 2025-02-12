package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(Payment payment);

    Payment getPaymentById(Long paymentId);

    List<Payment> getAllPayments();

    Payment updatePayment(Payment payment);

    void deletePayment(Long paymentId);
}
