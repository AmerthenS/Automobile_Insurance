package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.Payment;
import com.hexaware.automobile.entities.PaymentStatus;

import java.util.List;

public interface PaymentService {
    Payment makePayment(Payment payment);
    List<Payment> getPaymentsByStatus(PaymentStatus status);
    Payment getPaymentById(Integer id);
	List<Payment> getAllPayments();
}
