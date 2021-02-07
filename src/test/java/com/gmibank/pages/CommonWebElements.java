package com.gmibank.pages;




import com.gmibank.utilities.BrowserUtils;

import com.gmibank.utilities.Driver;
import com.gmibank.utilities.PageInitializer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class CommonWebElements {

    public CommonWebElements()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='account-menu']/a")
    public WebElement profileIcon;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[2]/span")
    public WebElement registerButton;

    @FindBy(xpath = "//*[text()='My Operations']")
    public WebElement myOperations;

    @FindBy(xpath = "//*[text()='Manage Customers']")
    public WebElement manageCustomer;

    @FindBy(xpath = "//*[text()='Create a new Customer']")
    public WebElement createANewCustomer;

    @FindBy(xpath = "//*[text()='Create Date']/following::input")
    public WebElement dateTextbox;

    @FindBy(xpath = "(//*[@class='d-flex align-items-center dropdown-toggle nav-link'])[2]")
    public WebElement currentUserDropdown;

    @FindBy(xpath = "//*[text()='Manage Accounts']")
    public WebElement manageAccount;

    @FindBy(xpath = "//*[text()='Create a new Account']")
    public WebElement createANewAccount;

    @FindBy(xpath = "//*[text()='Sign out']")
    public WebElement signOutButton;

    @FindBy(xpath = "//*[text()='Administration']")
    public WebElement administrationDropdown;

    @FindBy(xpath = "//*[text()='User management']")
    public WebElement userManagementButton;

    @FindBys({@FindBy(xpath = "//table/tbody/tr")})
    public List<WebElement > allUsers;

    @FindBy(id="login-item")
    public WebElement signInLink;

    @FindBy(name="username")
    public WebElement usernameBox;

    @FindBy(name="password")
    public WebElement passwordBox;

    @FindBy(xpath="//button/span[text()='Sign in']")
    public WebElement signInBtn;

    public void clickSignInLink(){
        BrowserUtils.waitForClickablility(profileIcon,3).click();
        BrowserUtils.waitForClickablility(signInLink,5).click();
    }
    public void enterUsername(String username){
        BrowserUtils.waitForVisibility(usernameBox,3).sendKeys(username);
    }

    public void enterPassword(String password){
        BrowserUtils.waitForVisibility(passwordBox,3).sendKeys(password);
    }

    public void clickSignInBtn(){
        BrowserUtils.waitForClickablility(signInBtn,3).click();
    }



    public void navigateCreateAccount(){
        myOperations.click();
        manageAccount.click();
        createANewAccount.click();

    }

}
