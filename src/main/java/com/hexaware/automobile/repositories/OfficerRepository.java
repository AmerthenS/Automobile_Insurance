package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entities.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfficerRepository extends JpaRepository<Officer, Long> {

    Optional<Officer> findByEmail(String email);

    boolean existsByEmail(String email);
    
    Optional<Officer> findByEmailIgnoreCase(String email);
}
