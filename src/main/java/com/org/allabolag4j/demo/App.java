package com.org.allabolag4j.demo;

import com.org.allabolag4j.AllabolagClient;
import com.org.allabolag4j.CompanyWrapper;


// Example Usage
public class App {
  public static void main(String[] args) throws Exception {


    AllabolagClient client = new AllabolagClient();
    CompanyWrapper company = client.getCompany("5568108988");

    System.out.println("Company name: " + company.getName());
    System.out.println("Industries: " + company.getIndustries());
    System.out.println("OrgNr: " + company.getOrgNr());
    System.out.println("Location: " + company.getLocation());
    System.out.println("isMarketingProtected: " + company.isMarketingProtected());
    System.out.println("Business Unit Type: " + company.getBusinessUnitType());
    System.out.println("FULL DATA: " + company.getAllData());
  }
}
