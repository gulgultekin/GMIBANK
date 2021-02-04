package com.gmibank.stepDefinitions;

import com.gmibank.pages.AccountDateTimePage;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class AccountDateTimeStepDef {

    AccountDateTimePage accountDateTimePage = new AccountDateTimePage();

    @Then("user saves creation date")
    public void user_saves_creation_date() {
        accountDateTimePage.saveCreateDate();
    }

    @Then("user validates creation date")
    public void user_validates_creation_date() {
        Assert.assertTrue(accountDateTimePage.validateCreateDate());
    }

    @Then("user validates date format")
    public void user_validates_date_format() {
        Assert.assertTrue(accountDateTimePage.validateDateFormat());
    }

    @Then("user clicks id of an account")
    public void user_clicks_id_of_an_account() {
        accountDateTimePage.clickAccountId();
    }

    @Then("user validates account info is loaded")
    public void user_validates_account_info_is_loaded() {
        Assert.assertTrue(accountDateTimePage.validateAccountPageLoad());
    }

    @Then("user validates description is not empty")
    public void user_validates_description_is_not_empty() {
        Assert.assertTrue(accountDateTimePage.validateDescriptionNotEmpty());
    }

}
