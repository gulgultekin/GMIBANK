package com.gmibank.stepDefinitions;

import com.gmibank.pages.CommonWebElements;
import com.gmibank.pages.LoginPage;
import com.gmibank.pages.UserInfoPage;
import com.gmibank.utilities.Driver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class UserInfoNegativeTest {

    LoginPage loginPage = new LoginPage();
    UserInfoPage userInfo = new UserInfoPage();
    CommonWebElements common = new CommonWebElements();


    @When("User writes the new Email {string} without @ or . sign")
    public void user_writes_the_new_Email_without_or_sign(String invalidEmail) {
        Driver.waitAndSendText(userInfo.emailField, invalidEmail, 3);
    }

    @Then("user verifies that {string} is displayed")
    public void user_verifies_that_is_displayed(String errorMessage) {
        String actualErrorMessage = userInfo.emailErrorMessage.getText().toString();
        System.out.println("error message - " + actualErrorMessage);
        Assert.assertEquals(errorMessage, actualErrorMessage);
    }

    @Then("user verifies that there is only following languages are displayed")
    public void user_verifies_that_there_is_only_following_languages_are_displayed(List<String> expectedLanguages) {
        System.out.println(expectedLanguages);

        Select select = new Select(userInfo.languageField);
        List<WebElement> listOfActualLanguages = select.getOptions();

        Iterator<WebElement> i = listOfActualLanguages.iterator();
        while (i.hasNext()) {
            System.out.println(i.next().getText());





        }
    }
}

//    public boolean validateLanguageOptions(){ 
//        Select langBox=new Select(languageBox); 
//        List<WebElement> langList=langBox.getOptions();  
//        int countEng=0; 
//        int countTurk=0; 
//        for (int i = 0; i <langList.size(); i++) { 
//            if(langList.get(i).getText().equals("English")){ 
//                countEng++;             } 
//            if(langList.get(i).getText().equals("Türkçe")){ 
//                countTurk++;             }         } 
//        return (countEng==1 & countTurk==1&langList.size()==2); 

//@Then("user validates there are two language options") 
//public void user_validates_there_are_two_language_options() {  
//        Assert.assertTrue(userInfoPage.validateLanguageOptions()); 
//} 