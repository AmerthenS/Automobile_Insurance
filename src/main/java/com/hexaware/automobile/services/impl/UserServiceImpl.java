package com.hexaware.automobile.services.impl;

import com.hexaware.automobile.dtos.UserDTO;
import com.hexaware.automobile.entities.User;
import com.hexaware.automobile.repositories.UserRepository;
import com.hexaware.automobile.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDTO registerUser(UserDTO userDto) {
        User user = convertToEntity(userDto);
        User savedUser = userRepo.save(user);
        return convertToDTO(savedUser);
    }

    @Override
    public Optional<UserDTO> getUserByEmail(String email) {
        return userRepo.findByEmail(email).map(this::convertToDTO);
    }

    @Override
    public Optional<UserDTO> getUserById(Integer id) {
        return userRepo.findById(id).map(this::convertToDTO);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepo.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Conversion Methods

    private UserDTO convertToDTO(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getUname(),
                user.getDob(),
                user.getAadhaar(),
                user.getPan(),
                user.getEmail(),
                user.getUpassword(),
                user.getAddress()
        );
    }

    private User convertToEntity(UserDTO dto) {
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setUname(dto.getUname());
        user.setDob(dto.getDob());
        user.setAadhaar(dto.getAadhaar());
        user.setPan(dto.getPan());
        user.setEmail(dto.getEmail());
        user.setUpassword(dto.getUpassword());
        user.setAddress(dto.getAddress());
        return user;
    }
}
