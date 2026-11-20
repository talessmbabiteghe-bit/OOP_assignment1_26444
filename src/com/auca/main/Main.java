package com.auca.main;
import java.util.Scanner;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.abstracts.*;
import com.auca.interfaces.*;
import com.auca.exceptions.*;
import com.auca.individualtaxpayer.*;
import com.auca.corporatetaxpayer.*;
import com.auca.revenueofficer.*;
import com.auca.taxtype.*;
import com.auca.taxobligation.*;
import com.auca.taxdeclaration.*;
import com.auca.taxassessment.*;
import com.auca.taxpayment.*;
import com.auca.penalty.*;
import com.auca.taxrefund.*;
import com.auca.taxclearance.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static IndividualTaxpayer[] individuals = new IndividualTaxpayer[100]; static int individualCount=0;
    static CorporateTaxpayer[] companies = new CorporateTaxpayer[100]; static int companyCount=0;
    static RevenueOfficer[] officers = new RevenueOfficer[100]; static int officerCount=0;
    static TaxType[] taxTypes = new TaxType[100]; static int taxTypeCount=0;
    static TaxObligation[] obligations = new TaxObligation[200]; static int obligationCount=0;
    static TaxDeclaration[] declarations = new TaxDeclaration[300]; static int declarationCount=0;
    static TaxAssessment[] assessments = new TaxAssessment[300]; static int assessmentCount=0;
    static TaxPayment[] payments = new TaxPayment[300]; static int paymentCount=0;
    static Penalty[] penalties = new Penalty[300]; static int penaltyCount=0;
    static TaxRefund[] refunds = new TaxRefund[100]; static int refundCount=0;
    static TaxClearance[] clearances = new TaxClearance[100]; static int clearanceCount=0;

    public static void main(String[] args) {
        while(true) {
            System.out.println("\n================ TAX ADMINISTRATION MANAGEMENT ================");
            System.out.println("1 Register Individual Taxpayer     12 Record Tax Payment");
            System.out.println("2 Register Corporate Taxpayer      13 Calculate / Record Penalty");
            System.out.println("3 Register Revenue Officer         14 Request / Approve Refund");
            System.out.println("4 Register Tax Type                15 Request / Issue Tax Clearance");
            System.out.println("5 Create Tax Obligation            16 Search Record by ID / TIN");
            System.out.println("6 File Tax Declaration             17 Update Eligible Record");
            System.out.println("7 Assess Declaration               18 View Taxpayer Statement");
            System.out.println("8 Confirm Assessment               19 View Outstanding Balances");
            System.out.println("9 View All Records                 20 View Tax Reports");
            System.out.println("10 View Declaration History        21 Demonstrate Polymorphism");
            System.out.println("11 View Assessment History          0 Exit");
            int choice=number("Select option: ");
            switch(choice) {
                case 1: registerIndividual(); break; case 2: registerCompany(); break;
                case 3: registerOfficer(); break; case 4: registerTaxType(); break;
                case 5: createObligation(); break; case 6: fileDeclaration(); break;
                case 7: assessDeclaration(); break; case 8: confirmAssessment(); break;
                case 9: viewAll(); break; case 10: declarationHistory(); break;
                case 11: assessmentHistory(); break; case 12: recordPayment(); break;
                case 13: recordPenalty(); break; case 14: requestRefund(); break;
                case 15: requestClearance(); break; case 16: searchRecord(); break;
                case 17: updateRecord(); break; case 18: taxpayerStatement(); break;
                case 19: outstandingBalances(); break; case 20: reports(); break;
                case 21: demonstratePolymorphism(); break; case 0: System.out.println("Thank you."); return;
                default: System.out.println("Invalid option!");
            }
        }
    }
    static String line(String label){System.out.print(label); return sc.nextLine().trim();}
    static int number(String label){while(true){try{return Integer.parseInt(line(label));}catch(Exception e){System.out.println("Enter a valid whole number.");}}}
    static BigDecimal money(String label){while(true){try{return new BigDecimal(line(label));}catch(Exception e){System.out.println("Enter a valid amount.");}}}
    static LocalDate date(String label){while(true){try{return LocalDate.parse(line(label));}catch(Exception e){System.out.println("Use YYYY-MM-DD.");}}}
    static RegisteredTaxpayer findTaxpayer(String tin){
        for(int i=0;i<individualCount;i++) if(individuals[i].getTin().equals(tin)) return individuals[i];
        for(int i=0;i<companyCount;i++) if(companies[i].getTin().equals(tin)) return companies[i]; return null;
    }
    static TaxType findType(String id){for(int i=0;i<taxTypeCount;i++) if(taxTypes[i].getId().equals(id)) return taxTypes[i]; return null;}
    static TaxObligation findObligation(String id){for(int i=0;i<obligationCount;i++) if(obligations[i].getId().equals(id)) return obligations[i]; return null;}
    static TaxDeclaration findDeclaration(String id){for(int i=0;i<declarationCount;i++) if(declarations[i].getId().equals(id)) return declarations[i]; return null;}
    static TaxAssessment findAssessment(String id){for(int i=0;i<assessmentCount;i++) if(assessments[i].getId().equals(id)) return assessments[i]; return null;}
    static boolean uniqueTin(String tin){return findTaxpayer(tin)==null;}
    static void registerIndividual(){
        if(individualCount==100){System.out.println("Storage full.");return;}
        System.out.println("-- REGISTER INDIVIDUAL TAXPAYER --");
        String id=line("Party ID: "), fn=line("First name: "), ln=line("Last name: "), email=line("Email: "), phone=line("Phone: ");
        LocalDate dob=date("Date of birth (YYYY-MM-DD): ");
        String tin=line("TIN (9 digits): "); if(!tin.matches("\\d{9}")||!uniqueTin(tin)){System.out.println("Invalid or duplicate TIN.");return;}
        LocalDate reg=date("Registration date: "); String status="ACTIVE", district=line("District: "), sector=line("Sector: "), office=line("Tax office: ");
        String nid=line("National ID (16 digits): "); if(!nid.matches("\\d{16}")){System.out.println("Invalid national ID.");return;}
        String occupation=line("Occupation: "), business=line("Business name: "); LocalDate start=date("Business start date: ");
        BigDecimal turnover=money("Annual turnover: "); String res=line("Resident (YES/NO): ");
        IndividualTaxpayer x=new IndividualTaxpayer(); x.setPartyId(id);x.setFirstName(fn);x.setLastName(ln);x.setEmail(email);x.setPhoneNumber(phone);x.setDateOfBirth(dob);
        x.setTin(tin);x.setRegistrationDate(reg);x.setTaxpayerStatus(status);x.setDistrict(district);x.setSector(sector);x.setTaxOffice(office);
        x.setNationalId(nid);x.setOccupation(occupation);x.setBusinessName(business);x.setBusinessStartDate(start);x.setAnnualTurnover(turnover);x.setResident(res.equalsIgnoreCase("YES"));
        try{x.validate(); individuals[individualCount++]=x;System.out.println("Individual taxpayer saved.");}catch(ValidationException e){System.out.println(e.getMessage());}
    }
    static void registerCompany(){
        if(companyCount==100){System.out.println("Storage full.");return;}
        System.out.println("-- REGISTER CORPORATE TAXPAYER --");
        String id=line("Party ID: "), fn=line("Contact first name: "), ln=line("Contact last name: "), email=line("Email: "), phone=line("Phone: ");
        LocalDate dob=date("Contact date of birth: "); String tin=line("TIN (9 digits): ");
        if(!tin.matches("\\d{9}")||!uniqueTin(tin)){System.out.println("Invalid or duplicate TIN.");return;}
        LocalDate reg=date("Registration date: "); String district=line("District: "), sector=line("Sector: "), office=line("Tax office: ");
        String cr=line("Company registration number: "), legal=line("Legal name: "); LocalDate inc=date("Incorporation date: ");
        String bs=line("Business sector: "), rep=line("Authorized representative: "); BigDecimal turnover=money("Annual turnover: ");
        CorporateTaxpayer x=new CorporateTaxpayer();x.setPartyId(id);x.setFirstName(fn);x.setLastName(ln);x.setEmail(email);x.setPhoneNumber(phone);x.setDateOfBirth(dob);
        x.setTin(tin);x.setRegistrationDate(reg);x.setTaxpayerStatus("ACTIVE");x.setDistrict(district);x.setSector(sector);x.setTaxOffice(office);
        x.setCompanyRegistrationNo(cr);x.setLegalName(legal);x.setIncorporationDate(inc);x.setBusinessSector(bs);x.setAuthorizedRepresentative(rep);x.setAnnualTurnover(turnover);
        try{x.validate();companies[companyCount++]=x;System.out.println("Corporate taxpayer saved.");}catch(ValidationException e){System.out.println(e.getMessage());}
    }
    static void registerOfficer(){
        if(officerCount==100){System.out.println("Storage full.");return;}
        RevenueOfficer x=new RevenueOfficer(); x.setPartyId(line("Officer party ID: "));x.setFirstName(line("First name: "));x.setLastName(line("Last name: "));
        x.setEmail(line("Email: "));x.setPhoneNumber(line("Phone: "));x.setDateOfBirth(date("Date of birth: "));
        x.setStaffNumber(line("Staff number: "));x.setDepartment(line("Department: "));x.setRole(line("Role: "));x.setHireDate(date("Hire date: "));
        x.setApprovalLimit(money("Approval limit: "));x.setActive(true);
        try{x.validate();officers[officerCount++]=x;System.out.println("Officer saved.");}catch(ValidationException e){System.out.println(e.getMessage());}
    }
    static void registerTaxType(){
        if(taxTypeCount==100){System.out.println("Storage full.");return;}
        TaxType t=new TaxType(line("Tax type ID: "),line("Tax code: "),line("Tax name: "),money("Rate (%): "),line("Frequency (MONTHLY/QUARTERLY/ANNUAL): "),true);
        try{t.validate(); if(t.getRate().compareTo(BigDecimal.ZERO)<0||t.getRate().compareTo(new BigDecimal("100"))>0)throw new ValidationException("Rate must be 0-100.");taxTypes[taxTypeCount++]=t;System.out.println("Tax type saved.");}catch(ValidationException e){System.out.println(e.getMessage());}
    }
    static void createObligation(){
        RegisteredTaxpayer p=findTaxpayer(line("Taxpayer TIN: ")); if(p==null||!p.isActive()){System.out.println("Active taxpayer not found.");return;}
        TaxType t=findType(line("Tax type ID: "));if(t==null||!t.isActive()){System.out.println("Active tax type not found.");return;}
        LocalDate start=date("Period start: "),end=date("Period end: "),due=date("Due date: ");
        if(start.isAfter(end)||due.isBefore(end)){System.out.println("Invalid tax period or due date.");return;}
        TaxObligation o=new TaxObligation(line("Obligation ID: "),p,t,start,end,due);obligations[obligationCount++]=o;System.out.println("Obligation saved.");
    }
    static void fileDeclaration(){
        TaxObligation o=findObligation(line("Obligation ID: "));if(o==null){System.out.println("Obligation not found.");return;}
        for(int i=0;i<declarationCount;i++)if(declarations[i].getObligation()==o&&!"REJECTED".equals(declarations[i].getStatus())){System.out.println("An active declaration already exists.");return;}
        LocalDate filing=date("Filing date: ");BigDecimal taxable=money("Taxable amount: ");
        BigDecimal expected=taxable.multiply(o.getTaxType().getRate()).divide(new BigDecimal("100"),2,java.math.RoundingMode.HALF_UP);
        BigDecimal declared=money("Declared tax (expected "+expected+"): ");
        if(declared.subtract(expected).abs().compareTo(new BigDecimal("0.01"))>0){System.out.println("Declared tax does not match expected tax.");return;}
        String status=filing.isAfter(o.getDueDate())?"LATE":"FILED";
        declarations[declarationCount++]=new TaxDeclaration(line("Declaration ID: "),o,filing,taxable,declared,status);System.out.println("Declaration saved: "+status);
    }
    static void assessDeclaration(){
        TaxDeclaration d=findDeclaration(line("Declaration ID: "));if(d==null||"REJECTED".equals(d.getStatus())){System.out.println("Eligible declaration not found.");return;}
        TaxAssessment a=new TaxAssessment(line("Assessment ID: "),d,d.getDeclaredTax(),BigDecimal.ZERO,LocalDate.now(),"DRAFT");
        assessments[assessmentCount++]=a;System.out.println("Assessment created as DRAFT.");
    }
    static void confirmAssessment(){
        TaxAssessment a=findAssessment(line("Assessment ID: "));if(a==null){System.out.println("Assessment not found.");return;}
        if(!"DRAFT".equals(a.getStatus())){System.out.println("Only DRAFT assessments can be confirmed.");return;}
        if(a.getAssessedTax().add(a.getAdjustmentAmount()).compareTo(BigDecimal.ZERO)<0){System.out.println("Total cannot be negative.");return;}
        a.setStatus("CONFIRMED");System.out.println("Assessment confirmed.");
    }
    static void recordPayment(){
        TaxAssessment a=findAssessment(line("Assessment ID: "));if(a==null||!"CONFIRMED".equals(a.getStatus())){System.out.println("Confirmed assessment required.");return;}
        String ref=line("Payment reference: ");for(int i=0;i<paymentCount;i++)if(payments[i].getPaymentReference().equals(ref)){System.out.println("Duplicate reference.");return;}
        BigDecimal amount=money("Payment amount: ");if(amount.compareTo(BigDecimal.ZERO)<=0){System.out.println("Amount must be positive.");return;}
        BigDecimal balance=a.getAssessedTax().add(a.getAdjustmentAmount());for(int i=0;i<paymentCount;i++)if(payments[i].getAssessment()==a)balance=balance.subtract(payments[i].getAmount());
        if(amount.compareTo(balance)>0){System.out.println("Payment exceeds outstanding balance "+balance);return;}
        payments[paymentCount++]=new TaxPayment(line("Payment ID: "),a,ref,amount,date("Payment date: "),line("Payment method: "));
        System.out.println("Payment recorded.");
    }
    static void recordPenalty(){
        TaxObligation o=findObligation(line("Obligation ID: "));if(o==null){System.out.println("Obligation not found.");return;}
        BigDecimal base=money("Penalty base amount: "),rate=new BigDecimal("5.00");
        BigDecimal amount=base.multiply(rate).divide(new BigDecimal("100"),2,java.math.RoundingMode.HALF_UP);
        penalties[penaltyCount++]=new Penalty(line("Penalty ID: "),o,"LATE_FILING",base,rate,amount);
        System.out.println("Illustrative 5% penalty: "+amount);
    }
    static void requestRefund(){
        RegisteredTaxpayer p=findTaxpayer(line("Taxpayer TIN: "));if(p==null){System.out.println("Taxpayer not found.");return;}
        TaxAssessment a=findAssessment(line("Assessment ID: "));if(a==null){System.out.println("Assessment not found.");return;}
        BigDecimal requested=money("Refund amount: ");BigDecimal paid=BigDecimal.ZERO;
        for(int i=0;i<paymentCount;i++)if(payments[i].getAssessment()==a)paid=paid.add(payments[i].getAmount());
        BigDecimal over=paid.subtract(a.getAssessedTax().add(a.getAdjustmentAmount()));
        if(over.compareTo(BigDecimal.ZERO)<=0||requested.compareTo(over)>0){System.out.println("No verified overpayment or amount exceeds overpayment.");return;}
        TaxRefund r=new TaxRefund(line("Refund ID: "),p,a,requested,LocalDate.now(),"PENDING");
        System.out.println("Refund request saved as PENDING. Officer approval can be completed after review.");
        refunds[refundCount++]=r;
    }
    static void requestClearance(){
        RegisteredTaxpayer p=findTaxpayer(line("Taxpayer TIN: "));if(p==null){System.out.println("Taxpayer not found.");return;}
        LocalDate expiry=date("Expiry date: ");if(!expiry.isAfter(LocalDate.now())){System.out.println("Expiry must be after today.");return;}
        RevenueOfficer officer=null;String staff=line("Approving officer staff number: ");
        for(int i=0;i<officerCount;i++)if(officers[i].getStaffNumber().equals(staff)&&officers[i].isActive())officer=officers[i];
        if(officer==null){System.out.println("Active officer not found.");return;}
        boolean debt=false;for(int i=0;i<obligationCount;i++)if(obligations[i].getTaxpayer()==p&&obligations[i].getDueDate().isBefore(LocalDate.now()))debt=true;
        if(debt){System.out.println("Clearance blocked: overdue obligation exists.");return;}
        clearances[clearanceCount++]=new TaxClearance(line("Clearance ID: "),p,LocalDate.now(),expiry,"APPROVED",officer);
        System.out.println("Clearance approved.");
    }
    static void viewAll(){
        System.out.println("-- INDIVIDUAL TAXPAYERS --");for(int i=0;i<individualCount;i++)individuals[i].printDetails();
        System.out.println("-- CORPORATE TAXPAYERS --");for(int i=0;i<companyCount;i++)companies[i].printDetails();
        System.out.println("-- OFFICERS --");for(int i=0;i<officerCount;i++)officers[i].printDetails();
        System.out.println("-- TAX TYPES --");for(int i=0;i<taxTypeCount;i++)taxTypes[i].printDetails();
        System.out.println("-- OBLIGATIONS --");for(int i=0;i<obligationCount;i++)obligations[i].printDetails();
        System.out.println("-- DECLARATIONS --");for(int i=0;i<declarationCount;i++)declarations[i].printDetails();
        System.out.println("-- ASSESSMENTS --");for(int i=0;i<assessmentCount;i++)assessments[i].printDetails();
        System.out.println("-- PAYMENTS --");for(int i=0;i<paymentCount;i++)payments[i].printDetails();
        System.out.println("-- PENALTIES --");for(int i=0;i<penaltyCount;i++)penalties[i].printDetails();
        System.out.println("-- REFUNDS --");for(int i=0;i<refundCount;i++)refunds[i].printDetails();
        System.out.println("-- CLEARANCES --");for(int i=0;i<clearanceCount;i++)clearances[i].printDetails();
    }
    static void declarationHistory(){for(int i=0;i<declarationCount;i++)declarations[i].printDetails();}
    static void assessmentHistory(){for(int i=0;i<assessmentCount;i++)assessments[i].printDetails();}
    static void searchRecord(){
        String key=line("Enter ID or TIN: ");boolean found=false;
        for(int i=0;i<individualCount;i++)if(individuals[i].getId().equals(key)||individuals[i].getTin().equals(key)){individuals[i].printDetails();found=true;}
        for(int i=0;i<companyCount;i++)if(companies[i].getId().equals(key)||companies[i].getTin().equals(key)){companies[i].printDetails();found=true;}
        for(int i=0;i<taxTypeCount;i++)if(taxTypes[i].getId().equals(key)){taxTypes[i].printDetails();found=true;}
        for(int i=0;i<obligationCount;i++)if(obligations[i].getId().equals(key)){obligations[i].printDetails();found=true;}
        for(int i=0;i<declarationCount;i++)if(declarations[i].getId().equals(key)){declarations[i].printDetails();found=true;}
        for(int i=0;i<assessmentCount;i++)if(assessments[i].getId().equals(key)){assessments[i].printDetails();found=true;}
        if(!found)System.out.println("Record not found.");
    }
    static void updateRecord(){
        String tin=line("Taxpayer TIN to update: ");RegisteredTaxpayer p=findTaxpayer(tin);
        if(p==null){System.out.println("Taxpayer not found.");return;}
        System.out.println("1 Update email  2 Update phone  3 Update district");
        int c=number("Choose field: ");if(c==1)p.setEmail(line("New email: "));else if(c==2)p.setPhoneNumber(line("New phone: "));else if(c==3)p.setDistrict(line("New district: "));else System.out.println("Invalid field.");
        System.out.println("Update completed.");
    }
    static void taxpayerStatement(){
        RegisteredTaxpayer p=findTaxpayer(line("Taxpayer TIN: "));if(p==null){System.out.println("Taxpayer not found.");return;}
        p.printDetails();
        for(int i=0;i<obligationCount;i++)if(obligations[i].getTaxpayer()==p){obligations[i].printDetails();
            for(int j=0;j<declarationCount;j++)if(declarations[j].getObligation()==obligations[i])declarations[j].printDetails();}
    }
    static void outstandingBalances(){
        for(int i=0;i<assessmentCount;i++)if("CONFIRMED".equals(assessments[i].getStatus())){
            BigDecimal bal=assessments[i].getAssessedTax().add(assessments[i].getAdjustmentAmount());
            for(int j=0;j<paymentCount;j++)if(payments[j].getAssessment()==assessments[i])bal=bal.subtract(payments[j].getAmount());
            System.out.println(assessments[i].getId()+" outstanding: "+bal);
        }
    }
    static void reports(){
        System.out.println("Individuals: "+individualCount+" | Companies: "+companyCount+" | Officers: "+officerCount);
        System.out.println("Tax types: "+taxTypeCount+" | Obligations: "+obligationCount+" | Declarations: "+declarationCount);
        System.out.println("Assessments: "+assessmentCount+" | Payments: "+paymentCount+" | Penalties: "+penaltyCount+" | Refunds: "+refundCount+" | Clearances: "+clearanceCount);
        BigDecimal total=BigDecimal.ZERO;for(int i=0;i<paymentCount;i++)total=total.add(payments[i].getAmount());
        System.out.println("Total payments received: "+total);
    }
    static void demonstratePolymorphism(){
        TaxParty[] parties=new TaxParty[individualCount+companyCount+officerCount];int n=0;
        for(int i=0;i<individualCount;i++)parties[n++]=individuals[i];
        for(int i=0;i<companyCount;i++)parties[n++]=companies[i];
        for(int i=0;i<officerCount;i++)parties[n++]=officers[i];
        Identifiable[] ids=new Identifiable[n];for(int i=0;i<n;i++)ids[i]=parties[i];
        System.out.println("-- TaxParty[] runtime polymorphism --");for(int i=0;i<n;i++)parties[i].printDetails();
        System.out.println("-- Identifiable[] interface polymorphism --");for(int i=0;i<n;i++)System.out.println(ids[i].getId()+" | "+ids[i].getDisplayName()+" | active="+ids[i].isActive());
    }
}
