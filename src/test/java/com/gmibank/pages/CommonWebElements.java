package com.gmibank.pages;

import com.gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonWebElements {

    public CommonWebElements()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[@id='account-menu']/a")
    public WebElement profileIcon;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[2]/span")
    public WebElement registerButton;




}
