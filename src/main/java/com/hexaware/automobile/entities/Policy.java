package com.hexaware.automobile.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "policies")
public class Policy {
    public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Policy(Integer policyId, String pname, String pdescription, BigDecimal basePremium, String ptype,
			List<Proposal> proposals, List<Claim> claims) {
		super();
		this.policyId = policyId;
		this.pname = pname;
		this.pdescription = pdescription;
		this.basePremium = basePremium;
		this.ptype = ptype;
		this.proposals = proposals;
		this.claims = claims;
	}

	public Integer getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdescription() {
		return pdescription;
	}

	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}

	public BigDecimal getBasePremium() {
		return basePremium;
	}

	public void setBasePremium(BigDecimal basePremium) {
		this.basePremium = basePremium;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public List<Proposal> getProposals() {
		return proposals;
	}

	public void setProposals(List<Proposal> proposals) {
		this.proposals = proposals;
	}

	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer policyId;

    private String pname;

    @Column(columnDefinition = "TEXT")
    private String pdescription;

    private BigDecimal basePremium;

    private String ptype;

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private List<Proposal> proposals;

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private List<Claim> claims;
}
