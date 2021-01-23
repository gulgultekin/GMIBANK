package com.gmibank.stepDefinitions;

import com.gmibank.pages.CommonWebElements;
import com.gmibank.pages.LoginPage;
import com.gmibank.pages.ManageAccountsPage;
import com.gmibank.utilities.Driver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Us13AddingAccountSteps {

    CommonWebElements cmn=new CommonWebElements();
    LoginPage login=new LoginPage();
    ManageAccountsPage mangeAc=new ManageAccountsPage();


    @When("And user provides username  {string} and password {string}")
    public void and_user_provides_username_and_password(String username, String password) {

        Driver.waitAndSendText(login.username,username,5);

        Driver.waitAndSendText(login.password,password,5);

        Driver.waitAndClick(login.loginButton,5);
    }



    @Then("navigate to Create an Account page")
    public void navigate_to_Create_an_Account_page() {
        cmn.navigateCreateAccount();
    }

    @Then("description can not be blank  Employee see that message{string}")
    public void description_can_not_be_blank_Employee_see_that_message(String message) {
        mangeAc.validateError(message);

    }

    @Then("employee should create a description")
    public void employee_should_create_a_description() {
      mangeAc.description.sendKeys("Added description to employee new account");
    }

    @Then("employee provide a balance as a Dollar")
    public void employee_provide_a_balance_as_a_Dollar() {
        mangeAc.balance.sendKeys("1");
    }

    @When("Employee click account type can see option  CHECKING,SAVING,CREDIT_CARD or INVESTING")
    public void employee_click_account_type_can_see_option_CHECKING_SAVING_CREDIT_CARD_or_INVESTING() {
        mangeAc.ValidateTypeOfAccount();
    }

    @Then("Account status should be defined as ACTIVE, SUSPENDED or CLOSED")
    public void account_status_should_be_defined_as_ACTIVE_SUSPENDED_or_CLOSED() {

    }

    @Then("User can select an employee from the drop-down")
    public void user_can_select_an_employee_from_the_drop_down() {

    }




}
