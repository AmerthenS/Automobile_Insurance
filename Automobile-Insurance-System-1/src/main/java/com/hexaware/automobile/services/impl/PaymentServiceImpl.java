package com.hexaware.automobile.services.impl;

import com.hexaware.automobile.entity.Payment;
import com.hexaware.automobile.entity.PaymentStatus;
import com.hexaware.automobile.repositories.PaymentRepository;
import com.hexaware.automobile.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;

    @Override
    public Payment makePayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    @Override
    public List<Payment> getPaymentsByStatus(PaymentStatus pmstatus) {
        return paymentRepo.findByPmstatus(pmstatus);
    }

    @Override
    public Payment getPaymentById(Integer payment_id) {
        return paymentRepo.findById(payment_id).orElse(null);
    }
}
