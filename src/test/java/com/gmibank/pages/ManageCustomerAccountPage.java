package com.gmibank.pages;

import com.gmibank.utilities.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCustomerAccountPage {
    public ManageCustomerAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement ClickToArrowIcon;

    @FindBy(xpath = "//span[.='Sign in']")
    public WebElement ClickToSigIn;

    @FindBy(id = "username")
    public WebElement UsernameBox;

    @FindBy(id = "password")
    public WebElement PasswordTextBox;

    @FindBy(xpath = "//span[.='My Operations']")
    public WebElement ClickToMyOperationsIcon;

    @FindBy(xpath = "//a[.='My Accounts']")
    public WebElement ClickToMyAccounts;

    @FindBy(xpath = "//td[.='View Transaction']")
    public WebElement ClickOnViewTransactionButton;


}
