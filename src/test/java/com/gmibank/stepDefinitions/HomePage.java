package com.gmibank.stepDefinitions;

import com.gmibank.utilities.Driver;
import cucumber.api.java.en.Given;

public class HomePage {

    @Given("user go to {string}")
    public void user_go_to(String string) {
        Driver.getDriver().get(string);
    }

}
