package com.gmibank.pages;

import com.gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {

    public PasswordPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"account-menu\"]/div/a[2]/span")
    public WebElement passwordDropDown;

    @FindBy(id = "currentPassword")
    public WebElement currentPasswordInBox;

    @FindBy(id = "newPassword")
    public WebElement newPasswordInBox;

    @FindBy(id= "confirmPassword")
    public WebElement confirmationPasswordInBox;

    @FindBy(id = "strengthBar")
    public WebElement strengthBar;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast--success toastify-toast']")
    public WebElement PasswordChangeMessage;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement successMessage;

    @FindBy(className = "invalid-feedback")
    public WebElement passwordRequiredMessage;


    @FindBy(xpath = "(//li[@class='point'])[1]")
    public WebElement redBar;

    @FindBy(xpath = "(//li[@class='point'])[2]")
    public WebElement orangeBar;

    @FindBy(xpath = "(//li[@class='point'])[4]")
    public WebElement greenBar;

    @FindBy(xpath = "(//li[@class='point'])[5]")
    public WebElement fullGreenBar;



}
