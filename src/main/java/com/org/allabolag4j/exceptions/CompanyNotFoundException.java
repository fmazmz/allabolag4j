package com.org.allabolag4j.exceptions;

public class CompanyNotFoundException extends RuntimeException {
  public CompanyNotFoundException(String orgNr) {
    super("No company data found for orgNr: " + orgNr);
  }
}
