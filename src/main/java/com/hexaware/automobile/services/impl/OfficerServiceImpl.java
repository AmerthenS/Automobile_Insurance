package com.hexaware.automobile.services.impl;

import com.hexaware.automobile.dtos.OfficerDTO;
import com.hexaware.automobile.entities.Officer;
import com.hexaware.automobile.repositories.OfficerRepository;
import com.hexaware.automobile.services.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfficerServiceImpl implements OfficerService {

    @Autowired
    private OfficerRepository officerRepo;

    private OfficerDTO mapToDTO(Officer o) {
        return new OfficerDTO(o.getOfficerId(), o.getOname(), o.getEmail(), o.getOpassword());
    }

    private Officer mapToEntity(OfficerDTO dto) {
        return new Officer(dto.getOfficerId(), dto.getOname(), dto.getEmail(), dto.getOpassword());
    }

    @Override
    public OfficerDTO registerOfficer(OfficerDTO dto) {
        Officer saved = officerRepo.save(mapToEntity(dto));
        return mapToDTO(saved);
    }

    @Override
    public Optional<OfficerDTO> loginOfficer(String email, String password) {
        return officerRepo.findByEmail(email)
                .filter(o -> o.getOpassword().equals(password))
                .map(this::mapToDTO);
    }

    @Override
    public Optional<OfficerDTO> getOfficerByEmail(String email) {
        return officerRepo.findByEmail(email).map(this::mapToDTO);
    }

    @Override
    public Optional<OfficerDTO> getOfficerById(int id) {
        return officerRepo.findById(id).map(this::mapToDTO);
    }

    @Override
    public List<OfficerDTO> getAllOfficers() {
        return officerRepo.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
}
