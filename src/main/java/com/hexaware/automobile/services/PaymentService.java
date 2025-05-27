package com.hexaware.automobile.services;

import com.hexaware.automobile.dtos.PaymentDTO;
import com.hexaware.automobile.entities.PaymentStatus;

import java.util.List;

public interface PaymentService {
    PaymentDTO savePayment(PaymentDTO paymentDTO);  

    PaymentDTO getPaymentById(Integer id);
    List<PaymentDTO> getAllPayments();
    List<PaymentDTO> getPaymentsByStatus(PaymentStatus status);

    void deletePaymentById(Integer id);
}
