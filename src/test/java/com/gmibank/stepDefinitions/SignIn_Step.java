package com.gmibank.stepDefinitions;

import com.gmibank.pages.LoginPage;
import com.gmibank.pages.RegistrationPage;
import com.gmibank.pages.ResetYourPasswordPage;
import com.gmibank.utilities.ConfigurationReader;
import com.gmibank.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class SignIn_Step {

    LoginPage loginPage = new LoginPage();
    ResetYourPasswordPage resetYourPasswordPage = new ResetYourPasswordPage();
    RegistrationPage registrationPage=new RegistrationPage();
    JavascriptExecutor executor = (JavascriptExecutor) (Driver.getDriver());


   //user provide invalid username , valid password
    @Given("user provides invalid username {string} and valid password {string}and click")
    public void user_provides_invalid_username_and_valid_password_and_click(String username, String password) {

        Driver.waitAndSendText(loginPage.username,username,3);
        Driver.waitAndSendText(loginPage.password,password,3);
        Driver.waitAndClick(loginPage.loginButton, 4);
        Driver.wait(2);
    }

    //error message is displayed
    @Then("user should see error message")
    public void user_should_see_error_message() {

        Driver.waitForVisibility(loginPage.failedToSignInMessage,5);
        Assert.assertTrue(loginPage.failedToSignInMessage.isDisplayed());
    }

    //user provide valid username , invalid password and error message is displayed
    @Given("user provides valid {string} and invalid {string}and click")
    public void user_provides_valid_and_invalid_and_click(String username, String password) {

        Driver.waitAndSendText(loginPage.username,username,3);
        Driver.waitAndSendText(loginPage.password,password,3);
        Driver.waitAndClick(loginPage.loginButton, 3);
        Driver.wait(1);
        Driver.waitForVisibility(loginPage.failedToSignInMessage,4);
        Assert.assertTrue(loginPage.failedToSignInMessage.isDisplayed());
    }

    //user provide invalid username , invalid password and error message is displayed
    @Given("user provides invalid {string} and invalid {string}and click")
    public void user_provides_invalid_and_invalid_and_click(String username, String password) {

        Driver.waitAndSendText(loginPage.username,username,3);
        Driver.waitAndSendText(loginPage.password,password,3);
        Driver.waitAndClick(loginPage.loginButton, 4);
        Driver.waitForVisibility(loginPage.failedToSignInMessage,4);
        Assert.assertTrue(loginPage.failedToSignInMessage.isDisplayed());
    }

    // click on Did you forget your password? link
    @Then("Did you forget your password? link should be visible and clickable")
    public void did_you_forget_your_password_link_should_be_visible_and_clickable() {

        Driver.waitForVisibility(loginPage.didYouForgetYourPasswordLink,2);
        Assert.assertTrue(loginPage.didYouForgetYourPasswordLink.isDisplayed());
    }

    //Navigate to the reset your password page
    @Then("when user click link should navigate to the reset your password page")
    public void when_user_click_link_should_navigate_to_the_reset_your_password_page() {

        executor.executeScript("arguments[0].click();", loginPage.didYouForgetYourPasswordLink);
        //Driver.waitForVisibility(resetYourPasswordPage.emailInputBox,2);
    }

    //
    @Then("user provide email  and click reset password button and see success message")
    public void user_provide_email_and_click_reset_password_button_and_see_success_message() {

        Driver.waitAndSendText(resetYourPasswordPage.emailInputBox,"email@gmail.com",2);
        Driver.waitAndClick(resetYourPasswordPage.resetPasswordButton, 3);
        Driver.wait(1);
        Driver.waitForVisibility(resetYourPasswordPage.successMessage, 2);
        Assert.assertTrue(resetYourPasswordPage.successMessage.isDisplayed());
    }

    @Then("Register a new account link should be visible and clickable")
    public void register_a_new_account_link_should_be_visible_and_clickable() {

        Driver.waitForVisibility(loginPage.registerANewAccountLink,2);
        Assert.assertTrue(loginPage.registerANewAccountLink.isEnabled());

    }

    @Then("when user click link should navigate to the Registration page")
    public void when_user_click_link_should_navigate_to_the_Registration_page() {

        executor.executeScript("arguments[0].click();", loginPage.registerANewAccountLink);

        Driver.waitForVisibility(this.registrationPage.ssnTextbox, 3);
        Assert.assertTrue(this.registrationPage.ssnTextbox.isDisplayed());

        //Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());

    }

}
