package com.hexaware.automobile.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "officers")
public class Officer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "officer_id")
    private Integer officerId;

    @Column(name = "oname")
    private String oname;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "opassword")
    private String opassword;

    // Default constructor
    public Officer() {}

    // Parameterized constructor
    public Officer(Integer officerId, String oname, String email, String opassword) {
        this.officerId = officerId;
        this.oname = oname;
        this.email = email;
        this.opassword = opassword;
    }

    // Getters and Setters
    public Integer getOfficerId() {
        return officerId;
    }

    public void setOfficerId(Integer officerId) {
        this.officerId = officerId;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpassword() {
        return opassword;
    }

    public void setOpassword(String opassword) {
        this.opassword = opassword;
    }
}
