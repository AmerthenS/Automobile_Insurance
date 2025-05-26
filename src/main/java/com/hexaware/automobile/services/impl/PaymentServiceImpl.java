package com.hexaware.automobile.services.impl;

import com.hexaware.automobile.entities.Payment;
import com.hexaware.automobile.entities.PaymentStatus;
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
    public Payment savePayment(Payment payment) {
        return paymentRepo.save(payment);
    }

   
    @Override
    public Payment getPaymentById(Integer id) {
        return paymentRepo.findById(id).orElse(null);
    }

    
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

   
    @Override
    public List<Payment> getPaymentsByStatus(PaymentStatus status) {
        return paymentRepo.findByPmstatus(status);
    }

    
    @Override
    public void deletePaymentById(Integer id) {
        paymentRepo.deleteById(id);
    }
}
