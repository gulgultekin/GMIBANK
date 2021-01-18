package com.gmibank.pages;

import com.gmibank.utilities.BrowserUtils;
import com.gmibank.utilities.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class SignInPage {

    public SignInPage(){
            PageFactory.initElements(Driver.getDriver(),this);
        }

   @FindBy(id="account-menu")
    private WebElement userIcon;

    @FindBy(id="login-item")
    private WebElement signInLink;

    @FindBy(name="username")
    private WebElement usernameBox;

    @FindBy(name="password")
    private WebElement passwordBox;

    @FindBy(xpath="//button/span[text()='Sign in']")
    private WebElement signInBtn;

    @FindBy(xpath="//button/span[text()='Cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath="//a/span[text()='Sign out']")
    private WebElement signOutLink;


    public void clickSignInLink(){
        BrowserUtils.waitForClickablility(userIcon,3).click();
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

    public boolean validateSignOutLink(){
        BrowserUtils.waitForClickablility(userIcon,3).click();
        return BrowserUtils.waitForVisibility(signOutLink,3).isDisplayed();
    }

    public void clickCancelBtn(){
        BrowserUtils.waitForClickablility(cancelBtn,3).click();
    }

    public boolean validateCancelBtnVisibility(){
        BrowserUtils.waitForClickablility(userIcon,3).click();
        return BrowserUtils.waitForClickablility(signInLink,5).isDisplayed();
    }







}
