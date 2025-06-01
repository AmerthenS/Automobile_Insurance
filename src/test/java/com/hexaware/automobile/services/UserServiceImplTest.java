package com.hexaware.automobile.services;

import com.hexaware.automobile.dtos.UserDTO;
import com.hexaware.automobile.entities.User;
import com.hexaware.automobile.repositories.UserRepository;
import com.hexaware.automobile.services.impl.UserServiceImpl;
import com.hexaware.automobile.util.JwtUtil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private UserServiceImpl userService;

    private UserDTO userDTO;
    private User user;

    @BeforeEach
    void setup() {
        userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setName("John Doe");
        userDTO.setEmail("john@example.com");
        userDTO.setPassword("password123");
        userDTO.setAddress("123 Main St");
        userDTO.setAadhaarNumber("123456789012");
        userDTO.setPanNumber("ABCDE1234F");
        userDTO.setDob(LocalDate.of(1990, 1, 1));
        userDTO.setRole(UserDTO.Role.ROLE_USER);

        user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword("encodedPassword");
        user.setAddress(userDTO.getAddress());
        user.setAadhaarNumber(userDTO.getAadhaarNumber());
        user.setPanNumber(userDTO.getPanNumber());
        user.setDob(userDTO.getDob());
        user.setRole(User.Role.ROLE_USER);
    }

    @Test
    void registerUser_Success() throws Exception {
        when(userRepository.findByEmail(userDTO.getEmail())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(userDTO.getPassword())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDTO registered = userService.registerUser(userDTO);

        assertThat(registered).isNotNull();
        assertThat(registered.getEmail()).isEqualTo(userDTO.getEmail());
        assertThat(registered.getPassword()).isEqualTo("********"); // masked password

        verify(userRepository).save(any(User.class));
        verify(passwordEncoder).encode(userDTO.getPassword());
    }

    @Test
    void registerUser_EmailAlreadyExists_ThrowsException() {
        when(userRepository.findByEmail(userDTO.getEmail())).thenReturn(Optional.of(user));

        assertThatThrownBy(() -> userService.registerUser(userDTO))
                .isInstanceOf(Exception.class)
                .hasMessageContaining("Email already registered");

        verify(userRepository, never()).save(any());
        verify(passwordEncoder, never()).encode(any());
    }

    @Test
    void loginUser_Success() throws Exception {
        when(userRepository.findByEmail(userDTO.getEmail())).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("password123", user.getPassword())).thenReturn(true);
        when(jwtUtil.generateToken(userDTO.getEmail())).thenReturn("jwt-token");

        String token = userService.loginUser(userDTO.getEmail(), "password123");

        assertThat(token).isEqualTo("jwt-token");

        verify(userRepository).findByEmail(userDTO.getEmail());
        verify(passwordEncoder).matches("password123", user.getPassword());
        verify(jwtUtil).generateToken(userDTO.getEmail());
    }

    @Test
    void loginUser_InvalidEmail_ThrowsException() {
        when(userRepository.findByEmail(userDTO.getEmail())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userService.loginUser(userDTO.getEmail(), "password123"))
                .isInstanceOf(Exception.class)
                .hasMessageContaining("Invalid email or password");

        verify(passwordEncoder, never()).matches(any(), any());
        verify(jwtUtil, never()).generateToken(any());
    }

    @Test
    void loginUser_InvalidPassword_ThrowsException() {
        when(userRepository.findByEmail(userDTO.getEmail())).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("wrongpassword", user.getPassword())).thenReturn(false);

        assertThatThrownBy(() -> userService.loginUser(userDTO.getEmail(), "wrongpassword"))
                .isInstanceOf(Exception.class)
                .hasMessageContaining("Invalid email or password");

        verify(jwtUtil, never()).generateToken(any());
    }

    @Test
    void getUserById_Success() throws Exception {
        when(userRepository.findById(userDTO.getId())).thenReturn(Optional.of(user));

        UserDTO found = userService.getUserById(userDTO.getId());

        assertThat(found).isNotNull();
        assertThat(found.getId()).isEqualTo(userDTO.getId());
    }

    @Test
    void getUserById_NotFound_ThrowsException() {
        when(userRepository.findById(userDTO.getId())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userService.getUserById(userDTO.getId()))
                .isInstanceOf(Exception.class)
                .hasMessageContaining("User not found");
    }

    @Test
    void getAllUsers_ReturnsList() {
        when(userRepository.findAll()).thenReturn(List.of(user));

        List<UserDTO> users = userService.getAllUsers();

        assertThat(users).isNotEmpty();
        assertThat(users.get(0).getEmail()).isEqualTo(userDTO.getEmail());
    }

    @Test
    void logoutUser_LogsInfo() {
        
        userService.logoutUser("dummy-token");
    }
}
