package com.hexaware.automobile.services.impl;

import com.hexaware.automobile.dtos.PaymentDTO;
import com.hexaware.automobile.entities.Payment;
import com.hexaware.automobile.entities.PaymentStatus;
import com.hexaware.automobile.entities.Quote;
import com.hexaware.automobile.repositories.PaymentRepository;
import com.hexaware.automobile.repositories.QuoteRepository;
import com.hexaware.automobile.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;

    @Autowired
    private QuoteRepository quoteRepo;

    // Convert entity to DTO
    private PaymentDTO toDTO(Payment payment) {
        PaymentDTO dto = new PaymentDTO();
        dto.setPaymentId(payment.getPaymentId());
        dto.setQuoteId(payment.getQuote() != null ? payment.getQuote().getQuoteId() : null);
        dto.setPaidAt(payment.getPaidAt());
        dto.setAmountPaid(payment.getAmountPaid());
        dto.setPmstatus(payment.getPmstatus());
        return dto;
    }

    // Convert DTO to entity
    private Payment toEntity(PaymentDTO dto) {
        Payment payment = new Payment();
        payment.setPaymentId(dto.getPaymentId());

        if (dto.getQuoteId() != null) {
            Quote quote = quoteRepo.findById(dto.getQuoteId())
                .orElseThrow(() -> new RuntimeException("Quote not found with id: " + dto.getQuoteId()));
            payment.setQuote(quote);
        } else {
            payment.setQuote(null);
        }

        payment.setPaidAt(dto.getPaidAt() != null ? dto.getPaidAt() : null);
        payment.setAmountPaid(dto.getAmountPaid());
        payment.setPmstatus(dto.getPmstatus());
        return payment;
    }

    @Override
    public PaymentDTO savePayment(PaymentDTO paymentDTO) {
        Payment payment = toEntity(paymentDTO);
        Payment saved = paymentRepo.save(payment);
        return toDTO(saved);
    }

    @Override
    public PaymentDTO getPaymentById(Integer id) {
        return paymentRepo.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        return paymentRepo.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentDTO> getPaymentsByStatus(PaymentStatus status) {
        return paymentRepo.findByPmstatus(status).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePaymentById(Integer id) {
        paymentRepo.deleteById(id);
    }
}
