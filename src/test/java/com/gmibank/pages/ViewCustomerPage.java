package com.gmibank.pages;

import com.gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCustomerPage {

    public ViewCustomerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div[1]/div/div/div/div/h2/span")
    public WebElement customerIDHeader;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div[1]/div/div/div/div/h2/b")
    public WebElement customerID;

    //*[@id="app-view-container"]/div[1]/div/div/div/div/h2/b

    @FindBy(xpath = "//span[.='First Name']")
    public WebElement firstName;

    @FindBy(xpath = "//a[@class='btn btn-info']")
    public WebElement backButton;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement editButton;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div[1]/div/div/div/div/dl/dd[5]")
    public WebElement mobilePhoneNumber;

    @FindBy(xpath = "//*[@id='app-view-container']/div[1]/div/div/div/div/dl/dd[4]")
    public WebElement email;

}
