package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.Policy;
import java.util.List;
import java.util.Optional;

public interface PolicyService {
    List<Policy> getAllPolicies();
    Policy addPolicy(Policy policy);
	Optional<Policy> getPolicyById(int i);
}
