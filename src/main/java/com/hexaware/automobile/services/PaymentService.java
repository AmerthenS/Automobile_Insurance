package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.Payment;
import com.hexaware.automobile.entities.PaymentStatus;

import java.util.List;

public interface PaymentService {
    
    Payment savePayment(Payment payment);  

    // Read
    Payment getPaymentById(Integer id);
    List<Payment> getAllPayments();
    List<Payment> getPaymentsByStatus(PaymentStatus status);

    
    void deletePaymentById(Integer id);
}
