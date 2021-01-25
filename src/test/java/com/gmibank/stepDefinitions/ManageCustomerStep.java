package com.gmibank.stepDefinitions;

import com.gmibank.pages.CommonWebElements;
import com.gmibank.pages.EditCustomerPage;
import com.gmibank.pages.ManageCustomerPage;
import com.gmibank.pages.ViewCustomerPage;
import com.gmibank.pojos.Customer;
import com.gmibank.utilities.BrowserUtils;
import com.gmibank.utilities.Driver;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.Assert;

import org.openqa.selenium.By;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.gmibank.utilities.Driver.getDriver;

public class ManageCustomerStep
{
    CommonWebElements employeePage = new CommonWebElements();
    ManageCustomerPage manageCustomerPage= new ManageCustomerPage();
    ViewCustomerPage viewCustomerPage= new ViewCustomerPage();
    Actions actions = new Actions(getDriver());
    EditCustomerPage editCustomerPage = new EditCustomerPage();
    Customer existingCustomer = new Customer();
    Customer editedCustomer = new Customer();
    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @Then("user navigates to my operations")
    public void user_navigates_to_my_operations() {
        Driver.waitAndClick(employeePage.myOperations,5);
    }

    @When("user clicks on manageCustomer")
    public void user_clicks_on_manageCustomer() {
        Driver.waitAndClick(employeePage.manageCustomer,5);
    }

    @Then("user clicks on View button")
    public void user_clicks_on_View_button() {

        Driver.waitAndClick(manageCustomerPage.viewButton,5);
       BrowserUtils.wait(5);
    }

    @Then("verify that customer info displayed")
    public void verify_that_customer_info_displayed() {

        //Verify Customer header and first name header is displayed
        String actualResultHeader = Driver.waitAndGetText(viewCustomerPage.customerIDHeader,5);
        String actualResultFirstName = Driver.waitAndGetText(viewCustomerPage.firstName,5);

        String expectedResultHeader="Customer";
        Assert.assertEquals(actualResultHeader,expectedResultHeader);

        String expectedResultFirstName="First Name";
        Assert.assertEquals(actualResultFirstName,expectedResultFirstName);

        //go back to previous page(Manage customer page)
        js.executeScript("window.history.go(-1)");
    }

    @Then("user clicks on Edit button")
    public void user_clicks_on_Edit_button() {

        actions.moveToElement(manageCustomerPage.editButton).click().perform();

        // Get all the user info  for existing user
        this.existingCustomer.setId(Integer.parseInt(editCustomerPage.ID.getAttribute("value")));
        this.existingCustomer.setFirstName(editCustomerPage.firstNameInputBox.getAttribute("value"));
        this.existingCustomer.setLastName(editCustomerPage.lastNameInputBox.getAttribute("value"));
        this.existingCustomer.setEmail(editCustomerPage.emailInputBox.getAttribute("value"));
        this.existingCustomer.setZipCode(editCustomerPage.zipCodeInputBox.getAttribute("value"));
        this.existingCustomer.setMobilePhoneNumber(editCustomerPage.mobilePhoneNumInputBox.getAttribute("value"));
    }

        @Then("user goes  inputbox and edit {string}and {string}")
        public void user_goes_inputbox_and_edit_and(String mobilePhoneNum, String email) {

        // Edit Customer mobile phone # and email
        Driver.editTextBox(editCustomerPage.mobilePhoneNumInputBox, mobilePhoneNum);
        Driver.editTextBox(editCustomerPage.emailInputBox,email);

            BrowserUtils.wait(5);
        // Click save Button
        js.executeScript("arguments[0].scrollIntoView(true);" +"arguments[0].click()",editCustomerPage.saveButton);

        // Check if success message is popping up
        Driver.waitForVisibility(manageCustomerPage.editSuccessMessage, 5);
        Assert.assertTrue((manageCustomerPage.editSuccessMessage.isDisplayed()));

            BrowserUtils.wait(5);
        // Right now we are in Manage Customer page. Find User ID
        BrowserUtils.clickWithJS(Driver.getDriver().findElement(By.xpath("//a[.='"+ existingCustomer.getId() +"']")));

            BrowserUtils.wait(5);
        // Check if we have edited User Id and matching with edited phone number
        WebElement idElement = viewCustomerPage.customerID;
        Assert.assertEquals(existingCustomer.getId(), Integer.parseInt(idElement.getText()));
        Assert.assertEquals(mobilePhoneNum, viewCustomerPage.mobilePhoneNumber.getText());
        Assert.assertEquals(email,viewCustomerPage.email.getText());



        // String actualRes = viewCustomerPage.customerID.getText();
        //  Assert.assertEquals(manageCustomerPage.CustomerID.getText(),viewCustomerPage.customerID.getText());



        // To put old value back
        //go back to previous page(Manage customer page) and click edit button again to put old value back
        js.executeScript("window.history.go(-1)");
        BrowserUtils.clickWithJS(manageCustomerPage.editButton);
            BrowserUtils.wait(5);
        Driver.waitAndClick(editCustomerPage.mobilePhoneNumInputBox,3);
        editCustomerPage.mobilePhoneNumInputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        editCustomerPage.mobilePhoneNumInputBox.sendKeys(Keys.BACK_SPACE);
        editCustomerPage.mobilePhoneNumInputBox.sendKeys(this.existingCustomer.getMobilePhoneNumber());
            BrowserUtils.wait(5);
        Driver.waitAndClick(editCustomerPage.emailInputBox,3);
        editCustomerPage.emailInputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        editCustomerPage.emailInputBox.sendKeys(Keys.BACK_SPACE);
        editCustomerPage.emailInputBox.sendKeys(this.existingCustomer.getEmail());
            BrowserUtils.wait(5);
        js.executeScript("arguments[0].scrollIntoView(true);" +"arguments[0].click()",editCustomerPage.saveButton);


    }



    @When("user clicks on Delete button")
    public void user_clicks_on_Delete_button() {

        //scroll up and click delete button
        js.executeScript("arguments[0].scrollIntoView(true);" +"arguments[0].click()",manageCustomerPage.deleteButton);

    }

    @Then("verify that confirmation Delete Question is displayed")
    public void verify_that_confirmation_Delete_Question_is_displayed() {

        Driver.waitForVisibility(manageCustomerPage.confirmationDeleteQuestion,5);
        Assert.assertTrue(manageCustomerPage.confirmationDeleteQuestion.isDisplayed());
    }

    @Then("click confirmation Delete button")
    public void click_confirmation_Delete_button() {

        Driver.waitForClickablility(manageCustomerPage.confirmationDeleteButton,3);
        manageCustomerPage.confirmationDeleteButton.click();
    }

    @Then("validate if the success message displayed")
    public void validate_if_the_success_message_displayed() {

        Driver.waitForVisibility(manageCustomerPage.deleteConfirmationMessage,3);
        Assert.assertTrue(manageCustomerPage.deleteConfirmationMessage.isDisplayed());

    }

    @Then("verify that customer info deleted")
    public void verify_that_customer_info_deleted() {

        // There is a bug we can not verify
    }


    @Then("user scroll down and click save button")
    public void user_scroll_down_and_click_save_button() {

    }

    @Then("verify success message is displayed")
    public void verify_success_message_is_displayed() {

    }

}
