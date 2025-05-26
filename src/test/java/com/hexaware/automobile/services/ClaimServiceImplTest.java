package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.Claim;
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
        Claim claim = claimService.getClaimById(existingClaimId);

        assertNotNull(claim, "Claim with ID " + existingClaimId + " should exist in the database");
    }

    @Test
    public void testGetClaimsByStatus() {
        ClaimStatus status = ClaimStatus.submitted; 
        List<Claim> claims = claimService.getClaimsByStatus(status);

        assertNotNull(claims);
        assertFalse(claims.isEmpty(), "There should be claims with status " + status);
        for (Claim claim : claims) {
            assertEquals(status, claim.getCstatus(), "Claim status should match the queried status");
        }
    }

    @Test
    public void testGetClaimsByUser() {
        int userId = 1; 
        List<Claim> claims = claimService.getClaimsByUser(userId);

        assertNotNull(claims);
        assertFalse(claims.isEmpty(), "There should be claims for user id " + userId);
        for (Claim claim : claims) {
            assertEquals(userId, claim.getUser().getUserId(), "Claim user id should match the queried user id");
        }
    }

}
