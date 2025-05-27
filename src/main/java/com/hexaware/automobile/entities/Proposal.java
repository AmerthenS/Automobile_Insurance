package com.hexaware.automobile.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="proposals")
public class Proposal {
    public Proposal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proposal(Integer proposalId, User user, Policy policy, String vehicleType, String vehicleModel,
			ProposalStatus prstatus, LocalDateTime createdAt, Quote quote) {
		super();
		this.proposalId = proposalId;
		this.user = user;
		this.policy = policy;
		this.vehicleType = vehicleType;
		this.vehicleModel = vehicleModel;
		this.prstatus = prstatus;
		this.createdAt = createdAt;
		this.quote = quote;
	}

	public Integer getProposalId() {
		return proposalId;
	}

	public void setProposalId(Integer proposalId) {
		this.proposalId = proposalId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public ProposalStatus getPrstatus() {
		return prstatus;
	}

	public void setPrstatus(ProposalStatus prstatus) {
		this.prstatus = prstatus;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer proposalId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

    private String vehicleType;
    private String vehicleModel;

    @Enumerated(EnumType.STRING)
    private ProposalStatus prstatus = ProposalStatus.proposal_submitted;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToOne(mappedBy = "proposal", cascade = CascadeType.ALL)
    private Quote quote;
}
