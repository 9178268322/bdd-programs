package com.ip.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features/data_table.feature"},
        glue = {"classpath:com/ip/stepdefinition"},
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json", "junit:target/cucumber.xml", "summary"},
        monochrome = true)
public class DataTableTest {

}
