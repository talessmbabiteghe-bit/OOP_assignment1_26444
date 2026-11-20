package com.auca.abstracts;
import java.time.LocalDate;
public abstract class RegisteredTaxpayer extends TaxParty {
    private String tin, taxpayerStatus, district, sector, taxOffice;
    private LocalDate registrationDate;
    public RegisteredTaxpayer() {}
    public RegisteredTaxpayer(String id,String first,String last,String email,String phone,LocalDate dob,
      String tin,LocalDate reg,String status,String district,String sector,String office) {
      super(id,first,last,email,phone,dob); this.tin=tin; this.registrationDate=reg; this.taxpayerStatus=status; this.district=district; this.sector=sector; this.taxOffice=office;
    }
    public String getTin(){return tin;} public void setTin(String v){tin=v;}
    public LocalDate getRegistrationDate(){return registrationDate;} public void setRegistrationDate(LocalDate v){registrationDate=v;}
    public String getTaxpayerStatus(){return taxpayerStatus;} public void setTaxpayerStatus(String v){taxpayerStatus=v;}
    public String getDistrict(){return district;} public void setDistrict(String v){district=v;}
    public String getSector(){return sector;} public void setSector(String v){sector=v;}
    public String getTaxOffice(){return taxOffice;} public void setTaxOffice(String v){taxOffice=v;}
    @Override public boolean isActive(){return super.isActive() && "ACTIVE".equalsIgnoreCase(taxpayerStatus);}
    @Override public void printDetails(){super.printDetails(); System.out.println("TIN: "+tin+" | Status: "+taxpayerStatus+" | Registered: "+registrationDate+" | "+district+"/"+sector+" | Office: "+taxOffice);}
    @Override public String getSummary(){return tin+" - "+getDisplayName();}
}
