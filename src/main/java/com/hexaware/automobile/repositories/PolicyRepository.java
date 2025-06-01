package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entities.Policy;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
	Optional<Policy> findByProposalId(Long proposalId);
    List<Policy> findByProposalUserId(Long userId);
    

}
