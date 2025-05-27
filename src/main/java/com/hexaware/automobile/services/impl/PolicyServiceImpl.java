package com.hexaware.automobile.services.impl;

import com.hexaware.automobile.dtos.PolicyDTO;
import com.hexaware.automobile.entities.Policy;
import com.hexaware.automobile.repositories.PolicyRepository;
import com.hexaware.automobile.services.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepo;

    private PolicyDTO convertToDTO(Policy policy) {
        return new PolicyDTO(
                policy.getPolicyId(),
                policy.getPname(),
                policy.getPdescription(),
                policy.getBasePremium(),
                policy.getPtype()
        );
    }

    private Policy convertToEntity(PolicyDTO dto) {
        Policy policy = new Policy();
        policy.setPolicyId(dto.getPolicyId());
        policy.setPname(dto.getPname());
        policy.setPdescription(dto.getPdescription());
        policy.setBasePremium(dto.getBasePremium());
        policy.setPtype(dto.getPtype());
        return policy;
    }

    @Override
    public List<PolicyDTO> getAllPolicies() {
        return policyRepo.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public PolicyDTO addPolicy(PolicyDTO policyDTO) {
        Policy saved = policyRepo.save(convertToEntity(policyDTO));
        return convertToDTO(saved);
    }

    @Override
    public Optional<PolicyDTO> getPolicyById(int id) {
        return policyRepo.findById(id).map(this::convertToDTO);
    }
}
