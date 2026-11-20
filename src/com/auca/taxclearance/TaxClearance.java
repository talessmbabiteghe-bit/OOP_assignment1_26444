package com.auca.taxclearance;

import com.auca.abstracts.RegisteredTaxpayer;
import com.auca.revenueofficer.RevenueOfficer;
    import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
    public class TaxClearance implements Identifiable, Validatable {
        private String clearanceId;
    private RegisteredTaxpayer taxpayer;
    private LocalDate requestDate;
    private LocalDate expiryDate;
    private String status;
    private RevenueOfficer approvedBy;
    public TaxClearance() {}
    public TaxClearance(String clearanceId, RegisteredTaxpayer taxpayer, LocalDate requestDate, LocalDate expiryDate, String status, RevenueOfficer approvedBy) { this.clearanceId=clearanceId; this.taxpayer=taxpayer; this.requestDate=requestDate; this.expiryDate=expiryDate; this.status=status; this.approvedBy=approvedBy; }
        public String getClearanceId(){return clearanceId;} public void setClearanceId(String v){clearanceId=v;}
    public RegisteredTaxpayer getTaxpayer(){return taxpayer;} public void setTaxpayer(RegisteredTaxpayer v){taxpayer=v;}
    public LocalDate getRequestDate(){return requestDate;} public void setRequestDate(LocalDate v){requestDate=v;}
    public LocalDate getExpiryDate(){return expiryDate;} public void setExpiryDate(LocalDate v){expiryDate=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
    public RevenueOfficer getApprovedBy(){return approvedBy;} public void setApprovedBy(RevenueOfficer v){approvedBy=v;}
    public String getId(){return String.valueOf(clearanceId);}
    public String getDisplayName(){return String.valueOf(clearanceId);}
    public boolean isActive(){return true;}
    public void validate() throws ValidationException {
        if(clearanceId==null || String.valueOf(clearanceId).trim().isEmpty()) throw new ValidationException("TaxClearance ID is required.");
    }
    public void printDetails(){System.out.println(getSummary());}
    public String getSummary(){return "TaxClearance: "+getId()+" - "+getDisplayName();}
    }
