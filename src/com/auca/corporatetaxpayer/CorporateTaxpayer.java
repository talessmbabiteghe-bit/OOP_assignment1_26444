package com.auca.corporatetaxpayer;

import com.auca.abstracts.RegisteredTaxpayer;
    import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.abstracts.RegisteredTaxpayer;
import com.auca.exceptions.ValidationException;
    public class CorporateTaxpayer extends RegisteredTaxpayer {
        private String companyRegistrationNo;
    private String legalName;
    private LocalDate incorporationDate;
    private String businessSector;
    private String authorizedRepresentative;
    private BigDecimal annualTurnover;
    public CorporateTaxpayer() {}
    public CorporateTaxpayer(String companyRegistrationNo, String legalName, LocalDate incorporationDate, String businessSector, String authorizedRepresentative, BigDecimal annualTurnover) { this.companyRegistrationNo=companyRegistrationNo; this.legalName=legalName; this.incorporationDate=incorporationDate; this.businessSector=businessSector; this.authorizedRepresentative=authorizedRepresentative; this.annualTurnover=annualTurnover; }
        public String getCompanyRegistrationNo(){return companyRegistrationNo;} public void setCompanyRegistrationNo(String v){companyRegistrationNo=v;}
    public String getLegalName(){return legalName;} public void setLegalName(String v){legalName=v;}
    public LocalDate getIncorporationDate(){return incorporationDate;} public void setIncorporationDate(LocalDate v){incorporationDate=v;}
    public String getBusinessSector(){return businessSector;} public void setBusinessSector(String v){businessSector=v;}
    public String getAuthorizedRepresentative(){return authorizedRepresentative;} public void setAuthorizedRepresentative(String v){authorizedRepresentative=v;}
    public BigDecimal getAnnualTurnover(){return annualTurnover;} public void setAnnualTurnover(BigDecimal v){annualTurnover=v;}
    public void validate() throws ValidationException {
        if(companyRegistrationNo==null || String.valueOf(companyRegistrationNo).trim().isEmpty()) throw new ValidationException("CorporateTaxpayer ID is required.");
    }
    public void printDetails(){System.out.println(getSummary());}
    public String getSummary(){return "CorporateTaxpayer: "+getId()+" - "+getDisplayName();}
    }
