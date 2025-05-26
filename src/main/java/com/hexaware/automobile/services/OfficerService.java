package com.hexaware.automobile.services;

import com.hexaware.automobile.entities.Officer;
import java.util.Optional;

public interface OfficerService {
    Optional<Officer> loginOfficer(String email, String password);

	Optional<Officer> getOfficerByEmail(String email);
}
