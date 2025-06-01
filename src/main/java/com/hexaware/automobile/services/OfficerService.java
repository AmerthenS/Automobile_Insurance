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
