package com.auca.individualtaxpayer;

import com.auca.abstracts.RegisteredTaxpayer;
    import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.abstracts.RegisteredTaxpayer;
import com.auca.exceptions.ValidationException;
    public class IndividualTaxpayer extends RegisteredTaxpayer {
        private String nationalId;
    private String occupation;
    private String businessName;
    private LocalDate businessStartDate;
    private BigDecimal annualTurnover;
    private boolean resident;
    public IndividualTaxpayer() {}
    public IndividualTaxpayer(String nationalId, String occupation, String businessName, LocalDate businessStartDate, BigDecimal annualTurnover, boolean resident) { this.nationalId=nationalId; this.occupation=occupation; this.businessName=businessName; this.businessStartDate=businessStartDate; this.annualTurnover=annualTurnover; this.resident=resident; }
        public String getNationalId(){return nationalId;} public void setNationalId(String v){nationalId=v;}
    public String getOccupation(){return occupation;} public void setOccupation(String v){occupation=v;}
    public String getBusinessName(){return businessName;} public void setBusinessName(String v){businessName=v;}
    public LocalDate getBusinessStartDate(){return businessStartDate;} public void setBusinessStartDate(LocalDate v){businessStartDate=v;}
    public BigDecimal getAnnualTurnover(){return annualTurnover;} public void setAnnualTurnover(BigDecimal v){annualTurnover=v;}
    public boolean getResident(){return resident;} public void setResident(boolean v){resident=v;}
    public void validate() throws ValidationException {
        if(nationalId==null || String.valueOf(nationalId).trim().isEmpty()) throw new ValidationException("IndividualTaxpayer ID is required.");
    }
    public void printDetails(){System.out.println(getSummary());}
    public String getSummary(){return "IndividualTaxpayer: "+getId()+" - "+getDisplayName();}
    }
