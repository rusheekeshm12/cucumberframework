package com.vtiger.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/Features/",
        glue = "com.vtiger.stepdefinitions",
        plugin = {
                "pretty",                              // Prints Gherkin steps in the console
                "html:target/cucumber-reports/cucumber.html",  // HTML report
                "json:target/cucumber-reports/cucumber.json",  // JSON report
                "junit:target/cucumber-reports/cucumber.xml"   // JUnit XML report
        },
        dryRun = false,
        monochrome = false,
        tags = "@contact"




)
public class TestRunner {
}
