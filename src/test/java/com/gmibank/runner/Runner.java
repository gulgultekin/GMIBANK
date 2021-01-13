package com.gmibank.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import java.net.HttpURLConnection;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/default-cucumber-reports",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"
        },
       features = "src/test/resources/features",
        glue = "gmibank/step_defs",
        tags = "@HomePage",
        dryRun = false


)
public class Runner {


}
