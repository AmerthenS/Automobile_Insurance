package com.hexaware.automobile.controllers;

import com.hexaware.automobile.entities.User;
import com.hexaware.automobile.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setUname(updatedUser.getUname());
            user.setDob(updatedUser.getDob());
            user.setAadhaar(updatedUser.getAadhaar());
            user.setPan(updatedUser.getPan());
            user.setEmail(updatedUser.getEmail());
            user.setUpassword(updatedUser.getUpassword());
            user.setAddress(updatedUser.getAddress());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return "User deleted successfully.";
    }
}
