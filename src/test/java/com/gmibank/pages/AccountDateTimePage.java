package com.gmibank.pages;

import com.gmibank.utilities.BrowserUtils;
import com.gmibank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AccountDateTimePage extends CommonWebElements {

    @FindBy(id = "tp-account-createDate")
    public WebElement createDate;

    @FindBy(xpath = "(//table[@class='table']//td)[1]")
    public WebElement firstId;

    @FindBy(xpath = "(//dd)[1]")
    public WebElement firstDescription;


    String actualDateTime = "";

    public void saveCreateDate() {
        actualDateTime = BrowserUtils.waitForVisibility(createDate, 2).getAttribute("value");
    }

    public boolean validateCreateDate() {
        BrowserUtils.waitForPageToLoad(5);
        boolean dateCorrect = false;
        List<WebElement> descriptionList = Driver.getDriver().findElements(By.xpath("//td[text()='account date test 1003']"));
        WebElement lastItem = descriptionList.get(descriptionList.size() - 1);

        String date = lastItem.findElement(By.xpath("./../td[6]")).getText();

        date = convertDate(date);
//        System.out.println(date+" date " +actualDateTime);
        if (date.equals(actualDateTime)) {
            dateCorrect = true;
        }
        return dateCorrect;
    }

    public String convertDate(String date) {
        //        2021-01-27T00:00       ======actual date
        //        27/01/21 00:00         ====create date list
        String ndate1 = "";
        try {
            String pattern = "dd/MM/yy HH:mm";
            SimpleDateFormat sdateformat = new SimpleDateFormat(pattern);
            Date date1 = sdateformat.parse(date);
            ndate1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(date1);
        } catch (Exception e) {
        }
        return ndate1;
    }

    public boolean validateDateFormat() {
        return !CreateEditUser.isValidFormat("MM/dd/yyyy hh:mm", actualDateTime, Locale.US);
    }

    String accountId = "";

    public void clickAccountId() {
        BrowserUtils.waitForPageToLoad(5);
        accountId = BrowserUtils.waitForVisibility(firstId, 3).getText();

        BrowserUtils.waitForClickablility(firstId, 3).click();
        BrowserUtils.waitForPageToLoad(3);
    }

    public boolean validateAccountPageLoad() {
        String URL = Driver.getDriver().getCurrentUrl();
        return URL.contains(accountId);
    }

    public boolean validateDescriptionNotEmpty() {
        return !BrowserUtils.waitForVisibility(firstDescription, 3).getText().isEmpty();
    }

//2. way
//    public boolean validateCreateDate2() {
//        BrowserUtils.waitForPageToLoad(5);
//        boolean dateCorrect = false;
//        List<WebElement> createDateList = Driver.getDriver().findElements(By.xpath("//table//tbody/tr/td[6]/span[1]"));
//        List<WebElement> descriptionList = Driver.getDriver().findElements(By.xpath("//table//tbody/tr/td[2]"));
//        for (int i = 0; i < descriptionList.size(); i++) {
//            if (descriptionList.get(i).getText().equals("account date test 1002")) {
//                String date = createDateList.get(i).getText();
//                date = convertDate(date);
//                if (date.equals(actualDateTime)) {
//                    dateCorrect = true;
//                }
//                break;
//            }
//        }
//        return dateCorrect;
//    }


}
