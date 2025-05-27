package com.hexaware.automobile.services;

import com.hexaware.automobile.dtos.OfficerDTO;
import java.util.List;
import java.util.Optional;

public interface OfficerService {
    OfficerDTO registerOfficer(OfficerDTO dto);
    Optional<OfficerDTO> loginOfficer(String email, String password);
    Optional<OfficerDTO> getOfficerByEmail(String email);
    Optional<OfficerDTO> getOfficerById(int id);
    List<OfficerDTO> getAllOfficers();
}
