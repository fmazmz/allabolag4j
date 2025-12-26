package com.org.allabolag4j;

import java.net.CookieManager;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

public class App {
  private static final Logger logger = Logger.getLogger(App.class.getName());

  public static void main(String[] args) throws Exception {

    HttpClient client = HttpClient.newBuilder()
      .version(HttpClient.Version.HTTP_2)
      .followRedirects(HttpClient.Redirect.ALWAYS)
      .cookieHandler(new CookieManager())
      .build();

    RequestClient rc = new RequestClient(client);
    String orgId = "5562334804";

    HttpResponse<String> response = rc.get(orgId);

    if (response != null) {
      System.out.println("Status code: " + response.statusCode());
      System.out.println("Body length: " + response.body().length());
      System.out.println("Body: " + response.body());
    } else {
      System.out.println("No company data found in response.");
    }
  }
}
