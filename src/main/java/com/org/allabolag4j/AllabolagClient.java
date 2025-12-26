package com.org.allabolag4j;

import java.io.IOException;
import java.net.CookieManager;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.org.allabolag4j.exceptions.AllabolagClientException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Client for fetching company data from Allabolag.se.
 * Provides structured access via CompanyWrapper.
 *
 * <p>Usage example:
 * <pre>{@code
 * AllabolagClient client = new AllabolagClient();
 * CompanyWrapper company = client.getCompany("5562334804");
 * }</pre>
 *
 * @author Firas M.
 * @version 1.0
 */
public class AllabolagClient {

  private final RequestClient requestClient;
  private final ObjectMapper mapper = new ObjectMapper();

  public AllabolagClient() {
    HttpClient client = HttpClient.newBuilder()
      .version(HttpClient.Version.HTTP_2)
      .followRedirects(HttpClient.Redirect.ALWAYS)
      .build();
    this.requestClient = new RequestClient(client);
  }

  public CompanyWrapper getCompany(String orgNr) throws IOException {
    HttpResponse<String> response;
    try {
      response = requestClient.get(orgNr);
    } catch (IOException e) {
        throw new AllabolagClientException("Failed to fetch company data", e);
    }

    if (response.body().isEmpty()) return null;

    Document doc = Jsoup.parse(response.body());
    Element scriptTag = doc.getElementById("__NEXT_DATA__");

    if (scriptTag == null) return null;

    try {
      JsonNode companyNode = mapper.readTree(scriptTag.data())
        .path("props")
        .path("pageProps")
        .path("company");

      if (companyNode.isMissingNode()) return null;
      return new CompanyWrapper(companyNode);

    } catch (JsonParseException e) {
        throw new IOException("Failed to parse JSON", e);
    }
    catch (JsonProcessingException e) {
      throw new AllabolagClientException("Failed to parse JSON", e);
    }
  }
}
