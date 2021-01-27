package com.gmibank.stepDefinitions;

import com.gmibank.pages.CommonWebElements;
import com.gmibank.pages.CustomerAccountsPage;
import com.gmibank.pages.LoginPage;
import com.gmibank.pages.TransferMoneyPage;
import com.gmibank.utilities.ConfigurationReader;
import com.gmibank.utilities.Driver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerAccountStepDef {
    CommonWebElements commonWebElements=new CommonWebElements();
    LoginPage loginPage = new LoginPage();
    CustomerAccountsPage customerAccountsPage = new CustomerAccountsPage();
    TransferMoneyPage transferMoneyPage = new TransferMoneyPage();

    @Given("Customer is on the login page")
    public void customer_is_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("bankURL"));
//        loginPage.loginDropdown.click();


    }

    @When("Login to GMI Bank as customer")
    public void login_to_GMI_Bank_as_customer() {

        Driver.waitAndClick(loginPage.loginDropdown,5);
        loginPage.signInButton.click();
        Driver.waitAndSendText(customerAccountsPage.UsernameBox,ConfigurationReader.getProperty("customerUsername"),5);
        Driver.waitAndSendText(customerAccountsPage.PasswordTextBox,ConfigurationReader.getProperty("customerPassword"),5);
        Driver.waitAndClick(customerAccountsPage.SignInButton,5);

    }

    @Then("Click My Operations icon on the top right corner of the page")
    public void click_My_Operations_icon_on_the_top_right_corner_of_the_page() {
        Driver.waitAndClick(customerAccountsPage.ClickOnMyOperationsIcon,5);



    }

    @Then("Customer clicks on My Accounts button")
    public void customer_clicks_My_Accounts_button() {
        Driver.waitAndClick(customerAccountsPage.ClickOnMyAccounts, 5);
        Driver.waitAndClick(customerAccountsPage.ClickOnViewTransactionButton1,5);
        Driver.waitAndClick(customerAccountsPage.ClickOnViewTransactionButton2,5);
        Driver.waitAndClick(commonWebElements.profileIcon,5);
        Driver.waitAndClick(commonWebElements.signOutButton,5);
    }

    @Then("Customer clicks on Transfer Money and view transaction")
    public void customer_clicks_Transfer_Money_and_view_transaction() {

        Driver.waitAndClick(transferMoneyPage.ClickOnTransferMoney,5);
        Driver.waitAndSendText(transferMoneyPage.FromTextBox,ConfigurationReader.getProperty("fromSavingAccount"),5);
        Driver.waitAndSendText(transferMoneyPage.ToTextBox,ConfigurationReader.getProperty("toCheckingAccount"),5);
        Driver.waitAndSendText(transferMoneyPage.BalanceTextBox,ConfigurationReader.getProperty("customerBalance"),5);
        Driver.waitAndSendText(transferMoneyPage.DescriptionTextBox,ConfigurationReader.getProperty("customerDescription"),5);
        Driver.waitAndClick(transferMoneyPage.ClickOnMakeTransferButton,5);





    }
}
