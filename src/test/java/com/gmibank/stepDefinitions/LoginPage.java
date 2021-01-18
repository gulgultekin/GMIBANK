package com.gmibank.stepDefinitions;

import com.gmibank.pages.SignInPage;
import com.gmibank.utilities.BrowserUtils;
import com.gmibank.utilities.Driver;
import cucumber.api.java.en.*;
import org.testng.Assert;

public class LoginPage {

    SignInPage signInPage=new SignInPage();

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get("http://www.gmibank.com/");
        BrowserUtils.waitForPageToLoad(5);
    }

    @When("user clicks sign in button under user icon")
    public void user_clicks_sign_in_button_under_user_icon() {
        signInPage.clickSignInLink();
    }

    @Then("user enters valid username {string}")
    public void user_enters_valid_username(String username) {
        signInPage.enterUsername(username);
    }

    @Then("user enters valid password {string}")
    public void user_enters_valid_password(String password) {
        signInPage.enterPassword(password);
    }

    @Then("user clicks sign in button")
    public void user_clicks_sign_in_button() {
        signInPage.clickSignInBtn();
    }

    @Then("user validates successful login with message")
    public void user_validates_successful_login_with_message() {

        //there is no success message

    }

    @Then("user validates successful login with sign out")
    public void user_validates_successful_login_with_sign_out() {
        Assert.assertTrue(signInPage.validateSignOutLink());
    }

    @Then("user clicks cancel button")
    public void user_clicks_cancel_button() {
        signInPage.clickCancelBtn();
    }

    @Then("user validates return to homepage")
    public void user_validates_return_to_homepage() {
        Assert.assertTrue(signInPage.validateCancelBtnVisibility());
    }

}
