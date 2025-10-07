package org.ginji.hometoolsbackend.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import org.wiremock.spring.EnableWireMock;


import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableWireMock
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetProduct_Wiremock {
    @Autowired
    private TestRestTemplate restTemplate;

    @Given("the product {string} exists")
    public void firstStep(String productName) {
        System.out.print("LOG " + productName);
        stubFor(get("/ping").willReturn(ok("pong")));
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/ping", String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Response: " + response.getBody());
        }
    }

    @When("I look for the product {string}")
    public void secondStep(String productName) {
    }


    @Then("I receive information about the product {string}")
    public void thirdStep(String productName) {
    }
}
