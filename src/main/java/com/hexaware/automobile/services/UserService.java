package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserById(Integer id);
    List<User> getAllUsers();
}
