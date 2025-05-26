package com.hexaware.automobile.services.impl;

import com.hexaware.automobile.entities.Officer;
import com.hexaware.automobile.repositories.OfficerRepository;
import com.hexaware.automobile.services.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfficerServiceImpl implements OfficerService {

    @Autowired
    private OfficerRepository officerRepo;

    @Override
    public Optional<Officer> loginOfficer(String email, String password) {
        Optional<Officer> officer = officerRepo.findByEmail(email);
        return officer.filter(o -> o.getOpassword().equals(password)); // Add encoding in real app
    }

	@Override
	public Optional<Officer> getOfficerByEmail(String email) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
}
