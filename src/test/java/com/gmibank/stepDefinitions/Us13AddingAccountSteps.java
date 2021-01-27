package com.gmibank.stepDefinitions;

import com.gmibank.pages.CommonWebElements;
import com.gmibank.pages.LoginPage;
import com.gmibank.pages.ManageAccountsPage;
import com.gmibank.utilities.Driver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Us13AddingAccountSteps {

    CommonWebElements commonWebElements = new CommonWebElements();
    ManageAccountsPage manageAccountsPage = new ManageAccountsPage();


    @When("user clicks on manageAccounts")
    public void user_clicks_on_manage_accounts() {
        //go to manage account page
        Driver.waitAndClick(commonWebElements.manageAccount,2);
    }


    @When("user clicks on Create a new Account button")
    public void user_clicks_on_create_a_new_account_button() {
        //click to create or edit account
        Driver.waitAndClick(commonWebElements.createANewAccount,3);

    }

    @Then("user navigates to the Create or edit a Account page")
    public void user_navigates_to_the_create_or_edit_a_account_page() {
        //go to create or edit account page
        Driver.waitForVisibility(manageAccountsPage.createOrEditAccountHeader,3);
        Assert.assertTrue(manageAccountsPage.createOrEditAccountHeader.isDisplayed());
    }

    @Then("go to  Description inputbox it can not be blank")
    public void go_to_description_inputbox_it_can_not_be_blank() {

        //leave description box empty and assert it can not be blank
        manageAccountsPage.descriptionInputBox.sendKeys(Keys.TAB);
        Driver.waitForVisibility(manageAccountsPage.descriptionFieldErrorMessage,2);

        // assert it can not be blank, error message is displayed
        Assert.assertTrue(manageAccountsPage.descriptionFieldErrorMessage.isDisplayed());

    }
    @Then("and provide an {string}")
    public void and_provide_an(String Description) {
        //provide a description
        Driver.waitAndSendText(manageAccountsPage.descriptionInputBox,Description,3);

    }

    @Then ("go to  Balance inputbox it can not be blank")
    public void balance_inputbox_it_can_not_be_blank(){

        //leave balance box empty and assert it can not be blank
        manageAccountsPage.balanceInputBox.sendKeys(Keys.TAB);
        Driver.waitForVisibility(manageAccountsPage.balanceInputBox,2);

        // assert it can not be blank, error message is displayed
        Assert.assertTrue(manageAccountsPage.balanceInputBox.isDisplayed());
    }
    @Then("go to  Balance inputbox and provide {string} as dollar")
    public void go_to_balance_inputbox_and_provide_as_dollar(String Balance) {

        //provide a balance
        Driver.waitAndSendText(manageAccountsPage.balanceInputBox,Balance,3);

    }

    @Then("go to Account type dropdown and choose an {string}")
    public void go_to_account_type_dropdown_and_choose_an(String Account_type) {
        Driver.selectAnItemFromDropdown(manageAccountsPage.accountTypeDropDown,Account_type);
    }


    @Then("go to Account Status type dropdown and choose {string}")
    public void go_to_account_status_type_dropdown_and_choose(String account_Status_Type) {

        Driver.selectAnItemFromDropdown(manageAccountsPage.accountStatusTypeDropDown,account_Status_Type);
    }


    @Then("go to Employee inpuBox and choose an Employee")
    public void go_to_employee_inpu_box_and_choose_an_employee() {

        Driver.selectAnItemFromDropdown(manageAccountsPage.employeeDropDown,"");
    }

    @Then ("click save button")
    public void click_save_button(){
        Driver.waitAndClick(manageAccountsPage.saveButton,2);
    }


}
