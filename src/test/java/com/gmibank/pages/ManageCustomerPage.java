package com.gmibank.pages;

import com.gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCustomerPage
{
    public ManageCustomerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@class='btn btn-info btn-sm'])[1]")
    public WebElement viewButton;

    @FindBy(xpath="(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement editButton;

    @FindBy(xpath = "(//a[@class='btn btn-danger btn-sm'])[1]")
    public WebElement deleteButton;


    @FindBy(xpath = "//a[@class='btn btn-success btn-sm']")
    public WebElement CustomerID;

    @FindBy(xpath = "(//table/tbody/tr/td[2]")
    public WebElement firstName;

    @FindBy(xpath = "(//table/tbody/tr/td[3]")
    public WebElement lastName;

    @FindBy(xpath = "//table/tbody/tr/td[4]")
    public WebElement middleInitial;

    @FindBy(xpath = "//table/tbody/tr/td[5]")
    public WebElement email;

    @FindBy(xpath = "//table/tbody/tr/td[6]")
    public WebElement mobilePhoneNumber;

    @FindBy(xpath = "//table/tbody/tr/td[7]")
    public WebElement phoneNumber;

    @FindBy(xpath = "//table/tbody/tr/td[8]")
    public WebElement address;

    @FindBy(xpath = "//table/tbody/tr/td[9]")
    public WebElement createDate;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement editSuccessMessage;

    @FindBy(id = "jhi-confirm-delete-tPCustomer")
    public WebElement confirmationDeleteButton;

    @FindBy(xpath = "//button[@class='btn btn-secondary']")
    public WebElement cancelButton;

    @FindBy(id ="gmibankfrontendApp.tPCustomer.delete.question")
    public WebElement confirmationDeleteQuestion;

    @FindBy(className = "Toastify__toast-body")
    public WebElement deleteConfirmationMessage;

}
