package com.gmibank.stepDefinitions;

import com.gmibank.utilities.Driver;
import cucumber.api.java.en.Given;

public class LoginPage {

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get("http://www.gmibank.com/");
    }

}
