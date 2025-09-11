package org.ginji.hometoolsbackend.cucumber.steps;

import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoSteps {
    @Given("a step")
    public void aStep() {
    }

    @When("another step")
    public void anotherStep() {
    }

    @Then("a final step")
    public void aFinalStep() {
        assertThat("test").isEqualTo("test");
    }
}

