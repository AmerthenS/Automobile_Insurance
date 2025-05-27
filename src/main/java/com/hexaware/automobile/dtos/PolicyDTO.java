package com.hexaware.automobile.dtos;

import java.math.BigDecimal;

public class PolicyDTO {

    private Integer policyId;
    private String pname;
    private String pdescription;
    private BigDecimal basePremium;
    private String ptype;

    public PolicyDTO() {}

    public PolicyDTO(Integer policyId, String pname, String pdescription, BigDecimal basePremium, String ptype) {
        this.policyId = policyId;
        this.pname = pname;
        this.pdescription = pdescription;
        this.basePremium = basePremium;
        this.ptype = ptype;
    }

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdescription() {
        return pdescription;
    }

    public void setPdescription(String pdescription) {
        this.pdescription = pdescription;
    }

    public BigDecimal getBasePremium() {
        return basePremium;
    }

    public void setBasePremium(BigDecimal basePremium) {
        this.basePremium = basePremium;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }
}
