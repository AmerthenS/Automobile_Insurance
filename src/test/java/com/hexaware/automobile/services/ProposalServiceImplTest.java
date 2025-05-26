package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.Proposal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class ProposalServiceImplTest {

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private UserService userService;

    @Autowired
    private PolicyService policyService;

    @Test
    void testSubmitProposal() {
        Proposal proposal = new Proposal();
        proposal.setUser(userService.getUserById(1).orElseThrow());
        proposal.setPolicy(policyService.getPolicyById(1).orElseThrow());
        proposal.setVehicleModel("Model X");
        proposal.setVehicleType("Car");

        Proposal saved = proposalService.submitProposal(proposal);
        assertNotNull(saved.getProposalId());
    }

    @Test
    void testGetProposalsByUser() {
        List<Proposal> proposals = proposalService.getProposalsByUser(1);
        assertFalse(proposals.isEmpty());
    }
}
