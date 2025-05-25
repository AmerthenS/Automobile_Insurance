package com.hexaware.automobile.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer proposal_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy_id;

    private String vehicle_type;

    private String vehicle_model;

    @Enumerated(EnumType.STRING)
    private ProposalStatus prstatus = ProposalStatus.PROPOSAL_SUBMITTED;

    private LocalDateTime created_at = LocalDateTime.now();

    @OneToOne(mappedBy = "proposal", cascade = CascadeType.ALL)
    private Quote quote;
}
