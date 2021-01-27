
package com.gmibank.stepDefinitions;

import com.github.javafaker.Faker;
import com.gmibank.pages.CommonWebElements;
import com.gmibank.pages.RegistrationPage;
import com.gmibank.utilities.ConfigurationReader;
import com.gmibank.utilities.Driver;
import com.gmibank.utilities.PageInitializer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.text.DecimalFormat;
import java.util.Random;

public class RegistrationSteps extends PageInitializer {

    String firstName,lastName,userName="",password;

    @Given("user is on the home page")
    public void user_is_on_the_home_page()
    {
        Driver.ConfigurationReaderValue("bankURL");
    }

    @When("user go to registration page")
    public void user_go_to_registration_page()
    {
        Driver.waitAndClick(commonWebElements.profileIcon,3);
        Driver.waitAndClick(commonWebElements.registerButton,3);
    }
    @Then("user enters ssn number")
    public void user_enters_ssn_number() {
        Driver.waitAndSendText( registrationPage.ssnTextbox,registrationPage.randomNumber(9).replaceFirst("(\\d{3})(\\d{2})(\\d+)", "$1-$2-$3"),5);
    }

    @Then("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {

        firstName=faker.name().firstName();
        lastName=faker.name().firstName();
        Driver.waitAndSendText(registrationPage.firstnameTextbox,firstName,5);
        Driver.waitAndSendText(registrationPage.lastnameTextbox,lastName,7);

    }

    @Then("user provides address")
    public void user_provides_address() {
        Driver.waitAndSendText(registrationPage.addressTextbox,faker.address().streetAddress(),5);
    }

    @Then("user provides mobilephoneNumber")
    public void user_provides_mobilephoneNumber(){
        Driver.waitAndSendText( registrationPage.mobilephoneTextbox,registrationPage.randomNumber(10).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3"),5);
    }

    @Then("user provides a username")
    public void user_provides_a_username() {
        userName=registrationPage.createUserName(firstName,lastName,userName);
        Driver.waitAndSendText( registrationPage.usernameTextbox,userName,5);
    }

    @Then("user provides email")
    public void user_provides_email() {
        Driver.waitAndSendText(registrationPage.emailTextbox,userName+"@gmail.com",5);
    }

    @Then("user enters the password")
    public void user_enters_the_password() {
        password=registrationPage.generateValidPassword(1,3,2,2,8);
        Driver.waitAndSendText( registrationPage.firstPasswordTextbox,password,5);
    }


    @Then("user confirms the new password")
    public void user_confirms_the_new_password() {
        Driver.waitAndSendText(registrationPage.newPasswordTextbox,password,5);
    }

    @Then("user clicks on register button and sees the success message")

    public void user_clicks_on_register_button_and_sees_the_success_message_as() {
        Driver.waitAndClick(registrationPage.registerButton,5);

        String value =Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(Driver.returnConfigurationReaderValue("successMessageOfRegistration"),value);

        //System.out.println(registrationPage.toastContainer.getAttribute("class"));
        //System.out.println("here it is: "+registrationPage.toastContainer.getAttribute(""));
        }
    }
