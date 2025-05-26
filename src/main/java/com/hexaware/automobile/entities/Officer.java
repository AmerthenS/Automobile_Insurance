package com.hexaware.automobile.entities;

import jakarta.persistence.*;

@Entity
@Table(name="officers")
public class Officer {
    public Officer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Officer(Integer officerId, String oname, String email, String opassword) {
		super();
		this.officerId = officerId;
		this.oname = oname;
		this.email = email;
		this.opassword = opassword;
	}

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

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer officerId;

    private String oname;

    @Column(unique = true)
    private String email;

    private String opassword;

    
}
