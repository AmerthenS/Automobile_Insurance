package com.hexaware.automobile.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String uname, LocalDate dob, String aadhaar, String pan, String email, String upassword,
			String address, List<Proposal> proposals, List<Claim> claims) {
		super();
		this.userId = userId;
		this.uname = uname;
		this.dob = dob;
		this.aadhaar = aadhaar;
		this.pan = pan;
		this.email = email;
		this.upassword = upassword;
		this.address = address;
		this.proposals = proposals;
		this.claims = claims;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Proposal> getProposals() {
		return proposals;
	}

	public void setProposals(List<Proposal> proposals) {
		this.proposals = proposals;
	}

	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
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
