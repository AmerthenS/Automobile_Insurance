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
