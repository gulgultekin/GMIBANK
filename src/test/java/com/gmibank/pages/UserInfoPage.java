package com.gmibank.pages;

import com.gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInfoPage {
    public UserInfoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="(//a[@class='dropdown-item'])[9]")
    public WebElement userInfo;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameField;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameField;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailField;

    @FindBy(xpath = "//select[@name='langKey']")
    public WebElement languageField;



}
