package com.hexaware.automobile.services;

import com.hexaware.automobile.dtos.ClaimDTO;
import com.hexaware.automobile.entities.ClaimStatus;

import java.util.List;

public interface ClaimService {
    ClaimDTO fileClaim(ClaimDTO claimDTO);
    List<ClaimDTO> getClaimsByUser(Integer userId);
    List<ClaimDTO> getClaimsByStatus(ClaimStatus status);
    ClaimDTO getClaimById(Integer id);
    ClaimDTO submitClaim(ClaimDTO claimDTO);
    ClaimDTO updateClaim(Integer claimId, ClaimDTO claimDTO);
    List<ClaimDTO> getAllClaims();

}
