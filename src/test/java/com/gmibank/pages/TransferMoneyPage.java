package com.gmibank.pages;

import com.gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferMoneyPage {

    public TransferMoneyPage(){ PageFactory.initElements(Driver.getDriver(), this); }

    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement ClickToArrowIcon;

    @FindBy(xpath = "//span[.='Sign in']")
    public WebElement ClickToSigIn;

    @FindBy(id = "username")
    public WebElement UsernameBox;

    @FindBy(id = "password")
    public WebElement PasswordTextBox;

    @FindBy(xpath = "//span[.='My Operations']")
    public WebElement ClickToMyOperationsIcon;

    @FindBy(xpath = "//a[.='Transfer Money']")
    public WebElement ClickOnTransferMoney;

    @FindBy(id = "fromAccountId")
    public WebElement FromTextBox;

    @FindBy(id = "toAccountId")
    public WebElement ToTextBox;

    @FindBy(id = "balance")
    public WebElement BalanceTextBox;

    @FindBy(id = "balancecent")
    public WebElement BalanceCentTextBox;

    @FindBy(id = "description")
    public WebElement DescriptionTextBox;

    @FindBy(id = "make-transfer")
    public WebElement ClickOnMakeTransferButton;


}
