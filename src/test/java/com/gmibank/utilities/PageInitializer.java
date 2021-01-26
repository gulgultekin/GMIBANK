package com.gmibank.utilities;

import com.github.javafaker.Faker;
import com.gmibank.pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import java.text.DecimalFormat;
import java.util.Formatter;

import static com.gmibank.utilities.Driver.getDriver;

public class PageInitializer {

    public static CommonWebElements employeePage = new CommonWebElements();
    public static ManageCustomerPage manageCustomerPage = new ManageCustomerPage();
    public static Actions actions = new Actions(getDriver());
    public static JavascriptExecutor js = (JavascriptExecutor) getDriver();
    public static ConfigurationReader configReader = new ConfigurationReader();
    public static CreateEditUser user = new CreateEditUser();
    public static UserManagementPage userManagementPage = new UserManagementPage();
    public static EditCustomerPage editCustomer = new EditCustomerPage();
    public static Faker faker = new Faker();
    public static RegistrationPage registrationPage = new RegistrationPage();
    public static CommonWebElements commonWebElements = new CommonWebElements();
    public static DecimalFormat decimalFormat;

}

