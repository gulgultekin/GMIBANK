package com.gmibank.pages;

import com.gmibank.utilities.BrowserUtils;
import com.gmibank.utilities.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class SignInPage extends CommonWebElements{

    @FindBy(xpath="//button/span[text()='Cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath="//a/span[text()='Sign out']")
    private WebElement signOutLink;

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
