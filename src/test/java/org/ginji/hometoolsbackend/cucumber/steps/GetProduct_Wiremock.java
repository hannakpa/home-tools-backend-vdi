package org.ginji.hometoolsbackend.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.ginji.hometoolsbackend.util.WireMockUtilProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.wiremock.spring.ConfigureWireMock;
import org.wiremock.spring.EnableWireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@EnableWireMock(@ConfigureWireMock(name = "product-service"))
@SpringBootTest
public class GetProduct_Wiremock {
    //@Value("${wiremock.server.baseUrl}")

    @Autowired
    private WireMockUtilProduct wireMockUtilProduct;

    @Given("the product {string} exists")
    public void firstStep(String productName) {
        {
            System.out.println("WireMockUtilProduct: " + wireMockUtilProduct);
            wireMockUtilProduct.stubProduct(productName);
            System.out.println("WireMock URL: " + wireMockUtilProduct.getBaseUrl());
        }
    }

    @When("I look for the product {string}")
    public void secondStep(String productName) {
    }


    @Then("I receive information about the product {string}")
    public void thirdStep(String productName) {
    }
}
