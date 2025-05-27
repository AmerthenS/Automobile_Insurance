package com.hexaware.automobile.services;

import com.hexaware.automobile.dtos.PolicyDTO;
import java.util.List;
import java.util.Optional;

public interface PolicyService {
    List<PolicyDTO> getAllPolicies();
    PolicyDTO addPolicy(PolicyDTO policyDTO);
    Optional<PolicyDTO> getPolicyById(int id);
}
