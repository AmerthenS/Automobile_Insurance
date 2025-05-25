package com.hexaware.automobile.services;

import com.hexaware.automobile.entity.Payment;
import com.hexaware.automobile.entity.PaymentStatus;

import java.util.List;

public interface PaymentService {
    Payment makePayment(Payment payment);
    List<Payment> getPaymentsByStatus(PaymentStatus pmstatus);
    Payment getPaymentById(Integer payment_id);
}
