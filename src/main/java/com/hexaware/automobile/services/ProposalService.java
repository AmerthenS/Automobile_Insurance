package com.hexaware.automobile.services;

import com.hexaware.automobile.dtos.ProposalDTO;
import com.hexaware.automobile.entities.Proposal;

import java.util.List;

public interface ProposalService {
    Proposal createProposal(ProposalDTO proposalDTO);
    Proposal getProposalById(Long id);
    Proposal updateProposal(Long id, ProposalDTO proposalDTO);
    void deleteProposal(Long id);
    List<Proposal> getAllProposals();
    List<Proposal> getProposalsByUserId(Long userId);
}

