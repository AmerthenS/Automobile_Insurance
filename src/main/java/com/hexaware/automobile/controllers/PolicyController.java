package com.hexaware.automobile.controllers;

import com.hexaware.automobile.dtos.PolicyDTO;
import com.hexaware.automobile.security.CustomUserDetails;
import com.hexaware.automobile.services.PolicyService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping("/my")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<PolicyDTO>> getMyPolicies() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        // Assuming userId is stored as a claim or in principal details:
        Long userId = extractUserIdFromAuthentication(auth);
        
        List<PolicyDTO> policies = policyService.getPoliciesByUserId(userId);
        return ResponseEntity.ok(policies);
    }

    // Helper method (implement based on your JWT principal structure)
    private Long extractUserIdFromAuthentication(Authentication auth) {
        // Example if your principal is a UserDetails with getId method:
        Object principal = auth.getPrincipal();
        if (principal instanceof CustomUserDetails) {
            return ((CustomUserDetails) principal).getId();
        }
        // Or, if userId is stored in JWT claims, retrieve from there
        throw new IllegalStateException("User ID not found in authentication principal");
    }


    // OFFICERS: View all policies
    @GetMapping
    @PreAuthorize("hasRole('OFFICER')")
    public ResponseEntity<List<PolicyDTO>> getAllPolicies() {
        List<PolicyDTO> policies = policyService.getAllPolicies();
        return ResponseEntity.ok(policies);
    }

    // OFFICERS: Update a policy (status, dates, etc)
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('OFFICER')")
    public ResponseEntity<PolicyDTO> updatePolicy(@PathVariable Long id, @Valid @RequestBody PolicyDTO policyDTO) {
        PolicyDTO updatedPolicy = policyService.updatePolicy(id, policyDTO);
        return ResponseEntity.ok(updatedPolicy);
    }
}
