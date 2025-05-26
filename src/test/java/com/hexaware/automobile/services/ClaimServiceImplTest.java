package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.Claim;
import com.hexaware.automobile.entities.User;
import com.hexaware.automobile.entities.Policy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ClaimServiceImplTest {

    @Autowired
    private ClaimService claimService;

    @Autowired
    private UserService userService;

    @Autowired
    private PolicyService policyService;

    @Test
    void testSubmitClaimWithExistingUserAndPolicy() {
        // Replace these with actual IDs present in your database
        int existingUserId = 3;
        int existingPolicyId = 3;

        Optional<User> userOpt = userService.getUserById(existingUserId);
        Optional<Policy> policyOpt = policyService.getPolicyById(existingPolicyId);

        assertTrue(userOpt.isPresent(), "User with ID " + existingUserId + " should exist in DB");
        assertTrue(policyOpt.isPresent(), "Policy with ID " + existingPolicyId + " should exist in DB");

        Claim claim = new Claim();
        claim.setUser(userOpt.get());
        claim.setPolicy(policyOpt.get());
        claim.setCdescription("Database claim test");

        Claim savedClaim = claimService.submitClaim(claim);
        assertNotNull(savedClaim);
        assertNotNull(savedClaim.getClaimId());
        System.out.println("Saved claim ID: " + savedClaim.getClaimId());
    }

    @Test
    void testGetClaimsByUser() {
        int existingUserId = 3; 

        List<Claim> claims = claimService.getClaimsByUser(existingUserId);
        assertNotNull(claims);
        System.out.println("Total claims for user " + existingUserId + ": " + claims.size());
    }
}
