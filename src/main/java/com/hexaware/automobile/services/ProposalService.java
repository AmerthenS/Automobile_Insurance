package com.hexaware.automobile.services;

import com.hexaware.automobile.dtos.ProposalDTO;

import java.util.List;
import java.util.Optional;

public interface ProposalService {
    ProposalDTO submitProposal(ProposalDTO proposalDto);
    List<ProposalDTO> getUserProposals(Integer userId);
    List<ProposalDTO> getAllProposals();
    Optional<ProposalDTO> getProposalById(Integer id); 
    ProposalDTO updateProposal(Integer id, ProposalDTO proposalDto);
    void deleteProposal(Integer id);
}
