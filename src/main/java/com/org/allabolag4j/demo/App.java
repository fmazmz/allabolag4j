package com.org.allabolag4j.demo;

import com.org.allabolag4j.AccountLine;
import com.org.allabolag4j.AllabolagClient;
import com.org.allabolag4j.CompanyWrapper;
import com.org.allabolag4j.FinancialReport;

import java.util.List;


// Example Usage
public class App {
    static void main(String[] args) throws Exception {


        AllabolagClient client = new AllabolagClient();
        CompanyWrapper company = client.getCompany("5593837221");

        System.out.println("Company name: " + company.getName());
        System.out.println("Industries: " + company.getIndustries());
        System.out.println("OrgNr: " + company.getOrgNr());
        System.out.println("Location: " + company.getLocation());
        System.out.println("isMarketingProtected: " + company.isMarketingProtected());
        System.out.println("Business Unit Type: " + company.getBusinessUnitType());
        System.out.println("FULL DATA: " + company.getAllData());

        List<FinancialReport> financialReports = company.getFinancialReports();

        for (FinancialReport report : financialReports) {
            System.out.println("Report for period " + report.period() + ":");

            for (AccountLine line : report.accounts()) {
                System.out.println(line.code() + " : " + line.amount());
            }
        }
    }
}
