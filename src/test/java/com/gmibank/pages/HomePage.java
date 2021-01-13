package com.gmibank.pages;

import com.gmibank.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
