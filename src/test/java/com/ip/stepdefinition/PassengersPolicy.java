package com.ip.stepdefinition;

import com.ip.airport.BusinessFlight;
import com.ip.airport.EconomyFlight;
import com.ip.airport.Flight;
import com.ip.airport.Passenger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PassengersPolicy {

    private Flight economyFlight;
    private Flight businessFlight;
    private Passenger mike;
    private Passenger john;

    @Given("there is an economy flight")
    public void thereIsAnEconomyFlight() {
        economyFlight = new EconomyFlight("1");
    }

    @When("we have a usual passenger")
    public void weHaveAUsualPassenger() {
        mike  = new Passenger("Mike", false);
    }

    @Then("you can add and remove him from an economy flight")
    public void youCanAddAndRemoveHimFromAnEconomyFlight() {
        assertAll("Verify all conditions for a usual passenger and an economy flight",
                () -> assertEquals("1", economyFlight.getId()),
                () -> assertEquals(true, economyFlight.addPassenger(mike)),
                () -> assertEquals(1, economyFlight.getPassengersList().size()),
                () -> assertEquals("Mike", economyFlight.getPassengersList().get(0).getName()),
                () -> assertEquals(true, economyFlight.removePassenger(mike)),
                () -> assertEquals(0, economyFlight.getPassengersList().size())
        );
    }

    @When("we have a VIP passenger")
    public void weHaveAVIPPassenger() {
        john = new Passenger("John", true);
    }

    @Then("you can add him but cannot remove him from an economy flight")
    public void youCanAddHimButCannotRemoveHimFromAnEconomyFlight() {
        assertAll("Verify all conditions for a VIP passenger and an economy flight",
                () -> assertEquals("1", economyFlight.getId()),
                () -> assertEquals(true, economyFlight.addPassenger(john)),
                () -> assertEquals(1, economyFlight.getPassengersList().size()),
                () -> assertEquals("John", economyFlight.getPassengersList().get(0).getName()),
                () -> assertEquals(false, economyFlight.removePassenger(john)),
                () -> assertEquals(1, economyFlight.getPassengersList().size())
        );
    }

    @Given("there is an business flight")
    public void thereIsAnBusinessFlight() {
        businessFlight = new BusinessFlight("2");
    }

    @Then("you cannot add or remove him from a business flight")
    public void youCannotAddOrRemoveHimFromABusinessFlight() {
        assertAll("Verify all conditions for a usual passenger and a business flight",
                () -> assertEquals(false, businessFlight.addPassenger(mike)),
                () -> assertEquals(0, businessFlight.getPassengersList().size()),
                () -> assertEquals(false, businessFlight.removePassenger(mike)),
                () -> assertEquals(0, businessFlight.getPassengersList().size())
        );
    }

    @Then("you can add him but cannot remove him from a business flight")
    public void youCanAddHimButCannotRemoveHimFromABusinessFlight() {
        assertAll("Verify all conditions for a VIP passenger and a business flight",
                () -> assertEquals(true, businessFlight.addPassenger(john)),
                () -> assertEquals(1, businessFlight.getPassengersList().size()),
                () -> assertEquals(false, businessFlight.removePassenger(john)),
                () -> assertEquals(1, businessFlight.getPassengersList().size())
        );
    }
}
