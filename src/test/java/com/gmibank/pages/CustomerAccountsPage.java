package com.gmibank.pages;

import com.gmibank.utilities.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerAccountsPage {
    public CustomerAccountsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement ClickOnArrowIcon;

    @FindBy(xpath = "//span[.='Sign in']")
    public WebElement ClickOnSigIn;

    @FindBy(id = "username")
    public WebElement UsernameBox;

    @FindBy(id = "password")
    public WebElement PasswordTextBox;

    @FindBy(xpath = "//div/form/div[3]/button[2]")
    public WebElement SignInButton;

    @FindBy(xpath = "//span[.='My Operations']")
    public  WebElement ClickOnMyOperationsIcon;

    @FindBy(xpath = "//a[.='My Accounts']")
    public WebElement ClickOnMyAccounts;

    @FindBy(xpath = "//table/tbody/tr[1]/td[4]/button")
    public WebElement ClickOnViewTransactionButton1;

    @FindBy(xpath = "//table/tbody/tr[2]/td[4]/button")
    public WebElement ClickOnViewTransactionButton2;


}
