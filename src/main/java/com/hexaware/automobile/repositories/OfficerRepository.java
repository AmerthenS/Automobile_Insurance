package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entities.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfficerRepository extends JpaRepository<Officer, Integer> {
    Optional<Officer> findByEmail(String email);
}
