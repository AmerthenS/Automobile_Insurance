package com.hexaware.automobile.services;

import com.hexaware.automobile.dtos.PolicyDTO;

import java.util.List;

public interface PolicyService {
    PolicyDTO createPolicy(PolicyDTO policyDTO);
    PolicyDTO getPolicyById(Long id);
    PolicyDTO getPolicyByProposalId(Long proposalId);
    List<PolicyDTO> getAllPolicies();
    PolicyDTO updatePolicy(Long id, PolicyDTO policyDTO);
    void deletePolicy(Long id);
    List<PolicyDTO> getPoliciesByUserId(Long userId);
}

