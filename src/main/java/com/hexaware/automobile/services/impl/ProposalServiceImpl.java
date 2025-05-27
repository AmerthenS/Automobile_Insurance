package com.hexaware.automobile.services.impl;

import com.hexaware.automobile.dtos.ProposalDTO;
import com.hexaware.automobile.entities.Policy;
import com.hexaware.automobile.entities.Proposal;
import com.hexaware.automobile.entities.ProposalStatus;
import com.hexaware.automobile.entities.Quote;
import com.hexaware.automobile.entities.User;
import com.hexaware.automobile.repositories.PolicyRepository;
import com.hexaware.automobile.repositories.ProposalRepository;
import com.hexaware.automobile.repositories.QuoteRepository;
import com.hexaware.automobile.repositories.UserRepository;
import com.hexaware.automobile.services.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProposalServiceImpl implements ProposalService {

    @Autowired
    private ProposalRepository proposalRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PolicyRepository policyRepo;

    @Autowired
    private QuoteRepository quoteRepo;

    private ProposalDTO convertToDto(Proposal proposal) {
        return new ProposalDTO(
            proposal.getProposalId(),
            proposal.getUser() != null ? proposal.getUser().getUserId() : null,
            proposal.getPolicy() != null ? proposal.getPolicy().getPolicyId() : null,
            proposal.getVehicleType(),
            proposal.getVehicleModel(),
            proposal.getPrstatus() != null ? proposal.getPrstatus().name() : null,
            proposal.getCreatedAt(),
            proposal.getQuote() != null ? proposal.getQuote().getQuoteId() : null
        );
    }

    private Proposal convertToEntity(ProposalDTO dto) {
        Proposal proposal = new Proposal();

        proposal.setProposalId(dto.getProposalId());

        if (dto.getUserId() != null) {
            Optional<User> userOpt = userRepo.findById(dto.getUserId());
            userOpt.ifPresent(proposal::setUser);
        }

        if (dto.getPolicyId() != null) {
            Optional<Policy> policyOpt = policyRepo.findById(dto.getPolicyId());
            policyOpt.ifPresent(proposal::setPolicy);
        }

        proposal.setVehicleType(dto.getVehicleType());
        proposal.setVehicleModel(dto.getVehicleModel());

        if (dto.getPrstatus() != null) {
            proposal.setPrstatus(ProposalStatus.valueOf(dto.getPrstatus()));
        }

        // createdAt: You may keep as is or allow it to be set from DTO if needed

        if (dto.getQuoteId() != null) {
            Optional<Quote> quoteOpt = quoteRepo.findById(dto.getQuoteId());
            quoteOpt.ifPresent(proposal::setQuote);
        }

        return proposal;
    }

    @Override
    public ProposalDTO submitProposal(ProposalDTO proposalDto) {
        Proposal saved = proposalRepo.save(convertToEntity(proposalDto));
        return convertToDto(saved);
    }

    @Override
    public List<ProposalDTO> getUserProposals(Integer userId) {
        List<Proposal> proposals = proposalRepo.findByUser_UserId(userId);
        return proposals.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<ProposalDTO> getAllProposals() {
        List<Proposal> proposals = proposalRepo.findAll();
        return proposals.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<ProposalDTO> getProposalById(Integer id) {
        return proposalRepo.findById(id).map(this::convertToDto);
    }

    @Override
    public ProposalDTO updateProposal(Integer id, ProposalDTO proposalDto) {
        Proposal updated = proposalRepo.findById(id).map(existing -> {
            if (proposalDto.getUserId() != null) {
                userRepo.findById(proposalDto.getUserId()).ifPresent(existing::setUser);
            }
            if (proposalDto.getPolicyId() != null) {
                policyRepo.findById(proposalDto.getPolicyId()).ifPresent(existing::setPolicy);
            }
            existing.setVehicleModel(proposalDto.getVehicleModel());
            existing.setVehicleType(proposalDto.getVehicleType());
            if (proposalDto.getPrstatus() != null) {
                existing.setPrstatus(ProposalStatus.valueOf(proposalDto.getPrstatus()));
            }
            if (proposalDto.getQuoteId() != null) {
                quoteRepo.findById(proposalDto.getQuoteId()).ifPresent(existing::setQuote);
            }
            return proposalRepo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Proposal not found with id " + id));
        return convertToDto(updated);
    }

    @Override
    public void deleteProposal(Integer id) {
        proposalRepo.deleteById(id);
    }
}
