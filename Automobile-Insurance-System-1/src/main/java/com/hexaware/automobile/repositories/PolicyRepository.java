package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {
}
