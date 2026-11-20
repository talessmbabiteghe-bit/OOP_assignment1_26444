package com.auca.taxtype;
    import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
    public class TaxType implements Identifiable, Validatable {
        private String taxTypeId;
    private String taxCode;
    private String taxName;
    private BigDecimal rate;
    private String filingFrequency;
    private boolean active;
    public TaxType() {}
    public TaxType(String taxTypeId, String taxCode, String taxName, BigDecimal rate, String filingFrequency, boolean active) { this.taxTypeId=taxTypeId; this.taxCode=taxCode; this.taxName=taxName; this.rate=rate; this.filingFrequency=filingFrequency; this.active=active; }
        public String getTaxTypeId(){return taxTypeId;} public void setTaxTypeId(String v){taxTypeId=v;}
    public String getTaxCode(){return taxCode;} public void setTaxCode(String v){taxCode=v;}
    public String getTaxName(){return taxName;} public void setTaxName(String v){taxName=v;}
    public BigDecimal getRate(){return rate;} public void setRate(BigDecimal v){rate=v;}
    public String getFilingFrequency(){return filingFrequency;} public void setFilingFrequency(String v){filingFrequency=v;}
    public boolean getActive(){return active;} public void setActive(boolean v){active=v;}
    public String getId(){return String.valueOf(taxTypeId);}
    public String getDisplayName(){return String.valueOf(taxName);}
    public boolean isActive(){return active;}
    public void validate() throws ValidationException {
        if(taxTypeId==null || String.valueOf(taxTypeId).trim().isEmpty()) throw new ValidationException("TaxType ID is required.");
    }
    public void printDetails(){System.out.println(getSummary());}
    public String getSummary(){return "TaxType: "+getId()+" - "+getDisplayName();}
    }
