package com.auca.taxdeclaration;

import com.auca.taxobligation.TaxObligation;
    import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
    public class TaxDeclaration implements Identifiable, Validatable {
        private String declarationId;
    private TaxObligation obligation;
    private LocalDate filingDate;
    private BigDecimal taxableAmount;
    private BigDecimal declaredTax;
    private String status;
    public TaxDeclaration() {}
    public TaxDeclaration(String declarationId, TaxObligation obligation, LocalDate filingDate, BigDecimal taxableAmount, BigDecimal declaredTax, String status) { this.declarationId=declarationId; this.obligation=obligation; this.filingDate=filingDate; this.taxableAmount=taxableAmount; this.declaredTax=declaredTax; this.status=status; }
        public String getDeclarationId(){return declarationId;} public void setDeclarationId(String v){declarationId=v;}
    public TaxObligation getObligation(){return obligation;} public void setObligation(TaxObligation v){obligation=v;}
    public LocalDate getFilingDate(){return filingDate;} public void setFilingDate(LocalDate v){filingDate=v;}
    public BigDecimal getTaxableAmount(){return taxableAmount;} public void setTaxableAmount(BigDecimal v){taxableAmount=v;}
    public BigDecimal getDeclaredTax(){return declaredTax;} public void setDeclaredTax(BigDecimal v){declaredTax=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
    public String getId(){return String.valueOf(declarationId);}
    public String getDisplayName(){return String.valueOf(declarationId);}
    public boolean isActive(){return true;}
    public void validate() throws ValidationException {
        if(declarationId==null || String.valueOf(declarationId).trim().isEmpty()) throw new ValidationException("TaxDeclaration ID is required.");
    }
    public void printDetails(){System.out.println(getSummary());}
    public String getSummary(){return "TaxDeclaration: "+getId()+" - "+getDisplayName();}
    }
