package com.hexaware.automobile.dtos;

public class OfficerDTO {
    private Integer officerId;
    private String oname;
    private String email;
    private String opassword;

    public OfficerDTO() {}

    public OfficerDTO(Integer officerId, String oname, String email, String opassword) {
        this.officerId = officerId;
        this.oname = oname;
        this.email = email;
        this.opassword = opassword;
    }

    public Integer getOfficerId() { return officerId; }
    public void setOfficerId(Integer officerId) { this.officerId = officerId; }

    public String getOname() { return oname; }
    public void setOname(String oname) { this.oname = oname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getOpassword() { return opassword; }
    public void setOpassword(String opassword) { this.opassword = opassword; }
}
