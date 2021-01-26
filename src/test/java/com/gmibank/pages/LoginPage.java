package com.gmibank.pages;

import com.gmibank.utilities.BrowserUtils;
import com.gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonWebElements{

    @FindBy(id = "account-menu")
    public WebElement loginDropdown;

    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement signInButton;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy( id = "password")
    public WebElement password;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement loginButton;

    @FindBy(xpath="//a/span[text()='Sign out']")
    public WebElement signOutLink;

    @FindBy(xpath="//button/span[text()='Cancel']")
    public WebElement cancelBtn;

    @FindBy(xpath = "//div[@role='alert']")
    public  WebElement failedToSignInMessage;

    @FindBy(linkText = "Did you forget your password?")
    public WebElement didYouForgetYourPasswordLink;

    // @FindBy(xpath = "(//a[@href='/account/register'])[2]")

    @FindBy(xpath = "//*[@id=\"login-page\"]/div/form/div[2]/div[4]/a")
    public WebElement registerANewAccountLink;

    public boolean validateSignOutLink(){
        BrowserUtils.waitForClickablility(profileIcon,3).click();
        return BrowserUtils.waitForVisibility(signOutLink,3).isDisplayed();
    }

    public void clickCancelBtn(){
        BrowserUtils.waitForClickablility(cancelBtn,3).click();
    }

    public boolean validateCancelBtnVisibility(){
        BrowserUtils.waitForClickablility(profileIcon,3).click();
        return BrowserUtils.waitForClickablility(signInLink,5).isDisplayed();
    }




}
