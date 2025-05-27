package com.hexaware.automobile.controllers;

import com.hexaware.automobile.dtos.ClaimDTO;
import com.hexaware.automobile.entities.ClaimStatus;
import com.hexaware.automobile.services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @PostMapping
    public ResponseEntity<ClaimDTO> createClaim(@RequestBody ClaimDTO claimDTO) {
        ClaimDTO created = claimService.fileClaim(claimDTO);
        return ResponseEntity.ok(created);
    }


    @GetMapping
    public ResponseEntity<List<ClaimDTO>> getAllClaims() {
        List<ClaimDTO> claims = claimService.getAllClaims();
        return ResponseEntity.ok(claims);
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ClaimDTO>> getClaimsByUser(@PathVariable Integer userId) {
        List<ClaimDTO> claims = claimService.getClaimsByUser(userId);
        return ResponseEntity.ok(claims);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ClaimDTO>> getClaimsByStatus(@PathVariable ClaimStatus status) {
        List<ClaimDTO> claims = claimService.getClaimsByStatus(status);
        return ResponseEntity.ok(claims);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaimDTO> updateClaim(@PathVariable Integer id, @RequestBody ClaimDTO claimDTO) {
        ClaimDTO updated = claimService.updateClaim(id, claimDTO);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/submit")
    public ResponseEntity<ClaimDTO> submitClaim(@RequestBody ClaimDTO claimDTO) {
        ClaimDTO submitted = claimService.submitClaim(claimDTO);
        return ResponseEntity.ok(submitted);
        
        
    }
    
}
