package com.auca.penalty;

import com.auca.taxobligation.TaxObligation;
    import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
    public class Penalty implements Identifiable, Validatable {
        private String penaltyId;
    private TaxObligation obligation;
    private String penaltyType;
    private BigDecimal baseAmount;
    private BigDecimal penaltyRate;
    private BigDecimal penaltyAmount;
    public Penalty() {}
    public Penalty(String penaltyId, TaxObligation obligation, String penaltyType, BigDecimal baseAmount, BigDecimal penaltyRate, BigDecimal penaltyAmount) { this.penaltyId=penaltyId; this.obligation=obligation; this.penaltyType=penaltyType; this.baseAmount=baseAmount; this.penaltyRate=penaltyRate; this.penaltyAmount=penaltyAmount; }
        public String getPenaltyId(){return penaltyId;} public void setPenaltyId(String v){penaltyId=v;}
    public TaxObligation getObligation(){return obligation;} public void setObligation(TaxObligation v){obligation=v;}
    public String getPenaltyType(){return penaltyType;} public void setPenaltyType(String v){penaltyType=v;}
    public BigDecimal getBaseAmount(){return baseAmount;} public void setBaseAmount(BigDecimal v){baseAmount=v;}
    public BigDecimal getPenaltyRate(){return penaltyRate;} public void setPenaltyRate(BigDecimal v){penaltyRate=v;}
    public BigDecimal getPenaltyAmount(){return penaltyAmount;} public void setPenaltyAmount(BigDecimal v){penaltyAmount=v;}
    public String getId(){return String.valueOf(penaltyId);}
    public String getDisplayName(){return String.valueOf(penaltyId);}
    public boolean isActive(){return true;}
    public void validate() throws ValidationException {
        if(penaltyId==null || String.valueOf(penaltyId).trim().isEmpty()) throw new ValidationException("Penalty ID is required.");
    }
    public void printDetails(){System.out.println(getSummary());}
    public String getSummary(){return "Penalty: "+getId()+" - "+getDisplayName();}
    }
