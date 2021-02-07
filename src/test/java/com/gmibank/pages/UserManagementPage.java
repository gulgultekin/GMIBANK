package com.gmibank.pages;

import com.gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserManagementPage {
    public UserManagementPage(){PageFactory.initElements(Driver.getDriver(),this);
}
    @FindBy(xpath = "//*[text()='Created date']")
    public WebElement createDateButton;

    @FindBy(xpath = "//table/tbody/tr/td[7]/span[1]")
    public WebElement dateAndTime;

    @FindBy(xpath = "//table/tbody/tr/td[1]/a")
    public WebElement idButton;

    @FindBy(xpath = "//div[@class='row']/dl/dd[2]")
    public WebElement firstNameInUserDetails;

    @FindBy(xpath = "(//a[@class='btn btn-info btn-sm'])[1]")
    public WebElement ViewButton;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement EditButton;

    @FindBy(xpath = "(//a[@class='btn btn-danger btn-sm'])[1]")
    public WebElement DeleteButton;

    @FindBy(xpath = "//ul[@class='pagination']/li")
    public List<WebElement> allPageNumbers;

    @FindBy(xpath = "//li[@class='page-item']")
    public WebElement lastPageIndex;



}
