package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entities.Officer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficerRepository extends JpaRepository<Officer, Integer> {
    Optional<Officer> findByEmail(String email);
}
