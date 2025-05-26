package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.Claim;
import com.hexaware.automobile.entities.ClaimStatus;

import java.util.List;

public interface ClaimService {
    Claim fileClaim(Claim claim);
    List<Claim> getClaimsByUser(Integer userId);
    List<Claim> getClaimsByStatus(ClaimStatus status);
    Claim getClaimById(Integer id);
	Claim submitClaim(Claim claim);
}
