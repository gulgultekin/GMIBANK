package com.gmibank.pages;

import com.gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageAccountsPage {

    public void ManageAccountsPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

  @FindBy(id="tp-account-description")
    public WebElement description;

    @FindBy(id="tp-account-balance")
    public WebElement balance;


    @FindBy(id="tp-account-accountType")
    public WebElement AccountType;

    @FindBy(id="tp-account-accountStatusType")
    public WebElement AccountStatusType;


    @FindBy(id="tp-account-employee")
    public WebElement employee;

    @FindBy(id="save-entity")
    public WebElement saveBtn;

    @FindBy(xpath="//div[@class='invalid-feedback']")
    public WebElement errorMessage;

}
