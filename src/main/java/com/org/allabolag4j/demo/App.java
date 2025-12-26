package com.org.allabolag4j.demo;

import com.org.allabolag4j.AllabolagClient;
import com.org.allabolag4j.CompanyWrapper;

public class App {
  public static void main(String[] args) throws Exception {

    // ex usage "Microsoft"
    AllabolagClient client = new AllabolagClient();
    CompanyWrapper company = client.getCompany("5562334804");

    if (company != null) {
      System.out.println("Company name: " + company.getName());
      System.out.println("Industries: " + company.getIndustries());
      System.out.println("OrgNr: " + company.getOrgNr());
      System.out.println("Location: " + company.getLocation());
      System.out.println("isMarketingProtected: " + company.isMarketingProtected());
      System.out.println("Business Unit Type: " + company.getBusinessUnitType());
    } else {
      System.out.println("Company not found.");
    }
  }
}
