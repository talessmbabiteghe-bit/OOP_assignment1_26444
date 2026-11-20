package com.auca.taxobligation;

import com.auca.abstracts.RegisteredTaxpayer;
import com.auca.taxtype.TaxType;
    import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
    public class TaxObligation implements Identifiable, Validatable {
        private String obligationId;
    private RegisteredTaxpayer taxpayer;
    private TaxType taxType;
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private LocalDate dueDate;
    public TaxObligation() {}
    public TaxObligation(String obligationId, RegisteredTaxpayer taxpayer, TaxType taxType, LocalDate periodStart, LocalDate periodEnd, LocalDate dueDate) { this.obligationId=obligationId; this.taxpayer=taxpayer; this.taxType=taxType; this.periodStart=periodStart; this.periodEnd=periodEnd; this.dueDate=dueDate; }
        public String getObligationId(){return obligationId;} public void setObligationId(String v){obligationId=v;}
    public RegisteredTaxpayer getTaxpayer(){return taxpayer;} public void setTaxpayer(RegisteredTaxpayer v){taxpayer=v;}
    public TaxType getTaxType(){return taxType;} public void setTaxType(TaxType v){taxType=v;}
    public LocalDate getPeriodStart(){return periodStart;} public void setPeriodStart(LocalDate v){periodStart=v;}
    public LocalDate getPeriodEnd(){return periodEnd;} public void setPeriodEnd(LocalDate v){periodEnd=v;}
    public LocalDate getDueDate(){return dueDate;} public void setDueDate(LocalDate v){dueDate=v;}
    public String getId(){return String.valueOf(obligationId);}
    public String getDisplayName(){return String.valueOf(obligationId);}
    public boolean isActive(){return true;}
    public void validate() throws ValidationException {
        if(obligationId==null || String.valueOf(obligationId).trim().isEmpty()) throw new ValidationException("TaxObligation ID is required.");
    }
    public void printDetails(){System.out.println(getSummary());}
    public String getSummary(){return "TaxObligation: "+getId()+" - "+getDisplayName();}
    }
