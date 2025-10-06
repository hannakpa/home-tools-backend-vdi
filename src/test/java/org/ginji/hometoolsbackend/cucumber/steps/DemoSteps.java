package org.ginji.hometoolsbackend.cucumber.steps;

import io.cucumber.java.en.*;
import io.cucumber.spring.CucumberContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoSteps {
    @Given("a step")
    public void aStep() {
    }

    @When("something")
    public void something() {
    }

    @Then("a final step")
    public void aFinalStep() {
        assertThat("test").isEqualTo("test");
    }
}

