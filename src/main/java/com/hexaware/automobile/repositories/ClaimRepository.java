package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entities.Claim;
import com.hexaware.automobile.entities.ClaimStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {
    List<Claim> findByUser_UserId(Integer userId);
    List<Claim> findByCstatus(ClaimStatus status);
}
