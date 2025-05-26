package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByAadhaar(String aadhaar);
    Optional<User> findByPan(String pan);
}
