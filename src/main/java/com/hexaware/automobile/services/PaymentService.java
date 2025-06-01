package com.hexaware.automobile.services;

import com.hexaware.automobile.dtos.PaymentDTO;

import java.util.List;

public interface PaymentService {
    PaymentDTO createPayment(PaymentDTO dto);
    PaymentDTO getPaymentById(Long id);
    PaymentDTO getPaymentByQuoteId(Long quoteId);
    PaymentDTO updatePayment(Long id, PaymentDTO paymentDTO);
    List<PaymentDTO> getAllPayments();
    void deletePayment(Long id);
}
