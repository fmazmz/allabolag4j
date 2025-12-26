package com.org.allabolag4j;

import java.io.IOException;
import java.net.CookieManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class RequestClient {
  private static final String USER_AGENT = "curl/8.5.0";
  private static final String BASE_URL = "https://allabolag.se";

  private final HttpClient httpClient;

  public RequestClient(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  public HttpResponse<String> get(String orgId) throws IOException {

    try {

      URI uri = URI.create(BASE_URL + "/" + orgId);

      HttpRequest request = HttpRequest.newBuilder(uri)
        .GET()
        .header("User-Agent", USER_AGENT)
        .header("Accept", "*/*")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      // Check if body contains __NEXT_DATA__ to confirm it's the final page
      if (response.statusCode() == 200 && response.body().contains("__NEXT_DATA__")) {
        return response;
      }

      return null;

    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new IOException("Interrupted", e);
    }
  }
}
