package com.hexaware.automobile.services.impl;

import com.hexaware.automobile.entity.User;
import com.hexaware.automobile.repositories.UserRepository;
import com.hexaware.automobile.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User registerUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public Optional<User> getUserById(Integer user_id) {
        return userRepo.findById(user_id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
