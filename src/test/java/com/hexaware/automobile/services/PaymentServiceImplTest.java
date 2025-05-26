package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.Payment;
import com.hexaware.automobile.entities.PaymentStatus;
import com.hexaware.automobile.services.impl.PaymentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PaymentServiceImplTest {

    @Autowired
    private PaymentServiceImpl paymentService;

    @Test
    public void testGetPaymentByIdFromDB() {
        int existingPaymentId = 1;  // Replace with an actual paymentId from your DB
        Payment payment = paymentService.getPaymentById(existingPaymentId);
        assertNotNull(payment, "Payment should exist in DB");
        assertEquals(existingPaymentId, payment.getPaymentId());
    }

    @Test
    public void testGetPaymentsByStatusFromDB() {
        PaymentStatus status = PaymentStatus.pending;  // Use a status you know exists in DB
        List<Payment> payments = paymentService.getPaymentsByStatus(status);
        assertNotNull(payments, "List of payments should not be null");
        assertFalse(payments.isEmpty(), "Payments list should not be empty for status: " + status);
        for (Payment payment : payments) {
            assertEquals(status, payment.getPmstatus());
        }
    }

    @Test
    public void testSavePayment() {
        // For save test, you need to set a valid Quote object, here assuming you mock or set null for simplicity
        Payment payment = new Payment();
        // You might want to set a valid Quote here if DB constraints require it.
        payment.setAmountPaid(new BigDecimal("2500"));
        payment.setPaidAt(LocalDateTime.now());
        payment.setPmstatus(PaymentStatus.completed);

        Payment saved = paymentService.savePayment(payment);
        assertNotNull(saved.getPaymentId(), "Saved payment should have an ID");
        assertEquals(new BigDecimal("2500"), saved.getAmountPaid());
        assertEquals(PaymentStatus.completed, saved.getPmstatus());
    }
}
