package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.User;
import com.hexaware.automobile.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateReadUpdateUserWithoutConflicts() {
        
        String uniqueId = String.valueOf(System.currentTimeMillis());

        String aadhaar = "99999" + uniqueId.substring(uniqueId.length() - 7);  
        String pan = "PAN" + uniqueId.substring(uniqueId.length() - 7);        
        String email = "testuser" + uniqueId + "@example.com";

        
        assertTrue(userRepository.findByEmail(email).isEmpty());
        assertTrue(userRepository.findByAadhaar(aadhaar).isEmpty());
        assertTrue(userRepository.findByPan(pan).isEmpty());

        
        User user = new User();
        user.setUname("Test User");
        user.setDob(LocalDate.of(1999, 5, 20));
        user.setAadhaar(aadhaar);
        user.setPan(pan);
        user.setEmail(email);
        user.setUpassword("test123");
        user.setAddress("21/B, Jump Street");

        
        User savedUser = userRepository.save(user);
        assertNotNull(savedUser.getUserId());

       
        Optional<User> fetched = userRepository.findById(savedUser.getUserId());
        assertTrue(fetched.isPresent());
        assertEquals("Test User", fetched.get().getUname());

        
        fetched.get().setAddress("221B Baker Street");
        User updated = userRepository.save(fetched.get());
        assertEquals("221B Baker Street", updated.getAddress());
    }
}
