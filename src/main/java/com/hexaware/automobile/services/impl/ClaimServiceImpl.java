package com.hexaware.automobile.services.impl;

import com.hexaware.automobile.entities.Claim;
import com.hexaware.automobile.entities.ClaimStatus;
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
    public List<Claim> getClaimsByUser(Integer userId) {
        return claimRepo.findByUser_UserId(userId);
    }

    @Override
    public List<Claim> getClaimsByStatus(ClaimStatus status) {
        return claimRepo.findByCstatus(status);
    }

    @Override
    public Claim getClaimById(Integer id) {
        return claimRepo.findById(id).orElse(null);
    }

	@Override
	public Claim submitClaim(Claim claim) {
		// TODO Auto-generated method stub
		return null;
	}
}
