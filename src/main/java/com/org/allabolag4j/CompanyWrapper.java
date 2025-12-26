package com.org.allabolag4j;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashMap;


/**
 * Wrapper around the JSON representation of a company fetched from Allabolag.se.
 * Provides convenient accessors for company details.
 *
 *
 * @author Firas M.
 * @version 1.0
 */
public class CompanyWrapper {
  private final JsonNode companyNode;

  public CompanyWrapper(JsonNode companyNode) {
    this.companyNode = companyNode;
  }

  public JsonNode getAllData() {
    return this.companyNode;
  }

  public String getName() {
    return companyNode.path("name").asText(null);
  }

  public String getOrgNr() {
    return companyNode.path("orgnr").asText(null);
  }

  public String getBusinessUnitType() {
    return companyNode.path("businessUnitType").asText(null);
  }

  public boolean isMarketingProtected() {
    return companyNode.path("marketingProtection").asBoolean(false);
  }

  public HashMap<String, String> getIndustries() {
    HashMap<String, String> industries = new HashMap<>();

    for (JsonNode industry : companyNode.path("industries")) {
      industries.put(String.valueOf(industry.path("code")), String.valueOf(industry.path("name")));
    }
    return industries;
  }

  public JsonNode getLocation() {
    return companyNode.path("location");
  }
}

