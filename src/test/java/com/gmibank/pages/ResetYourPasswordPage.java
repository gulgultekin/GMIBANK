package com.gmibank.pages;


import com.gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetYourPasswordPage {

    public ResetYourPasswordPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement resetPasswordButton;

    @FindBy(className = "Toastify")
    public WebElement successMessage;
}
