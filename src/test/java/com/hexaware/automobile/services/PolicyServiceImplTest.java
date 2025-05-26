package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.Policy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PolicyServiceImplTest {

    @Autowired
    private PolicyService policyService;

    @Test
    void testGetAllPolicies() {
        assertFalse(policyService.getAllPolicies().isEmpty());
    }

    @Test
    void testGetPolicyById() {
        Optional<Policy> policy = policyService.getPolicyById(1);
        assertTrue(policy.isPresent());
    }
}
