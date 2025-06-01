package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entities.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    List<Proposal> findByUserId(Long userId);
}
