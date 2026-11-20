package com.auca.taxassessment;

import com.auca.taxdeclaration.TaxDeclaration;
    import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
    public class TaxAssessment implements Identifiable, Validatable {
        private String assessmentId;
    private TaxDeclaration declaration;
    private BigDecimal assessedTax;
    private BigDecimal adjustmentAmount;
    private LocalDate assessmentDate;
    private String status;
    public TaxAssessment() {}
    public TaxAssessment(String assessmentId, TaxDeclaration declaration, BigDecimal assessedTax, BigDecimal adjustmentAmount, LocalDate assessmentDate, String status) { this.assessmentId=assessmentId; this.declaration=declaration; this.assessedTax=assessedTax; this.adjustmentAmount=adjustmentAmount; this.assessmentDate=assessmentDate; this.status=status; }
        public String getAssessmentId(){return assessmentId;} public void setAssessmentId(String v){assessmentId=v;}
    public TaxDeclaration getDeclaration(){return declaration;} public void setDeclaration(TaxDeclaration v){declaration=v;}
    public BigDecimal getAssessedTax(){return assessedTax;} public void setAssessedTax(BigDecimal v){assessedTax=v;}
    public BigDecimal getAdjustmentAmount(){return adjustmentAmount;} public void setAdjustmentAmount(BigDecimal v){adjustmentAmount=v;}
    public LocalDate getAssessmentDate(){return assessmentDate;} public void setAssessmentDate(LocalDate v){assessmentDate=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
    public String getId(){return String.valueOf(assessmentId);}
    public String getDisplayName(){return String.valueOf(assessmentId);}
    public boolean isActive(){return true;}
    public void validate() throws ValidationException {
        if(assessmentId==null || String.valueOf(assessmentId).trim().isEmpty()) throw new ValidationException("TaxAssessment ID is required.");
    }
    public void printDetails(){System.out.println(getSummary());}
    public String getSummary(){return "TaxAssessment: "+getId()+" - "+getDisplayName();}
    }
