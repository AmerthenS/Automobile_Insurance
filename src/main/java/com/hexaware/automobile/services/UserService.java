package com.hexaware.automobile.services;

import com.hexaware.automobile.dtos.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO registerUser(UserDTO userDto);
    Optional<UserDTO> getUserByEmail(String email);
    Optional<UserDTO> getUserById(Integer id);
    List<UserDTO> getAllUsers();
}
