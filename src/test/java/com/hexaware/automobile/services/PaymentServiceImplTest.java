package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.Payment;
import com.hexaware.automobile.entities.PaymentStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PaymentServiceImplTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    void testGetAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        assertFalse(payments.isEmpty());
    }

    @Test
    void testGetPaymentsByStatus() {
        List<Payment> payments = paymentService.getPaymentsByStatus(PaymentStatus.completed);
        assertNotNull(payments);
    }
}
