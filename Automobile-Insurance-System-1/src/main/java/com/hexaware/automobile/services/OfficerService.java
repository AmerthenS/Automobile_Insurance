package com.hexaware.automobile.services;

import com.hexaware.automobile.entity.Officer;
import java.util.Optional;

public interface OfficerService {
    Optional<Officer> loginOfficer(String email, String opassword);
}
