package com.hexaware.automobile.services;

import com.hexaware.automobile.entity.Policy;
import java.util.List;

public interface PolicyService {
    List<Policy> getAllPolicies();
    Policy addPolicy(Policy policy);
}
