package com.hexaware.automobile.services.impl;

import com.hexaware.automobile.entities.Proposal;
import com.hexaware.automobile.repositories.ProposalRepository;
import com.hexaware.automobile.services.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalServiceImpl implements ProposalService {

    @Autowired
    private ProposalRepository proposalRepo;

    @Override
    public Proposal submitProposal(Proposal proposal) {
        return proposalRepo.save(proposal);
    }

    @Override
    public List<Proposal> getUserProposals(Integer userId) {
        return proposalRepo.findByUser_UserId(userId);
    }

    @Override
    public List<Proposal> getAllProposals() {
        return proposalRepo.findAll();
    }

	@Override
	public List<Proposal> getProposalsByUser(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
