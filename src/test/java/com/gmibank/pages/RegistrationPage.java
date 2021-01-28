package com.gmibank.pages;

import com.gmibank.utilities.ConfigurationReader;
import com.gmibank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class RegistrationPage extends CommonWebElements{

    //public RegistrationPage()
    //{
      //  PageFactory.initElements(Driver.getDriver(),this);
    //}

    @FindBy(id="ssn")
    public WebElement ssnTextbox;

    @FindBy(id = "firstname")
    public WebElement firstnameTextbox;

    @FindBy(id = "lastname")
    public WebElement lastnameTextbox;

    @FindBy(id = "address")
    public WebElement addressTextbox;

    @FindBy(id = "mobilephone")
    public WebElement mobilephoneTextbox;

    @FindBy(id = "username")
    public WebElement usernameTextbox;

    @FindBy(id = "email")
    public WebElement emailTextbox;

    @FindBy(id = "firstPassword")
    public WebElement firstPasswordTextbox;

    @FindBy(id = "secondPassword")
    public WebElement newPasswordTextbox;

    @FindBy(id = "register-submit")
    public WebElement registerButton;

    @FindBy(xpath = "//*[@id='root']/div/div/div[1]/div")
    public WebElement toastContainer;



    @FindBy(xpath = "//div[.='Your SSN is invalid']")
    public WebElement ssnInvalidErrorMessage;

    @FindBy(xpath = "//div[.='Your mobile phone number is invalid']")
    public WebElement mobilePhoneInvalidErrorMessage;

    @FindBy(xpath = "//div[.='This field is invalid']")
    public WebElement emailInvalidErrorMessage;


    @FindBy(xpath="(//div[@class='invalid-feedback'])[1]")
    public WebElement ssnEmptyErrorMessage;

    @FindBy(xpath="(//div[@class='invalid-feedback'])[2]")
    public WebElement firstNameEmptyErrorMessage;

    @FindBy(xpath="(//div[@class='invalid-feedback'])[3]")
    public WebElement lastNameEmptyErrorMessage;

    @FindBy(xpath="(//div[@class='invalid-feedback'])[4]")
    public WebElement userNameEmptyErrorMessage;

    @FindBy(xpath="(//div[@class='invalid-feedback'])[5]")
    public WebElement emailEmptyErrorMessage;

    @FindBy(xpath="(//div[@class='invalid-feedback'])[6]")
    public WebElement passwordEmptyErrorMessage;

    @FindBy(xpath="(//div[@class='invalid-feedback'])[7]")
    public WebElement confirmationPasswordEmptyErrorMessage;




    public String createUserName(String firstName,String lastName,String userName)
    {
        for(int i=0; i< firstName.length(); i++)
        {
            userName+=String.valueOf(firstName.charAt(i));
            if(i==3)
                break;
        }
        for(int i=0; i< lastName.length(); i++)
        {
            userName+=String.valueOf(lastName.charAt(i));
            if(i==3)
                break;
        }
        return userName;
    }


    public String randomNumber(int bound)
    {
        String mobilePhone ="";
        Random random=new Random();
        for(int i=0; i<bound;i++)
        {
            mobilePhone +=String.valueOf(random.nextInt(bound));
        }
        return mobilePhone;
    }

    public String generateValidPassword(int upper,int lower,int sym,int digit,int lenght)
    {
        String symbols="!'^#+$%&/{([)]=}-_?*|";
        String digits="0123456789";
        String letters="abcdefghijklmnoprstuvwyz";
        String password="";


        Random random=new Random();
        for(int i=0 ; i<lenght ; i++)
        {
            for(int j=0 ; j<upper ; j++,i++) {
                password += String.valueOf(letters.charAt(random.nextInt(letters.length()))).toUpperCase();
            }
            for(int j=0 ; j<lower ; j++,i++) {
                password += String.valueOf(letters.charAt(random.nextInt(letters.length())));
            }
            for(int j=0 ; j<sym ; j++,i++) {
                password += String.valueOf(symbols.charAt(random.nextInt(symbols.length())));
            }
            for(int j=0 ; j<digit ; j++,i++) {
                password += String.valueOf(digits.charAt(random.nextInt(digits.length())));
            }
        }


        return password;
    }


}
