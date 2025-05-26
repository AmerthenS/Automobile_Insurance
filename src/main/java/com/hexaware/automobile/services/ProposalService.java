package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.Proposal;
import java.util.List;

public interface ProposalService {
    Proposal submitProposal(Proposal proposal);
    List<Proposal> getUserProposals(Integer userId);
    List<Proposal> getAllProposals();
	List<Proposal> getProposalsByUser(int i);
}
