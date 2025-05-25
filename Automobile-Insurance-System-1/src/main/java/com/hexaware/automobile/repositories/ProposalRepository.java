package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entity.Proposal;
import com.hexaware.automobile.entity.ProposalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProposalRepository extends JpaRepository<Proposal, Integer> {
    List<Proposal> findByUser_UserId(Integer user_id);
    List<Proposal> findByPrstatus(ProposalStatus prstatus);
}
