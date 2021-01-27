package com.gmibank.stepDefinitions;

import com.gmibank.pages.CommonWebElements;
import com.gmibank.pages.LoginPage;
import com.gmibank.pages.UserInfoPage;
import com.gmibank.utilities.ConfigurationReader;
import com.gmibank.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class UserInfo {
    LoginPage loginPage = new LoginPage();
    UserInfoPage userInfo = new UserInfoPage();
    CommonWebElements common = new CommonWebElements();

    @Given("User goes to login page")
    public void user_goes_to_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("bankURL"));
        Driver.waitAndClick(loginPage.loginDropdown, 5);
        loginPage.signInButton.click();
    }

    @When("User provides username {string} and password {string}")
    public void user_provides_username_and_password(String username, String password) {
        Driver.waitAndSendText(loginPage.username, username, 5);
        Driver.waitAndSendText(loginPage.password, password, 5);
    }

    @When("User logs in")
    public void user_logs_in() {
        Driver.waitAndClick(loginPage.loginButton, 5);
    }

    @When("User navigates and clicks on user info")
    public void user_navigates_and_clicks_on_user_info() {
        Driver.waitAndClick(common.profileIcon, 5);
        Driver.waitAndClick(userInfo.userInfo, 5);
    }

    @When("User should see info being populated")
    public void user_should_see_info_being_populated() {
        String firstNameIsVisible = Driver.waitForVisibility(userInfo.firstNameField, 5).getAttribute("type");
        System.out.println("firstNameIsVisible = " + firstNameIsVisible);

        String lastNameIsVisible = Driver.waitForVisibility(userInfo.lastNameField, 5).getAttribute("type");
        System.out.println("lastNameIsVisible = " + lastNameIsVisible);

        String emailIsVisible = Driver.waitForVisibility(userInfo.emailField, 5).getAttribute("type");
        System.out.println("emailIsVisible = " + emailIsVisible);

        Select select = new Select(userInfo.languageField);
        List<WebElement> listOfOptions = select.getOptions();

        Iterator<WebElement> i = listOfOptions.iterator();
        while (i.hasNext()) {
            System.out.println(i.next().getText());

//        while(i.hasNext()) {
//            WebElement row = i.next();
//            System.out.println(row.getText());
//        }
        }
    }

    @When("User goes to the language dropdown and clicks on it")
    public void user_goes_to_the_language_dropdown_and_clicks_on_it() {
        Driver.waitAndClick(userInfo.languageField, 5);
    }

    @When("User chooses English")
    public void user_chooses_English() {
        Select select = new Select(userInfo.languageField);
        select.selectByIndex(0);
    }

    @When("User chooses Turkish")
    public void user_chooses_Turkish() {
        Select select = new Select(userInfo.languageField);
        select.selectByIndex(1);
    }

    @When("User navigates and deletes the first name")
    public void user_navigates_and_deletes_the_first_name() {

        userInfo.firstNameField.clear();
    }

    @When("User writes the new name {string} to update")
    public void user_writes_the_new_name_to_update(String name) {
        Driver.waitAndSendText(userInfo.firstNameField, name, 5);
    }

    @When("User navigates and deletes the last name")
    public void user_navigates_and_deletes_the_last_name() {

        userInfo.lastNameField.clear();
    }

    @When("User writes the new last name {string} to update")
    public void user_writes_the_new_last_name_to_update(String lastName) {
        Driver.waitAndSendText(userInfo.lastNameField, lastName, 5);
    }

    @When("User navigates and deletes the email")
    public void user_navigates_and_deletes_the_email() {

        userInfo.emailField.clear();
    }

    @When("User writes the new Email {string} adding @ sign and . extension to update")
    public void user_writes_the_new_Email_adding_sign_and_extension_to_update(String email) {
        Driver.waitAndSendText(userInfo.emailField, email, 5);
    }


}
