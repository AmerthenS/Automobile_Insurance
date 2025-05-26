package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.*;
import com.hexaware.automobile.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProposalServiceImplTest {

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PolicyRepository policyRepository;

    @Test
    public void testCreateReadUpdateProposal() {
       
        User user = userRepository.findById(1).orElse(null);
        assertNotNull(user, "User with ID 1 should exist");

        
        Policy policy = policyRepository.findById(1).orElse(null);
        assertNotNull(policy, "Policy with ID 1 should exist");

        
        Proposal proposal = new Proposal();
        proposal.setUser(user);
        proposal.setPolicy(policy);
        proposal.setVehicleType("Sedan");
        proposal.setVehicleModel("Toyota Camry");
        proposal.setPrstatus(ProposalStatus.proposal_submitted);
        proposal.setCreatedAt(LocalDateTime.now());

        Proposal savedProposal = proposalRepository.save(proposal);

        assertNotNull(savedProposal);
        assertNotNull(savedProposal.getProposalId());

        
        Optional<Proposal> fetched = proposalRepository.findById(savedProposal.getProposalId());
        assertTrue(fetched.isPresent());

        Proposal p = fetched.get();
        assertEquals("Sedan", p.getVehicleType());
        assertEquals("Toyota Camry", p.getVehicleModel());

        
        p.setVehicleModel("Honda Accord");
        Proposal updated = proposalRepository.save(p);
        assertEquals("Honda Accord", updated.getVehicleModel());

        
    }
}
