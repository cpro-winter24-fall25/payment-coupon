package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.entity.Payment;
import net.javaguides.springboot.repository.PaymentRepository;
import net.javaguides.springboot.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    // Constructor for dependency injection
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        return optionalPayment.orElse(null); // Return null if payment is not found
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment updatePayment(Payment payment) {
        Optional<Payment> existingPaymentOptional = paymentRepository.findById(payment.getId());
        if (existingPaymentOptional.isPresent()) {
            Payment existingPayment = existingPaymentOptional.get();
            existingPayment.setPaymentMethod(payment.getPaymentMethod());
            existingPayment.setAmountPaid(payment.getAmountPaid());
            existingPayment.setPaymentDate(payment.getPaymentDate());
            existingPayment.setTaxAmount(payment.getTaxAmount());
            return paymentRepository.save(existingPayment);
        }
        return null; // Return null if payment is not found
    }

    @Override
    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

}
