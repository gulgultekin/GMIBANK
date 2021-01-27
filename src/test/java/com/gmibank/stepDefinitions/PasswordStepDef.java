package com.gmibank.stepDefinitions;

import com.gmibank.pages.CommonWebElements;
import com.gmibank.pages.LoginPage;
import com.gmibank.pages.PasswordPage;
import com.gmibank.utilities.ConfigurationReader;
import com.gmibank.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;


public class PasswordStepDef {

    LoginPage loginPage = new LoginPage();
    CommonWebElements commonWebElements = new CommonWebElements();
    PasswordPage passwordPage = new PasswordPage();

    @Given("User is on the GMIBank page")
    public void user_is_on_the_GMIBank_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("bankURL"));

}

    @Then("user should click on user Icon")
    public void user_should_click_on_user_Icon() {
        Driver.waitAndClick(loginPage.loginDropdown,5);
        loginPage.signInButton.click();
    }

    @Then("user enter {string} and {string} and click sign in button")
    public void user_enter_and_and_click_sign_in_button(String username, String password) {
        Driver.waitAndSendText(loginPage.username,username,5);
        Driver.waitAndSendText(loginPage.password,password,5);
        Driver.waitAndClick(loginPage.loginButton,5);
    }

    @Then("user navigates to userIcon and click to select Password dropdown")
    public void user_navigates_to_userIcon_and_click_to_select_Password_dropdown() {
        Driver.waitAndClick(commonWebElements.currentUserDropdown,2);
        passwordPage.passwordDropDown.click();
    }

    @Then("user is on the password page")
    public void user_is_on_the_password_page() {

        String actualTitle = "GMIBANK";
        String expectedTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Then("user click on current password inputBox and enter current {string}")
    public void user_click_on_current_password_inputBox_and_enter_current(String password) {
        Driver.waitAndSendText(passwordPage.currentPasswordInBox, password,2);
    }

    @Then("user click on newPassword inputBox and enter {string}")
    public void user_click_on_newPassword_inputBox_and_enter(String password) {
        Driver.waitAndSendText(passwordPage.newPasswordInBox, password,2);
    }

    @Then("user click on new password confirmation inputBox and enter {string} again")
    public void user_click_on_new_password_confirmation_inputBox_and_enter_again(String password) {
        Driver.waitAndSendText(passwordPage.confirmationPasswordInBox, password,2);
    }

    @Then("user clicks on Save button and see password change message")
    public void user_clicks_on_Save_button_and_see_password_change_message() {
        Driver.waitAndClick(passwordPage.saveButton,3);
        Driver.waitForVisibility(passwordPage.successMessage,3);
        Assert.assertTrue(passwordPage.successMessage.isDisplayed());

    }

    @Then("User deletes new password field")
    public void user_deletes_new_password_field() {

        Driver.editTextBox(passwordPage.newPasswordInBox,"");
        Driver.editTextBox(passwordPage.confirmationPasswordInBox,"");
        Driver.wait(3);

    }

    @Then("User see password strength color turn red and Your Password required message")
    public void user_see_password_strength_color_turn_red_and_Your_Password_required_message() {
        Driver.waitForVisibility(passwordPage.passwordRequiredMessage,3);
        Assert.assertTrue(passwordPage.passwordRequiredMessage.isDisplayed());
        Assert.assertTrue(passwordPage.redBar.isDisplayed());
        Driver.wait(3);

    }

    @When("User  enter six lowercase char and one uppercase char")
    public void user_enter_six_lowercase_char_and_one_uppercase_char() {
        Driver.waitAndSendText(passwordPage.newPasswordInBox,"welcomE",3);
        Driver.wait(3);

    }

    @Then("User see password strength color turn orange")
    public void user_see_password_strength_color_turn_orange() {
        Assert.assertTrue(passwordPage.orangeBar.isDisplayed());
        Driver.wait(3);
    }

    @When("User  enter six lowercase char and one uppercase char and one digit")
    public void user_enter_six_lowercase_char_and_one_uppercase_char_and_one_digit() {
        Driver.waitAndSendText(passwordPage.newPasswordInBox,"1",3);
        Driver.wait(3);

    }

    @Then("User see password strength color turn four level green")
    public void user_see_password_strength_color_turn_four_level_green() {
        Assert.assertTrue(passwordPage.greenBar.isDisplayed());

    }

    @When("User  enter six lowercase char and one uppercase char and {int} digit and {int} special char")
    public void user_enter_six_lowercase_char_and_one_uppercase_char_and_digit_and_special_char(Integer int1, Integer int2) {
      Driver.waitAndSendText(passwordPage.newPasswordInBox,"*",3);
      Driver.wait(3);

    }

    @Then("User see password strength color turn five level green")
    public void user_see_password_strength_color_turn_five_level_green() {
        Assert.assertTrue(passwordPage.fullGreenBar.isDisplayed());
        Driver.waitAndSendText(passwordPage.confirmationPasswordInBox,"welcomE1*",3);
        Driver.waitAndClick(passwordPage.saveButton,2);

    }

    @Given("User click on save button")
    public void user_click_on_save_button() {
       Driver.waitAndClick(passwordPage.saveButton,2);
       Driver.waitForVisibility(passwordPage.successMessage,3);
    }

    @Then("user should see success message")
    public void user_should_see_success_message() {
        Assert.assertTrue(passwordPage.successMessage.isDisplayed());

    }




}
