package com.hexaware.automobile.dtos;

import com.hexaware.automobile.entities.PaymentStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentDTO {
    private Integer paymentId;
    private Integer quoteId;  // We'll store just Quote ID here to avoid entity exposure
    private LocalDateTime paidAt;
    private BigDecimal amountPaid;
    private PaymentStatus pmstatus;

    // Getters & Setters
    public Integer getPaymentId() { return paymentId; }
    public void setPaymentId(Integer paymentId) { this.paymentId = paymentId; }

    public Integer getQuoteId() { return quoteId; }
    public void setQuoteId(Integer quoteId) { this.quoteId = quoteId; }

    public LocalDateTime getPaidAt() { return paidAt; }
    public void setPaidAt(LocalDateTime paidAt) { this.paidAt = paidAt; }

    public BigDecimal getAmountPaid() { return amountPaid; }
    public void setAmountPaid(BigDecimal amountPaid) { this.amountPaid = amountPaid; }

    public PaymentStatus getPmstatus() { return pmstatus; }
    public void setPmstatus(PaymentStatus pmstatus) { this.pmstatus = pmstatus; }
}
