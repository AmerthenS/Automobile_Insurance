package com.hexaware.automobile.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer claim_id;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @Column(columnDefinition = "TEXT")
    private String cdescription;

    @Enumerated(EnumType.STRING)
    private ClaimStatus cstatus = ClaimStatus.SUBMITTED;

    private LocalDateTime created_at = LocalDateTime.now();
}
