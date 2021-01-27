package com.gmibank.stepDefinitions;

import com.github.javafaker.Faker;
import com.gmibank.pages.*;
import com.gmibank.pojos.Customer;
import com.gmibank.utilities.ConfigurationReader;
import com.gmibank.utilities.DateUtil;
import com.gmibank.utilities.Driver;
import com.gmibank.utilities.PageInitializer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Locale;

import static com.gmibank.utilities.Driver.getDriver;

public class DateAndTimeStep extends PageInitializer {


    String login = faker.name().firstName();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();

    String email = firstName + lastName + "@gmail.com";
    String dateTime = "";
    String actualDate = "";

    @When("user navigates to {string} page")
    public void user_navigates_to_page(String Users) {
        Driver.waitAndClick(employeePage.administrationDropdown, 2);
        Driver.waitAndClick(employeePage.userManagementButton, 2);
    }

    @When("user clicks the {string} button")
    public void user_clicks_the_button(String CreateNewUser) {
        Driver.waitAndClick(user.createNewUser, 3);
    }

    @When("user fills out required fields to create user")
    public void user_fills_out_required_fields_to_create_user() {
        Driver.waitAndSendText(user.login, login, 3);
        Driver.waitAndSendText(user.firstName, firstName, 3);
        Driver.waitAndSendText(user.lastName, lastName, 3);
        Driver.waitAndSendText(user.email, email, 3);
        Driver.selectAnItemFromDropdown(user.languages, "English");
        Driver.selectAnItemFromDropdown(user.profiles, "ROLE_MANAGER");
    }

    @When("user saves the current date and time")
    public void user_saves_the_current_date_and_time() {
        dateTime = DateUtil.todaysDate5();
        System.out.println(dateTime);
    }

    @When("user clicks on the {string} button")
    public void user_clicks_on_the_button(String saveButton) {
        Driver.waitAndClick(user.saveButton, 3);
        Driver.wait(10);
    }

    @Then("user verifies that the creation date and time are same as saved current date and time")
    public void user_verifies_that_the_creation_date_and_time_are_same_as_saved_current_date_and_time() {
        Driver.waitAndClick(userManagementPage.createDateButton, 5);
        Driver.wait(4);
        actualDate = Driver.waitAndGetText(userManagementPage.dateAndTime, 2);

        System.out.println("this is actual date ************************************" + actualDate);
        Assert.assertEquals(dateTime, actualDate);
    }

    @Then("verify that date is created as month, day, year, hour and minute")
    public void verify_that_date_is_created_as_month_day_year_hour_and_minute() {
        Assert.assertFalse(CreateEditUser.isValidFormat("MM/dd/yyyy hh:mm", actualDate, Locale.US));
    }


    @When("user chooses one user by clicking on his id and lands on User page")
    public void user_chooses_one_user_by_clicking_on_his_her_id_and_lands_on_User_page() {
        Driver.waitAndClick(userManagementPage.idButton, 3);
    }

    @Then("user verifies that first name field is not empty")
    public void user_verifies_that_all_required_fields_are_not_empty() {
        String firstName = userManagementPage.firstNameInUserDetails.getText();
        Driver.waitAndClick(userManagementPage.firstNameInUserDetails, 3);
        Assert.assertNotNull("User's first name is not null", firstName);
    }

    @When("User selects Manage Customers option from My Operations dropdown menu and lands on customers page")
    public void user_selects_Manage_Customers_option_from_My_Operations_dropdown_menu_and_lands_on_customers_page() {
        Driver.waitAndClick(employeePage.myOperations, 3);
        Driver.waitAndClick(employeePage.manageCustomer, 2);

    }

    @When("User selects Zelle Enrolled option and saves it")
    public void user_selects_Zelle_Enrolled_option_and_saves_it() {
        Boolean checkBoxSelected = editCustomer.zelleEnrolledCheckBox.isSelected();
        Driver.waitAndClick(editCustomer.zelleEnrolledCheckBox, 2);
        Driver.waitAndClick(editCustomer.saveButton, 2);

    }
}