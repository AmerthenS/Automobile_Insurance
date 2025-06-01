package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entities.Payment;
import com.hexaware.automobile.entities.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByQuote(Quote quote);
}
