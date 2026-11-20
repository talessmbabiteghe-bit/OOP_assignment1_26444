package com.auca.taxrefund;

import com.auca.abstracts.RegisteredTaxpayer;
import com.auca.taxassessment.TaxAssessment;
    import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
    public class TaxRefund implements Identifiable, Validatable {
        private String refundId;
    private RegisteredTaxpayer taxpayer;
    private TaxAssessment assessment;
    private BigDecimal requestedAmount;
    private LocalDate requestDate;
    private String status;
    public TaxRefund() {}
    public TaxRefund(String refundId, RegisteredTaxpayer taxpayer, TaxAssessment assessment, BigDecimal requestedAmount, LocalDate requestDate, String status) { this.refundId=refundId; this.taxpayer=taxpayer; this.assessment=assessment; this.requestedAmount=requestedAmount; this.requestDate=requestDate; this.status=status; }
        public String getRefundId(){return refundId;} public void setRefundId(String v){refundId=v;}
    public RegisteredTaxpayer getTaxpayer(){return taxpayer;} public void setTaxpayer(RegisteredTaxpayer v){taxpayer=v;}
    public TaxAssessment getAssessment(){return assessment;} public void setAssessment(TaxAssessment v){assessment=v;}
    public BigDecimal getRequestedAmount(){return requestedAmount;} public void setRequestedAmount(BigDecimal v){requestedAmount=v;}
    public LocalDate getRequestDate(){return requestDate;} public void setRequestDate(LocalDate v){requestDate=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
    public String getId(){return String.valueOf(refundId);}
    public String getDisplayName(){return String.valueOf(refundId);}
    public boolean isActive(){return true;}
    public void validate() throws ValidationException {
        if(refundId==null || String.valueOf(refundId).trim().isEmpty()) throw new ValidationException("TaxRefund ID is required.");
    }
    public void printDetails(){System.out.println(getSummary());}
    public String getSummary(){return "TaxRefund: "+getId()+" - "+getDisplayName();}
    }
