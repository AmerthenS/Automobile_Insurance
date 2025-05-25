package com.hexaware.automobile.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer policy_id;

    private String pname;

    @Column(columnDefinition = "TEXT")
    private String pdescription;

    private BigDecimal base_premium;

    private String ptype;

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private List<Proposal> proposals;

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private List<Claim> claims;
}
