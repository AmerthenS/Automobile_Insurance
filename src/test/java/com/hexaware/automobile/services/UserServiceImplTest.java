package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void testRegisterUser() {
        User user = new User();
        user.setUname("Test User");
        user.setDob(LocalDate.of(1990, 1, 1));
        user.setEmail("testuser" + System.currentTimeMillis() + "@example.com");
        user.setUpassword("pass");
        user.setAadhaar("99998888" + (int)(Math.random() * 100));
        user.setPan("PAN" + (int)(Math.random() * 10000)); 
        user.setAddress("India");

        User saved = userService.registerUser(user);
        assertNotNull(saved.getUserId());
    }


    @Test
    void testGetAllUsers() {
        assertFalse(userService.getAllUsers().isEmpty());
    }

    @Test
    void testGetUserById() {
        Optional<User> user = userService.getUserById(1);
        assertTrue(user.isPresent());
    }
}
