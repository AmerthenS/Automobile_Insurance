package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entities.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {
}
