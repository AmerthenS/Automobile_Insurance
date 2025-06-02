/*
 * UserService.java
 * 
 * Service interface defining user-related operations including user registration,
 * login, logout, fetching user details by ID, updating user information,
 * retrieving all users, and deleting users.
 * 
 * Author: Amerthen
 * Date: 2025-06-02
 */
package com.hexaware.automobile.services;

import com.hexaware.automobile.dtos.UserDTO;
import java.util.List;
import java.util.Optional;

public interface UserService {
    
    
    UserDTO registerUser(UserDTO userDTO) throws Exception;

    
    String loginUser(String email, String password) throws Exception;

    
    UserDTO getUserById(Long id) throws Exception;

    
    List<UserDTO> getAllUsers();

    
    void logoutUser(String token);
    
    Optional<UserDTO> updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);

}
