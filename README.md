# Allabolag4J

Allabolag4J is a lightweight Java SDK for fetching company information from [Allabolag.se](https://www.allabolag.se).
It wraps the JSON data from the website into easy-to-use Java objects, allowing developers to access company details programmatically.

## Features

- Fetch company data by organization number
- Access company name, business unit type, industries (SNI), and location... (more coming soon)

## Installation

Include Allabolag4J as a dependency using JitPack:

**Maven**
```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependency>
  <groupId>com.github.fmazmz</groupId>
  <artifactId>allabolag4j</artifactId>
  <version>v1.0.0</version>
</dependency>
```

**Gradle**
```
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.YourUsername:allabolag4j:v1.0.0'
}
```

## Usage Example
```java
import com.org.allabolag4j.AllabolagClient;
import com.org.allabolag4j.CompanyWrapper;

public class Demo {
    public static void main(String[] args) throws Exception {
        AllabolagClient client = new AllabolagClient();
        CompanyWrapper company = client.getCompany("5562334804");

        if (company != null) {
            System.out.println("Company name: " + company.getName());
            System.out.println("Industries: " + company.getIndustries());
            System.out.println("OrgNr: " + company.getOrgNr());
            System.out.println("Location: " + company.getLocation());
            System.out.println("Marketing protected: " + company.isMarketingProtected());
            System.out.println("Business Unit Type: " + company.getBusinessUnitType());
        } else {
            System.out.println("Company not found.");
        }
    }
}
```
## Dependencies

- [Jsoup](https://jsoup.org/) – for parsing HTML
- [Jackson Databind](https://github.com/FasterXML/jackson-databind) – for JSON parsing

## License

This project is licensed under the MIT License – see the [LICENSE](https://github.com/fmazmz/allabolag4j/blob/master/LICENSE) file for details.

## Contributing

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Make your changes and commit them.
4. Push your branch and open a pull request.

Please ensure your code is clean, follows the project structure, and includes appropriate Javadocs for new classes or methods.

## Development

To build the project locally:

1. Clone the repository:
   ```bash
   git clone https://github.com/fmazmz/allabolag4j.git

## Author
Firas M.
