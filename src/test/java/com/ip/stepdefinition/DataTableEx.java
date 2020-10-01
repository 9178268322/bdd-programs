package com.ip.stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class DataTableEx {

    @Given("the url")
    public void theUrl() {
    }

    @When("user enters username and password")
    public void userEntersUsernameAndPassword(DataTable userCredentials) {
        List<String> credentials = userCredentials.row(0);
        System.out.println(credentials.get(0));
        System.out.println(credentials.get(1));
    }

    @Then("validate profile page")
    public void validateProfilePage() {
    }
}
