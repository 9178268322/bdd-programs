package com.ip.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScenarioOutLine {

    @Given("there are {int} cucumbers")
    public void thereAreStartCucumbers(int totalCucumbers) {
        System.out.println(totalCucumbers);
    }

    @When("I eat {int} cucumbers")
    public void iEatEatCucumbers(int eatCucumbers) {
        System.out.println(eatCucumbers);
    }

    @Then("I should have {int} cucumbers")
    public void iShouldHaveLeftCucumbers(int leftCucumbers) {
        System.out.println(leftCucumbers);
    }
}
