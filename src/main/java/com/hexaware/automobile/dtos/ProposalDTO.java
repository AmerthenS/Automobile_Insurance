package com.hexaware.automobile.dtos;

import java.time.LocalDateTime;

public class ProposalDTO {
    private Integer proposalId;
    private Integer userId;       // reference to User
    private Integer policyId;     // reference to Policy
    private String vehicleType;
    private String vehicleModel;
    private String prstatus;      // enum as String
    private LocalDateTime createdAt;
    private Integer quoteId;      // reference to Quote

    public ProposalDTO() {}

    public ProposalDTO(Integer proposalId, Integer userId, Integer policyId, String vehicleType, String vehicleModel,
                       String prstatus, LocalDateTime createdAt, Integer quoteId) {
        this.proposalId = proposalId;
        this.userId = userId;
        this.policyId = policyId;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.prstatus = prstatus;
        this.createdAt = createdAt;
        this.quoteId = quoteId;
    }

    // Getters and Setters

    public Integer getProposalId() { return proposalId; }
    public void setProposalId(Integer proposalId) { this.proposalId = proposalId; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public Integer getPolicyId() { return policyId; }
    public void setPolicyId(Integer policyId) { this.policyId = policyId; }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public String getVehicleModel() { return vehicleModel; }
    public void setVehicleModel(String vehicleModel) { this.vehicleModel = vehicleModel; }

    public String getPrstatus() { return prstatus; }
    public void setPrstatus(String prstatus) { this.prstatus = prstatus; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Integer getQuoteId() { return quoteId; }
    public void setQuoteId(Integer quoteId) { this.quoteId = quoteId; }
}
