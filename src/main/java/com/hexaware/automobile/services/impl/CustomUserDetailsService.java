package com.hexaware.automobile.services.impl;

import com.hexaware.automobile.entities.Officer;
import com.hexaware.automobile.entities.User;
import com.hexaware.automobile.repositories.OfficerRepository;
import com.hexaware.automobile.repositories.UserRepository;
import com.hexaware.automobile.security.CustomUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OfficerRepository officerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        User user = userRepository.findByEmailIgnoreCase(email).orElse(null);
        if (user != null) {
            System.out.println("Found USER with email: " + email);
            return CustomUserDetails.fromUser(user);
        }

        Officer officer = officerRepository.findByEmailIgnoreCase(email).orElse(null);
        if (officer != null) {
            System.out.println("Found OFFICER with email: " + email);
            return CustomUserDetails.fromOfficer(officer);
        }

        System.out.println("No user or officer found for email: " + email);
        throw new UsernameNotFoundException("User or Officer not found with email: " + email);
    }
}
