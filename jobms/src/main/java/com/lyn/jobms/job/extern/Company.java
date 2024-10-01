package com.lyn.jobms.job.extern;

public class Company {
    private Long id;
    private String companyName;
    private String companyAddress;
    private String companyFields;
    private Long companySiren;



    public Company(Long id, String companyName, String companyAddress, String companyFields, Long companySiren) {
        this.id = id;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyFields = companyFields;
        this.companySiren = companySiren;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyFields() {
        return companyFields;
    }

    public void setCompanyFields(String companyFields) {
        this.companyFields = companyFields;
    }

    public Long getCompanySiren() {
        return companySiren;
    }

    public void setCompanySiren(Long companySiren) {
        this.companySiren = companySiren;
    }

    public void update(Company updateCompany) {
        this.companyName = updateCompany.companyName;
        this.companyAddress = updateCompany.companyAddress;
        this.companyFields = updateCompany.companyFields;
        this.companySiren = updateCompany.companySiren;
    }
}

