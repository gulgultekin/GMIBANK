package com.gmibank.pages;

import com.gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

    public EditCustomerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name ="id")
    public WebElement ID;

    @FindBy(name ="firstName" )
    public WebElement firstNameInputBox;

    @FindBy(name ="lastName")
    public WebElement lastNameInputBox;

    @FindBy(name ="middleInitial")
    public WebElement middleInitialInputBox;

    @FindBy(name ="email")
    public WebElement emailInputBox;

    @FindBy(name ="mobilePhoneNumber")
    public WebElement mobilePhoneNumInputBox;

    @FindBy(name ="phoneNumber")
    public WebElement phoneNumInputBox;

    @FindBy(name ="zipCode")
    public WebElement zipCodeInputBox;

    @FindBy(name ="address")
    public WebElement addressInputBox;

    @FindBy(name ="city")
    public WebElement cityInputBox;


    @FindBy(name ="ssn")
    public WebElement ssnInputBox;

    @FindBy(name ="createDate")
    public WebElement createDateInputBox;


    @FindBy(name ="country.id")
    public WebElement countryDropDown;


    @FindBy(name ="state")
    public WebElement stateInputBox;


    @FindBy(name ="user.id")
    public WebElement userDropDown;


    @FindBy(name ="")
    public WebElement accountInputBox;



    @FindBy(name = "zelleEnrolled")
    public WebElement zelleEnrolledCheckBox;



    @FindBy(id = "cancel-save")
    public WebElement backButton;



    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement editSuccessMessage;

}
