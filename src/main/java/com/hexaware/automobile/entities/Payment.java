package com.hexaware.automobile.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="payments")
public class Payment {
    public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Integer paymentId, Quote quote, LocalDateTime paidAt, BigDecimal amountPaid,
			PaymentStatus pmstatus) {
		super();
		this.paymentId = paymentId;
		this.quote = quote;
		this.paidAt = paidAt;
		this.amountPaid = amountPaid;
		this.pmstatus = pmstatus;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	public LocalDateTime getPaidAt() {
		return paidAt;
	}

	public void setPaidAt(LocalDateTime paidAt) {
		this.paidAt = paidAt;
	}

	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	public PaymentStatus getPmstatus() {
		return pmstatus;
	}

	public void setPmstatus(PaymentStatus pmstatus) {
		this.pmstatus = pmstatus;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @OneToOne
    @JoinColumn(name = "quote_id")
    private Quote quote;

    private LocalDateTime paidAt = LocalDateTime.now();
    private BigDecimal amountPaid;

    @Enumerated(EnumType.STRING)
    private PaymentStatus pmstatus = PaymentStatus.pending;
}
