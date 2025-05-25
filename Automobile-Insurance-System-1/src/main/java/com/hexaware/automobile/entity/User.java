package com.hexaware.automobile.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    private String uname;

    private LocalDate dob;

    @Column(unique = true, length = 12)
    private String aadhaar;

    @Column(unique = true, length = 10)
    private String pan;

    @Column(unique = true)
    private String email;

    private String upassword;

    @Column(columnDefinition = "TEXT")
    private String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Proposal> proposals;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Claim> claims;
}
