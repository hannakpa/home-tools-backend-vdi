package org.ginji.hometoolsbackend.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import org.wiremock.spring.EnableWireMock;
import org.springframework.beans.factory.annotation.Value;


import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableWireMock
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetProduct_Wiremock {
    @Value("${wiremock.server.baseUrl}")
    private String wireMockUrl;

    @Autowired
    private TestRestTemplate restTemplate;

    @Given("the product {string} exists")
    public void firstStep(String productName) {
        System.out.print("LOG " + productName);
        //stubFor(get("/ping").willReturn(ok("pong")));
        String mockResponse = "{\"message\": \"Eggs!\"}";
        //return a Json
        stubFor(get("/api/products")
                .willReturn(okJson(mockResponse)));
        ResponseEntity<String> response = restTemplate.getForEntity(wireMockUrl+"/api/products", String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Response: " + response.getBody());
        }
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
    }

    @When("I look for the product {string}")
    public void secondStep(String productName) {
    }


    @Then("I receive information about the product {string}")
    public void thirdStep(String productName) {
    }
}
