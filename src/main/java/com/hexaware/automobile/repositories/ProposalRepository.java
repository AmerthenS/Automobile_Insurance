package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entities.Proposal;
import com.hexaware.automobile.entities.ProposalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProposalRepository extends JpaRepository<Proposal, Integer> {
    List<Proposal> findByUser_UserId(Integer userId);
    List<Proposal> findByPrstatus(ProposalStatus status);
}
