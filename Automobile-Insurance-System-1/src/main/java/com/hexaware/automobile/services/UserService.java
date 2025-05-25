package com.hexaware.automobile.services;

import com.hexaware.automobile.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserById(Integer user_id);
    List<User> getAllUsers();
}
