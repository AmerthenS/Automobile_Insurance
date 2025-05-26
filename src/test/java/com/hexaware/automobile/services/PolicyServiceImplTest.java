package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.Policy;
import com.hexaware.automobile.repositories.PolicyRepository;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PolicyServiceImplTest {

    @Autowired
    private PolicyService policyService;
    
    @Autowired
    private PolicyRepository policyRepository;

    @Test
    void testGetAllPolicies() {
        assertFalse(policyService.getAllPolicies().isEmpty());
    }

    @Test
    public void testSavePolicy() {
        Policy policy = new Policy();
        policy.setPname("Comprehensive Auto");
        policy.setPdescription("Full coverage auto insurance plan");
        policy.setBasePremium(new BigDecimal("1500.00"));
        policy.setPtype("Auto");

  

        Policy savedPolicy = policyRepository.save(policy);

        assertNotNull(savedPolicy);
        assertNotNull(savedPolicy.getPolicyId());
        assertEquals("Comprehensive Auto", savedPolicy.getPname());
        assertEquals("Full coverage auto insurance plan", savedPolicy.getPdescription());
        assertEquals(new BigDecimal("1500.00"), savedPolicy.getBasePremium());
        assertEquals("Auto", savedPolicy.getPtype());
    }
}
