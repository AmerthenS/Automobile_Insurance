package com.hexaware.automobile.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="quotes")
public class Quote {
    public Quote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quote(Integer quoteId, Proposal proposal, BigDecimal premiumAmount, LocalDateTime sentAt, Payment payment) {
		super();
		this.quoteId = quoteId;
		this.proposal = proposal;
		this.premiumAmount = premiumAmount;
		this.sentAt = sentAt;
		this.payment = payment;
	}

	public Integer getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(Integer quoteId) {
		this.quoteId = quoteId;
	}

	public Proposal getProposal() {
		return proposal;
	}

	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
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

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer quoteId;

    @OneToOne
    @JoinColumn(name = "proposal_id")
    private Proposal proposal;

    private BigDecimal premiumAmount;
    private LocalDateTime sentAt = LocalDateTime.now();

    @OneToOne(mappedBy = "quote", cascade = CascadeType.ALL)
    private Payment payment;

	public void setAmount(BigDecimal bigDecimal) {
		// TODO Auto-generated method stub
		
	}
}
