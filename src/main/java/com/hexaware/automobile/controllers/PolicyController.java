package com.hexaware.automobile.controllers;

import com.hexaware.automobile.dtos.PolicyDTO;
import com.hexaware.automobile.services.PolicyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping
    public ResponseEntity<List<PolicyDTO>> getAllPolicies() {
        return ResponseEntity.ok(policyService.getAllPolicies());
    }

    @PostMapping
    public ResponseEntity<PolicyDTO> addPolicy(@RequestBody PolicyDTO policyDTO) {
        return ResponseEntity.ok(policyService.addPolicy(policyDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicyDTO> getPolicyById(@PathVariable int id) {
        Optional<PolicyDTO> dto = policyService.getPolicyById(id);
        return dto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
