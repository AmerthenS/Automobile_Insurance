package com.hexaware.automobile.dtos;

import com.hexaware.automobile.entities.ClaimStatus;

import java.time.LocalDateTime;

public class ClaimDTO {

    private Integer claimId;
    private Integer policyId;
    private Integer userId;
    private String cdescription;
    private ClaimStatus cstatus;
    private LocalDateTime createdAt;

    public ClaimDTO() {}

    // Getters and Setters
    public Integer getClaimId() { return claimId; }
    public void setClaimId(Integer claimId) { this.claimId = claimId; }

    public Integer getPolicyId() { return policyId; }
    public void setPolicyId(Integer policyId) { this.policyId = policyId; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getCdescription() { return cdescription; }
    public void setCdescription(String cdescription) { this.cdescription = cdescription; }

    public ClaimStatus getCstatus() { return cstatus; }
    public void setCstatus(ClaimStatus cstatus) { this.cstatus = cstatus; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
