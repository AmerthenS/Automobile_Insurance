package com.hexaware.automobile.services.impl;

import com.hexaware.automobile.entity.Claim;
import com.hexaware.automobile.entity.ClaimStatus;
import com.hexaware.automobile.repositories.ClaimRepository;
import com.hexaware.automobile.services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository claimRepo;

    @Override
    public Claim fileClaim(Claim claim) {
        return claimRepo.save(claim);
    }

    @Override
    public List<Claim> getClaimsByUser(Integer user_id) {
        return claimRepo.findByUser_UserId(user_id);
    }

    @Override
    public List<Claim> getClaimsByStatus(ClaimStatus cstatus) {
        return claimRepo.findByCstatus(cstatus);
    }

    @Override
    public Claim getClaimById(Integer claim_id) {
        return claimRepo.findById(claim_id).orElse(null);
    }
}
