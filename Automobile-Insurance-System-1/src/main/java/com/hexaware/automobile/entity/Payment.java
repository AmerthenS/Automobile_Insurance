package com.hexaware.automobile.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payment_id;

    @OneToOne
    @JoinColumn(name = "quote_id")
    private Quote quote_id;

    private LocalDateTime paid_at = LocalDateTime.now();

    private BigDecimal amount_paid;

    @Enumerated(EnumType.STRING)
    private PaymentStatus pmstatus = PaymentStatus.PENDING;
}
