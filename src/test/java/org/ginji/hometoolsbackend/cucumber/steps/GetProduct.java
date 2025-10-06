package org.ginji.hometoolsbackend.cucumber.steps;
import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetProduct {

    @LocalServerPort
    private int port;

   @Autowired
    private TestRestTemplate restTemplate;
    private ResponseEntity<String> response;

    @Given("the product {string} exists")
    public void firstStep(String productName) {
    }

    @When("I look for the product {string}")
    public void secondStep(String productName) {
        String url = "http://localhost:" + port + "/api/products/search/" + productName;
        response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                String.class
        );
    }



    @Then("I receive information about the product {string}")
    public void thirdStep(String productName) {
        String url = "http://localhost:" + port + "/api/products/search/" + productName;
        response = restTemplate.getForEntity(url, String.class);
        System.out.println("Response: " + response.getBody());
        System.out.println("HTTP Status: " + response.getStatusCode());
    }
}
