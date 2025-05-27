package com.hexaware.automobile.dtos;

import java.time.LocalDate;

public class UserDTO {
    private Integer userId;
    private String uname;
    private LocalDate dob;
    private String aadhaar;
    private String pan;
    private String email;
    private String upassword;  // keep password for JWT
    private String address;

    public UserDTO() {}

    public UserDTO(Integer userId, String uname, LocalDate dob, String aadhaar, String pan,
                   String email, String upassword, String address) {
        this.userId = userId;
        this.uname = uname;
        this.dob = dob;
        this.aadhaar = aadhaar;
        this.pan = pan;
        this.email = email;
        this.upassword = upassword;
        this.address = address;
    }

    // Getters and Setters
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getUname() { return uname; }
    public void setUname(String uname) { this.uname = uname; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getAadhaar() { return aadhaar; }
    public void setAadhaar(String aadhaar) { this.aadhaar = aadhaar; }

    public String getPan() { return pan; }
    public void setPan(String pan) { this.pan = pan; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUpassword() { return upassword; }
    public void setUpassword(String upassword) { this.upassword = upassword; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
