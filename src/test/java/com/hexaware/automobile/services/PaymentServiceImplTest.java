package com.hexaware.automobile.services;

import com.hexaware.automobile.dtos.PaymentDTO;
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
        int existingPaymentId = 1;  
        PaymentDTO paymentDTO = paymentService.getPaymentById(existingPaymentId);
        assertNotNull(paymentDTO, "PaymentDTO should exist in DB");
        assertEquals(existingPaymentId, paymentDTO.getPaymentId());
    }

    @Test
    public void testGetPaymentsByStatusFromDB() {
        PaymentStatus status = PaymentStatus.pending;  
        List<PaymentDTO> payments = paymentService.getPaymentsByStatus(status);
        assertNotNull(payments, "List of payments should not be null");
        assertFalse(payments.isEmpty(), "Payments list should not be empty for status: " + status);
        for (PaymentDTO payment : payments) {
            assertEquals(status, payment.getPmstatus());
        }
    }

    @Test
    public void testSavePayment() {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setAmountPaid(new BigDecimal("2500"));
        paymentDTO.setPaidAt(LocalDateTime.now());
        paymentDTO.setPmstatus(PaymentStatus.completed);
        paymentDTO.setQuoteId(1); 

        PaymentDTO saved = paymentService.savePayment(paymentDTO);
        assertNotNull(saved.getPaymentId(), "Saved payment should have an ID");
        assertEquals(new BigDecimal("2500"), saved.getAmountPaid());
        assertEquals(PaymentStatus.completed, saved.getPmstatus());
    }
}
