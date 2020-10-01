package com.ip.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features/scenario_outline.feature"},
        glue = {"classpath:com/ip/stepdefinition"})
public class ScenarioOutLineTest {

}
