package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.Officer;
import com.hexaware.automobile.repositories.OfficerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OfficerServiceImplTest {

    @Autowired
    private OfficerRepository officerRepository;

    @Test
    void testFindByEmailFromDB() {
        Officer newOfficer = new Officer();
        newOfficer.setOname("Test Officer");
        newOfficer.setEmail("test@hexaware.com");
        newOfficer.setOpassword("1234");
        officerRepository.save(newOfficer);  

        Optional<Officer> officer = officerRepository.findByEmail("test@hexaware.com");
        assertTrue(officer.isPresent());
        assertEquals("test@hexaware.com", officer.get().getEmail());
    }

    }

