package com.auca.revenueofficer;

import com.auca.abstracts.TaxParty;
    import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.abstracts.TaxParty;
import com.auca.exceptions.ValidationException;
    public class RevenueOfficer extends TaxParty {
        private String staffNumber;
    private String department;
    private String role;
    private LocalDate hireDate;
    private BigDecimal approvalLimit;
    private boolean active;
    public RevenueOfficer() {}
    public RevenueOfficer(String staffNumber, String department, String role, LocalDate hireDate, BigDecimal approvalLimit, boolean active) { this.staffNumber=staffNumber; this.department=department; this.role=role; this.hireDate=hireDate; this.approvalLimit=approvalLimit; this.active=active; }
        public String getStaffNumber(){return staffNumber;} public void setStaffNumber(String v){staffNumber=v;}
    public String getDepartment(){return department;} public void setDepartment(String v){department=v;}
    public String getRole(){return role;} public void setRole(String v){role=v;}
    public LocalDate getHireDate(){return hireDate;} public void setHireDate(LocalDate v){hireDate=v;}
    public BigDecimal getApprovalLimit(){return approvalLimit;} public void setApprovalLimit(BigDecimal v){approvalLimit=v;}
    public boolean getActive(){return active;} public void setActive(boolean v){active=v;}
    public boolean isActive(){return active;}
    public void validate() throws ValidationException {
        if(staffNumber==null || String.valueOf(staffNumber).trim().isEmpty()) throw new ValidationException("RevenueOfficer ID is required.");
    }
    public void printDetails(){System.out.println(getSummary());}
    public String getSummary(){return "RevenueOfficer: "+getId()+" - "+getDisplayName();}
    }
