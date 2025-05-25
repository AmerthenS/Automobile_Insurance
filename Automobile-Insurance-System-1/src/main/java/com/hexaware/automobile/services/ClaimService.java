package com.hexaware.automobile.services;

import com.hexaware.automobile.entity.Claim;
import com.hexaware.automobile.entity.ClaimStatus;

import java.util.List;

public interface ClaimService {
    Claim fileClaim(Claim claim);
    List<Claim> getClaimsByUser(Integer user_id);
    List<Claim> getClaimsByStatus(ClaimStatus cstatus);
    Claim getClaimById(Integer claim_id);
}
