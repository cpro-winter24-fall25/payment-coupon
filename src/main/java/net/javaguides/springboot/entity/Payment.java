package net.javaguides.springboot.entity;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private double amountPaid;

    @Temporal(TemporalType.DATE)  // Ensures only the date is stored
    @Column(nullable = false)
    private Date paymentDate;

    @Column(nullable = false)
    private double taxAmount;

    // No-argument constructor
    public Payment() {
    }

    // All-argument constructor
    public Payment(Long id, String paymentMethod, double amountPaid, Date paymentDate, double taxAmount) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
        this.taxAmount = taxAmount;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }
}