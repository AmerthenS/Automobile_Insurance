package com.hexaware.automobile.services.impl;

import com.hexaware.automobile.dtos.ClaimDTO;
import com.hexaware.automobile.entities.Claim;
import com.hexaware.automobile.entities.ClaimStatus;
import com.hexaware.automobile.entities.Policy;
import com.hexaware.automobile.entities.User;
import com.hexaware.automobile.repositories.ClaimRepository;
import com.hexaware.automobile.repositories.PolicyRepository;
import com.hexaware.automobile.repositories.UserRepository;
import com.hexaware.automobile.services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository claimRepo;

    @Autowired
    private PolicyRepository policyRepo;

    @Autowired
    private UserRepository userRepo;

    // Consistent method name: mapToDTO
    private ClaimDTO mapToDTO(Claim claim) {
        ClaimDTO dto = new ClaimDTO();
        dto.setClaimId(claim.getClaimId());
        dto.setUserId(claim.getUser().getUserId());
        dto.setPolicyId(claim.getPolicy().getPolicyId());
        dto.setCdescription(claim.getCdescription());
        dto.setCstatus(claim.getCstatus());
        dto.setCreatedAt(claim.getCreatedAt());
        return dto;
    }

    private Claim mapToEntity(ClaimDTO dto) {
        Claim claim = new Claim();

        if(dto.getClaimId() != null) {
            claim.setClaimId(dto.getClaimId());
        }
        if (dto.getPolicyId() != null) {
            Policy policy = policyRepo.findById(dto.getPolicyId()).orElse(null);
            claim.setPolicy(policy);
        }
        if (dto.getUserId() != null) {
            User user = userRepo.findById(dto.getUserId()).orElse(null);
            claim.setUser(user);
        }
        claim.setCdescription(dto.getCdescription());
        claim.setCstatus(dto.getCstatus() != null ? dto.getCstatus() : ClaimStatus.submitted);
        claim.setCreatedAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : LocalDateTime.now());

        return claim;
    }

    @Override
    public ClaimDTO fileClaim(ClaimDTO claimDTO) {
        Claim claim = mapToEntity(claimDTO);
        Claim saved = claimRepo.save(claim);
        return mapToDTO(saved);
    }

    @Override
    public List<ClaimDTO> getClaimsByUser(Integer userId) {
        List<Claim> claims = claimRepo.findByUser_UserId(userId);
        return claims.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ClaimDTO> getClaimsByStatus(ClaimStatus status) {
        List<Claim> claims = claimRepo.findByCstatus(status);
        return claims.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ClaimDTO getClaimById(Integer id) {
        return claimRepo.findById(id).map(this::mapToDTO).orElse(null);
    }
    @Override
    public List<ClaimDTO> getAllClaims() {
        List<Claim> claims = claimRepo.findAll();
        return claims.stream().map(this::mapToDTO).collect(Collectors.toList()); // ✅ FIXED
    }



    @Override
    public ClaimDTO submitClaim(ClaimDTO claimDTO) {
        Claim claim = mapToEntity(claimDTO);
        claim.setCstatus(ClaimStatus.submitted);
        claim.setCreatedAt(LocalDateTime.now());
        Claim saved = claimRepo.save(claim);
        return mapToDTO(saved);
    }

    @Override
    public ClaimDTO updateClaim(Integer claimId, ClaimDTO claimDTO) {
        return claimRepo.findById(claimId).map(existing -> {
            if (claimDTO.getCdescription() != null) {
                existing.setCdescription(claimDTO.getCdescription());
            }
            if (claimDTO.getCstatus() != null) {
                existing.setCstatus(claimDTO.getCstatus());
            }
            Claim updated = claimRepo.save(existing);
            return mapToDTO(updated);
        }).orElse(null);
    }
}
