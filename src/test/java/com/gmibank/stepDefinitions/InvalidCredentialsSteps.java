package com.gmibank.stepDefinitions;

import com.gmibank.pages.CommonWebElements;
import com.gmibank.pages.RegistrationPage;
import com.gmibank.utilities.ConfigurationReader;
import com.gmibank.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import static com.gmibank.utilities.Driver.getDriver;


public class InvalidCredentialsSteps {

    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    RegistrationPage registrationPage = new RegistrationPage();
    CommonWebElements commonWebElements=new CommonWebElements();

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        getDriver().get(ConfigurationReader.getProperty("bankURL"));
    }

    @When("user go to registrationpage")
    public void user_go_to_registrationpage() {
        Driver.waitAndClick(commonWebElements.profileIcon,3);
        Driver.waitAndClick(commonWebElements.registerButton,3);
    }

    @Given("user clicks on register button")
    public void user_clicks_on_register_button() {

        js.executeScript("arguments[0].scrollIntoView(true);" + "arguments[0].click()", registrationPage.registerButton);
        // Driver.waitAndClick(commonWebElements.registerButton,3);}
    }

    @Given("user verifies that warning messages are displayed")
    public void user_verifies_that_warning_messages_are_displayed() {

        //SSNError
        Driver.waitForVisibility(registrationPage.ssnEmptyErrorMessage,3);
        Assert.assertTrue(registrationPage.ssnEmptyErrorMessage.isDisplayed());

        //FirstNameError
        Driver.waitForVisibility(registrationPage.firstNameEmptyErrorMessage,3);
        Assert.assertTrue(registrationPage.firstNameEmptyErrorMessage.isDisplayed());

        //LastNameError
        Driver.waitForVisibility(registrationPage.lastNameEmptyErrorMessage,3);
        Assert.assertTrue(registrationPage.lastNameEmptyErrorMessage.isDisplayed());

        //UserNameError
        Driver.waitForVisibility(registrationPage.userNameEmptyErrorMessage,3);
        Assert.assertTrue(registrationPage.userNameEmptyErrorMessage.isDisplayed());

        //EmailError
        Driver.waitForVisibility(registrationPage.emailEmptyErrorMessage,3);
        Assert.assertTrue(registrationPage.emailEmptyErrorMessage.isDisplayed());

        //PasswordError
        Driver.waitForVisibility(registrationPage.passwordEmptyErrorMessage,3);
        Assert.assertTrue(registrationPage.passwordEmptyErrorMessage.isDisplayed());

        //ConfirmationPasswordError
        Driver.waitForVisibility(registrationPage.confirmationPasswordEmptyErrorMessage,3);
        Assert.assertTrue(registrationPage.confirmationPasswordEmptyErrorMessage.isDisplayed());
    }

    @Then("user enters ssn number with invalid char {string}")
    public void user_enters_ssn_number_with_invalid_char(String editTextBox) {
        //  Driver.waitAndSendText(registrationPage.ssnTextbox,invalidSSn,3);
        Driver.sendTextAndEnter(registrationPage.ssnTextbox, editTextBox);

    }

    @Then("user sees Your SSN is invalid error message")
    public void user_sees_SSn_Errormessage() {

        Driver.waitForVisibility(registrationPage.ssnInvalidErrorMessage,5);
       // Assert.assertTrue (Driver.getDriver().getPageSource().contains("Your SSN is invalid"));
         Assert.assertTrue(registrationPage.ssnInvalidErrorMessage.isDisplayed());
    }

    @Then("user provides mobile phone with non numeric char {string}")
    public void user_provides_mobile_phone_with_non_numeric_char(String invalidPhoneNumber) {

        Driver.wait(1);
        Driver.sendTextAndEnter(registrationPage.mobilephoneTextbox, invalidPhoneNumber);
        // Driver.waitAndSendText(registrationPage.mobilephoneTextbox,invalidPhoneNumber,3);
        Driver.wait(1);
    }

    @Then("user sees Your mobile phone number is invalid error message")
    public void user_see_mobileNum_ErrorMessage() {
        Driver.waitForVisibility(registrationPage.mobilePhoneInvalidErrorMessage,3);
        Assert.assertTrue(registrationPage.mobilePhoneInvalidErrorMessage.isDisplayed());
    }

    @Then("user provides email id without @ sign {string}")
    public void user_provides_email_id_without_sign(String invalidEmail){

        Driver.sendTextAndEnter(registrationPage.emailTextbox, invalidEmail);
       // Driver.waitAndSendText(registrationPage.emailTextbox,invalidEmail,3);
    }

    @Then("user sees This field is invalid error message")
    public void user_sees_email_Errormessage() {
        Driver.waitForVisibility(registrationPage.emailInvalidErrorMessage,3);
        Assert.assertTrue(registrationPage.emailInvalidErrorMessage.isDisplayed());
    }

}
