/*
 * OfficerService.java
 * 
 * Service interface declaring operations for managing officers in the system.
 * Includes methods for officer registration, retrieval by ID, updating,
 * deleting, login authentication, and checking email existence.
 * 
 * Author: Amerthen
 * Date: 2025-06-02
 */
package com.hexaware.automobile.services;

import com.hexaware.automobile.dtos.OfficerDTO;
import java.util.List;

public interface OfficerService {
    OfficerDTO registerOfficer(OfficerDTO officerDTO);
    OfficerDTO getOfficerById(Long officerId);
    List<OfficerDTO> getAllOfficers();
    OfficerDTO updateOfficer(Long officerId, OfficerDTO officerDTO);
    void deleteOfficer(Long officerId);
    OfficerDTO loginOfficer(String email, String password);
    boolean existsByEmail(String email);
}
