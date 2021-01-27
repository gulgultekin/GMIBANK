package com.gmibank.pages;

import com.gmibank.utilities.BrowserUtils;
import com.gmibank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManageAccountsPage {

    BrowserUtils BUtils = new BrowserUtils();
    String[] ar = {"CHECKING", "SAVING", "CREDIT_CARD", "INVESTING"};
    ArrayList<String> type = new ArrayList<String>();

    public void ManageAccountsPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "tp-account-description")
    public WebElement description;

    @FindBy(id = "tp-account-balance")
    public WebElement balance;


    @FindBy(id = "tp-account-accountType")
    public WebElement AccountType;

    @FindBy(id = "tp-account-accountStatusType")
    public WebElement AccountStatusType;


    @FindBy(id = "tp-account-employee")
    public WebElement employee;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement saveBtn;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[text()='Account']")
    public WebElement titleAccount;


    public void validateError(String message) {
//    BUtils.waitForPageToLoad(30);//bug
//
//      BUtils.scrollDown(50);
//      BUtils.waitForClickablility(saveBtn,30);
//      saveBtn.click();
//      BUtils.scrollUp(100);
//      Assert.assertEquals("mismatch message",errorMessage.getText(),message);
    }

    public void ValidateTypeOfAccount() {
        AccountType.click();
        Select select = new Select(AccountType);
        List<WebElement> Alloption = select.getOptions();
        String op;

        type.add("CHECKING");
        type.add("SAVING");
        type.add("CREDIT_CARD");
        type.add("INVESTING");

        Iterator<WebElement> it = Alloption.iterator();

        while (it.hasNext()) {
            String text = it.next().getText();
            Assert.assertEquals("mismatch Type of Account", text, type);
            System.out.println("Actual " + text + " Expected " + type);
        }


    }

}
