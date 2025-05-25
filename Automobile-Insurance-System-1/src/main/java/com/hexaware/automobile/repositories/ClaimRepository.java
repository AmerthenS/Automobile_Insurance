package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entity.Claim;
import com.hexaware.automobile.entity.ClaimStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {
    List<Claim> findByUser_UserId(Integer user_id);
    List<Claim> findByCstatus(ClaimStatus cstatus);
}
