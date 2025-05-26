package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.Officer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OfficerServiceImplTest {

    @Autowired
    private OfficerService officerService;

    @Test
    void testGetOfficerByEmail() {
        
        String email = "raj@insurance.com";

        Optional<Officer> officer = officerService.getOfficerByEmail(email);
        assertTrue(officer.isPresent(), "Officer should exist with email: " + email);
    }
}
