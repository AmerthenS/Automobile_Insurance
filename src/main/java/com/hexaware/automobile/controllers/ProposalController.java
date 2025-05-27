package com.hexaware.automobile.controllers;

import com.hexaware.automobile.dtos.ProposalDTO;
import com.hexaware.automobile.services.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proposals")
public class ProposalController {

    @Autowired
    private ProposalService proposalService;

    @PostMapping
    public ResponseEntity<ProposalDTO> createProposal(@RequestBody ProposalDTO proposalDto) {
        ProposalDTO created = proposalService.submitProposal(proposalDto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProposalDTO> getProposalById(@PathVariable Integer id) {
        return proposalService.getProposalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ProposalDTO>> getProposalsByUser(@PathVariable Integer userId) {
        List<ProposalDTO> proposals = proposalService.getUserProposals(userId);
        return ResponseEntity.ok(proposals);
    }

    @GetMapping
    public ResponseEntity<List<ProposalDTO>> getAllProposals() {
        return ResponseEntity.ok(proposalService.getAllProposals());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProposalDTO> updateProposal(@PathVariable Integer id, @RequestBody ProposalDTO proposalDto) {
        ProposalDTO updated = proposalService.updateProposal(id, proposalDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProposal(@PathVariable Integer id) {
        proposalService.deleteProposal(id);
        return ResponseEntity.noContent().build();
    }
}
