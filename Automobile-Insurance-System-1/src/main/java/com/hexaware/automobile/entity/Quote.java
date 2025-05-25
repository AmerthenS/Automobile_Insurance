package com.hexaware.automobile.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer quote_id;

    @OneToOne
    @JoinColumn(name = "proposal_id")
    private Proposal proposal_id;

    private BigDecimal premium_amount;

    private LocalDateTime sent_at = LocalDateTime.now();

    @OneToOne(mappedBy = "quote", cascade = CascadeType.ALL)
    private Payment payment;
}
