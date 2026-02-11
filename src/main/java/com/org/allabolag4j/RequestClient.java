package com.org.allabolag4j;

import com.org.allabolag4j.exceptions.CompanyNotFoundException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


/**
 * HTTP client for fetching company pages from Allabolag.se.
 * Ensures that only the page containing company data is returned.
 * <p>
 * Due to abstract URL creation from allabolag.se and no public API,
 * we are forced to follow redirects to get the correct page URL and the response containing the company data.
 *
 *
 * @author Firas M.
 * @version 1.0
 */
public class RequestClient {
  private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";
  private static final String BASE_URL = "https://allabolag.se";

  private final HttpClient httpClient;

  public RequestClient(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  public HttpResponse<String> get(String orgNr) throws IOException {

    try {

      URI uri = URI.create(BASE_URL + "/" + orgNr);

      HttpRequest request = HttpRequest.newBuilder(uri)
        .GET()
        .header("User-Agent", USER_AGENT)
        .header("Accept", "*/*")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      // Check if body contains __NEXT_DATA__ to confirm it's the final page after redirect
      if (response.statusCode() == 200 && response.body().contains("__NEXT_DATA__")) {
        return response;
      }

      throw new CompanyNotFoundException(orgNr);

    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new IOException("Interrupted", e);
    }
  }
}
