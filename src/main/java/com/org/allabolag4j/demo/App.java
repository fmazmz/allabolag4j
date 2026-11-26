package com.org.allabolag4j.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.allabolag4j.AllabolagClient;
import com.org.allabolag4j.wrapper.CompanyWrapper;
import com.org.allabolag4j.wrapper.FinancialReport;

import java.util.List;


// Example Usage
public class App {
    static void main(String[] args) throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();


        AllabolagClient client = new AllabolagClient();
        CompanyWrapper company = client.getCompany("5593837221");

        System.out.println("Company name: " + company.getName());
        System.out.println("Industries: " + company.getIndustries());
        System.out.println("OrgNr: " + company.getOrgNr());
        System.out.println("Location: " + company.getLocation());
        System.out.println("isMarketingProtected: " + company.isMarketingProtected());
        System.out.println("Business Unit Type: " + company.getBusinessUnitType());
        System.out.println("FULL DATA: " + company.getAllData());

        // Get all FinancialReports found for the company
        List<FinancialReport> financialReports = company.getFinancialReports();
        for (FinancialReport report : financialReports) {
            System.out.println("Report for period " + report.period() + ":");

            System.out.println(objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(report));
        }

        // Filter for a specific FinancialReport by year
        FinancialReport report = company.getFinancialReports()
                .stream()
                .filter(r -> r.year().equals("2025"))
                .findFirst().orElseThrow();

        // Get all AccountLines including code and amount with JSON pretty print
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(report.amountsByCode()));

        // Get a specific AccountLine by code
        System.out.println("EBIDTA: " + report.amount("EBITDA"));
    }
}
