package com.hexaware.automobile.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class QuoteDTO {

    private Integer quoteId;
    private Integer proposalId;
    private BigDecimal premiumAmount;
    private LocalDateTime sentAt;
    private Integer paymentId;

    public QuoteDTO() {}

    public QuoteDTO(Integer quoteId, Integer proposalId, BigDecimal premiumAmount, LocalDateTime sentAt, Integer paymentId) {
        this.quoteId = quoteId;
        this.proposalId = proposalId;
        this.premiumAmount = premiumAmount;
        this.sentAt = sentAt;
        this.paymentId = paymentId;
    }

    public Integer getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Integer quoteId) {
        this.quoteId = quoteId;
    }

    public Integer getProposalId() {
        return proposalId;
    }

    public void setProposalId(Integer proposalId) {
        this.proposalId = proposalId;
    }

    public BigDecimal getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(BigDecimal premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }
}
