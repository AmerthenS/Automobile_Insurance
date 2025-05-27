package com.hexaware.automobile.controllers;

import com.hexaware.automobile.dtos.OfficerDTO;
import com.hexaware.automobile.services.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/officers")
public class OfficerController {

    @Autowired
    private OfficerService officerService;

    @PostMapping("/register")
    public ResponseEntity<OfficerDTO> registerOfficer(@RequestBody OfficerDTO dto) {
        return ResponseEntity.ok(officerService.registerOfficer(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<OfficerDTO> login(@RequestParam String email, @RequestParam String password) {
        return officerService.loginOfficer(email, password)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfficerDTO> getById(@PathVariable int id) {
        return officerService.getOfficerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<OfficerDTO>> getAll() {
        return ResponseEntity.ok(officerService.getAllOfficers());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<OfficerDTO> getByEmail(@PathVariable String email) {
        return officerService.getOfficerByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
