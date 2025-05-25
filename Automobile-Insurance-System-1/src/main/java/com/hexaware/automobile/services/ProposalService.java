package com.hexaware.automobile.services;

import com.hexaware.automobile.entity.Proposal;
import java.util.List;

public interface ProposalService {
    Proposal submitProposal(Proposal proposal);
    List<Proposal> getUserProposals(Integer user_id);
    List<Proposal> getAllProposals();
}
