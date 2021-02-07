package com.gmibank.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "html:target/default-cucumber-reports",
                "html:target/cucumber-report.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"

        },

        features = "src/test/resources/features",
        glue = "com/gmibank/stepDefinitions",
        tags = "@CountryReader",
        monochrome = true,

        dryRun = false


      )

public class Runner {

}

