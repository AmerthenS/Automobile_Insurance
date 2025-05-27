package com.hexaware.automobile.services;

import com.hexaware.automobile.dtos.ClaimDTO;
import com.hexaware.automobile.entities.ClaimStatus;
import com.hexaware.automobile.services.impl.ClaimServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClaimServiceImplTest {

    @Autowired
    private ClaimServiceImpl claimService;

    @Test
    public void testGetClaimByIdFromDB() {
        int existingClaimId = 1; 
        ClaimDTO claim = claimService.getClaimById(existingClaimId);

        assertNotNull(claim, "Claim with ID " + existingClaimId + " should exist in the database");
        assertEquals(existingClaimId, claim.getClaimId(), "Claim ID should match");
    }

    @Test
    public void testGetClaimsByStatus() {
        ClaimStatus status = ClaimStatus.submitted; 
        List<ClaimDTO> claims = claimService.getClaimsByStatus(status);

        assertNotNull(claims, "Claims list should not be null");
        assertFalse(claims.isEmpty(), "There should be claims with status " + status);
        for (ClaimDTO claim : claims) {
            assertEquals(status, claim.getCstatus(), "Claim status should match the queried status");
        }
    }

    @Test
    public void testGetClaimsByUser() {
        int userId = 1; 
        List<ClaimDTO> claims = claimService.getClaimsByUser(userId);

        assertNotNull(claims, "Claims list should not be null");
        assertFalse(claims.isEmpty(), "There should be claims for user id " + userId);
        for (ClaimDTO claim : claims) {
            assertEquals(userId, claim.getUserId(), "Claim user id should match the queried user id");
        }
    }
}
