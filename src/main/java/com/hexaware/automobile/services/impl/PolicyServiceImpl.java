package com.hexaware.automobile.services.impl;

import com.hexaware.automobile.entities.Policy;
import com.hexaware.automobile.repositories.PolicyRepository;
import com.hexaware.automobile.services.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepo;

    @Override
    public List<Policy> getAllPolicies() {
        return policyRepo.findAll();
    }

    @Override
    public Policy addPolicy(Policy policy) {
        return policyRepo.save(policy);
    }

	@Override
	public Optional<Policy> getPolicyById(int i) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
}
