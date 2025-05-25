package com.hexaware.automobile.repositories;

import com.hexaware.automobile.entity.Payment;
import com.hexaware.automobile.entity.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    List<Payment> findByPmstatus(PaymentStatus pmstatus);
}
