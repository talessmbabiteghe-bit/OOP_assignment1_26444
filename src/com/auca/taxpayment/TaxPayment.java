package com.auca.taxpayment;

import com.auca.taxassessment.TaxAssessment;
    import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
    public class TaxPayment implements Identifiable, Validatable {
        private String paymentId;
    private TaxAssessment assessment;
    private String paymentReference;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String paymentMethod;
    public TaxPayment() {}
    public TaxPayment(String paymentId, TaxAssessment assessment, String paymentReference, BigDecimal amount, LocalDate paymentDate, String paymentMethod) { this.paymentId=paymentId; this.assessment=assessment; this.paymentReference=paymentReference; this.amount=amount; this.paymentDate=paymentDate; this.paymentMethod=paymentMethod; }
        public String getPaymentId(){return paymentId;} public void setPaymentId(String v){paymentId=v;}
    public TaxAssessment getAssessment(){return assessment;} public void setAssessment(TaxAssessment v){assessment=v;}
    public String getPaymentReference(){return paymentReference;} public void setPaymentReference(String v){paymentReference=v;}
    public BigDecimal getAmount(){return amount;} public void setAmount(BigDecimal v){amount=v;}
    public LocalDate getPaymentDate(){return paymentDate;} public void setPaymentDate(LocalDate v){paymentDate=v;}
    public String getPaymentMethod(){return paymentMethod;} public void setPaymentMethod(String v){paymentMethod=v;}
    public String getId(){return String.valueOf(paymentId);}
    public String getDisplayName(){return String.valueOf(paymentId);}
    public boolean isActive(){return true;}
    public void validate() throws ValidationException {
        if(paymentId==null || String.valueOf(paymentId).trim().isEmpty()) throw new ValidationException("TaxPayment ID is required.");
    }
    public void printDetails(){System.out.println(getSummary());}
    public String getSummary(){return "TaxPayment: "+getId()+" - "+getDisplayName();}
    }
