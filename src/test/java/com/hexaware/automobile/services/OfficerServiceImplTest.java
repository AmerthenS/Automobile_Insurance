package com.hexaware.automobile.services;

import com.hexaware.automobile.dtos.OfficerDTO;
import com.hexaware.automobile.entities.Officer;
import com.hexaware.automobile.entities.User;
import com.hexaware.automobile.exceptions.ResourceNotFoundException;
import com.hexaware.automobile.repositories.OfficerRepository;
import com.hexaware.automobile.services.impl.OfficerServiceImpl;
import com.hexaware.automobile.util.JwtUtil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OfficerServiceImplTest {

    @Mock
    private OfficerRepository officerRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private OfficerServiceImpl officerServiceImpl;

    private Officer officer;

    @BeforeEach
    public void setup() {
        officer = new Officer();
        officer.setId(1L);
        officer.setName("John Doe");
        officer.setEmail("john@example.com");
        officer.setPassword("hashedPassword");
        officer.setRole(User.Role.ROLE_OFFICER);
    }

    @Test
    public void testRegisterOfficer_Success() {
        OfficerDTO dto = new OfficerDTO();
        dto.setOfficerId(1L);
        dto.setName("John Doe");
        dto.setEmail("john@example.com");
        dto.setPassword("password");

        when(officerRepository.existsByEmail(dto.getEmail())).thenReturn(false);
        when(passwordEncoder.encode(dto.getPassword())).thenReturn("hashedPassword");
        when(officerRepository.save(any(Officer.class))).thenAnswer(invocation -> {
            Officer savedOfficer = invocation.getArgument(0);
            savedOfficer.setId(1L);
            return savedOfficer;
        });
        when(jwtUtil.generateToken(dto.getEmail())).thenReturn("jwt-token");

        OfficerDTO savedDto = officerServiceImpl.registerOfficer(dto);

        assertNotNull(savedDto);
        assertEquals(1L, savedDto.getOfficerId());
        assertEquals("John Doe", savedDto.getName());
        assertEquals("john@example.com", savedDto.getEmail());
        assertEquals("jwt-token", savedDto.getJwtToken());
        assertNull(savedDto.getPassword());
    }

    @Test
    public void testRegisterOfficer_EmailExists() {
        OfficerDTO dto = new OfficerDTO();
        dto.setEmail("john@example.com");

        when(officerRepository.existsByEmail(dto.getEmail())).thenReturn(true);

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            officerServiceImpl.registerOfficer(dto);
        });

        assertEquals("Email already registered", ex.getMessage());
    }

    @Test
    public void testGetOfficerById_Found() {
        when(officerRepository.findById(1L)).thenReturn(Optional.of(officer));

        OfficerDTO dto = officerServiceImpl.getOfficerById(1L);

        assertNotNull(dto);
        assertEquals("John Doe", dto.getName());
        assertEquals("john@example.com", dto.getEmail());
    }

    @Test
    public void testGetOfficerById_NotFound() {
        when(officerRepository.findById(1L)).thenReturn(Optional.empty());

        ResourceNotFoundException ex = assertThrows(ResourceNotFoundException.class, () -> {
            officerServiceImpl.getOfficerById(1L);
        });

        assertEquals("Officer not found with ID: 1", ex.getMessage());
    }

    @Test
    public void testGetAllOfficers() {
        Officer officer2 = new Officer();
        officer2.setId(2L);
        officer2.setName("Jane Smith");
        officer2.setEmail("jane@example.com");
        officer2.setPassword("hashedPassword2");
        officer2.setRole(User.Role.ROLE_OFFICER);

        when(officerRepository.findAll()).thenReturn(Arrays.asList(officer, officer2));

        List<OfficerDTO> officers = officerServiceImpl.getAllOfficers();

        assertEquals(2, officers.size());
        assertTrue(officers.stream().anyMatch(o -> o.getName().equals("John Doe")));
        assertTrue(officers.stream().anyMatch(o -> o.getName().equals("Jane Smith")));
    }

    @Test
    public void testUpdateOfficer_Success() {
        OfficerDTO dto = new OfficerDTO();
        dto.setName("Updated Name");
        dto.setEmail("updated@example.com");
        dto.setPassword("newpassword");

        when(officerRepository.findById(1L)).thenReturn(Optional.of(officer));
        when(passwordEncoder.encode(dto.getPassword())).thenReturn("newHashedPassword");
        when(officerRepository.save(any(Officer.class))).thenAnswer(invocation -> invocation.getArgument(0));

        OfficerDTO updatedDto = officerServiceImpl.updateOfficer(1L, dto);

        assertEquals("Updated Name", updatedDto.getName());
        assertEquals("updated@example.com", updatedDto.getEmail());
        assertNull(updatedDto.getPassword());
        verify(passwordEncoder).encode("newpassword");
    }

    @Test
    public void testUpdateOfficer_NotFound() {
        when(officerRepository.findById(1L)).thenReturn(Optional.empty());

        OfficerDTO dto = new OfficerDTO();

        ResourceNotFoundException ex = assertThrows(ResourceNotFoundException.class, () -> {
            officerServiceImpl.updateOfficer(1L, dto);
        });

        assertEquals("Officer not found with ID: 1", ex.getMessage());
    }

    @Test
    public void testDeleteOfficer_Success() {
        when(officerRepository.findById(1L)).thenReturn(Optional.of(officer));
        doNothing().when(officerRepository).delete(officer);

        assertDoesNotThrow(() -> officerServiceImpl.deleteOfficer(1L));
        verify(officerRepository, times(1)).delete(officer);
    }

    @Test
    public void testDeleteOfficer_NotFound() {
        when(officerRepository.findById(1L)).thenReturn(Optional.empty());

        ResourceNotFoundException ex = assertThrows(ResourceNotFoundException.class, () -> {
            officerServiceImpl.deleteOfficer(1L);
        });

        assertEquals("Officer not found with ID: 1", ex.getMessage());
        verify(officerRepository, never()).delete(any());
    }

    @Test
    public void testLoginOfficer_Success() {
        when(officerRepository.findByEmail("john@example.com")).thenReturn(Optional.of(officer));
        when(passwordEncoder.matches("password", "hashedPassword")).thenReturn(true);
        when(jwtUtil.generateToken("john@example.com")).thenReturn("jwt-token");

        OfficerDTO dto = officerServiceImpl.loginOfficer("john@example.com", "password");

        assertNotNull(dto);
        assertEquals("john@example.com", dto.getEmail());
        assertEquals("jwt-token", dto.getJwtToken());
    }

    @Test
    public void testLoginOfficer_InvalidEmail() {
        when(officerRepository.findByEmail("john@example.com")).thenReturn(Optional.empty());

        ResourceNotFoundException ex = assertThrows(ResourceNotFoundException.class, () -> {
            officerServiceImpl.loginOfficer("john@example.com", "password");
        });

        assertEquals("Invalid email or password", ex.getMessage());
    }

    @Test
    public void testLoginOfficer_InvalidPassword() {
        when(officerRepository.findByEmail("john@example.com")).thenReturn(Optional.of(officer));
        when(passwordEncoder.matches("wrongpassword", "hashedPassword")).thenReturn(false);

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            officerServiceImpl.loginOfficer("john@example.com", "wrongpassword");
        });

        assertEquals("Invalid email or password", ex.getMessage());
    }

    @Test
    public void testExistsByEmail() {
        when(officerRepository.existsByEmail("john@example.com")).thenReturn(true);

        assertTrue(officerServiceImpl.existsByEmail("john@example.com"));
        verify(officerRepository, times(1)).existsByEmail("john@example.com");
    }
}
