package com.gmibank.stepDefinitions;

import com.gmibank.utilities.DatabaseUtility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class DatabaseStepDef {

    List<Object>listOfRecords;
    List<String>dbRecordsString=new ArrayList<String>();

    @Given("user creates a connection with GMI-DB using {string}, {string} and {string}")
    public void user_creates_a_connection_with_GMI_DB_using_and(String url, String username, String password) {
        DatabaseUtility.createConnection(url, username, password);
    }

    @Given("user provides the query {string} and {string} and gets column data")
    public void user_provides_the_query_and_and_gets_column_data(String query, String columnName) {
        listOfRecords=DatabaseUtility.getColumnData(query,columnName);

    }

    @Then("user validates all user data")
    public void user_validates_all_user_data() {
        List<String> userSSNs=new ArrayList<>();
        userSSNs.add("585-12-1234"); // Mehmetemployee1
        userSSNs.add("222-22-3333"); // mehmetuser1
        userSSNs.add("321-05-9588"); // mngr
        userSSNs.add("234-56-4567"); // admin

        Assert.assertTrue(listOfRecords.containsAll(userSSNs));

    }

    @Then("user validates country data")
    public void user_validates_country_data() {
        List<String> userCountry=new ArrayList<>();
        userCountry.add("4");
        userCountry.add("22320");
        userCountry.add("24366");


        for (int i = 0; i < listOfRecords.size(); i++) {
            if(listOfRecords.get(i)!=null) {
                dbRecordsString.add(listOfRecords.get(i).toString().trim());
            }
        }
        Assert.assertTrue(dbRecordsString.containsAll(userCountry));
    }


    @Then("user validates all usa state data")
    public void user_validates_all_usa_state_data() {
        List<String> newCustmrStateID=new ArrayList<>();
        newCustmrStateID.add("73155");
        newCustmrStateID.add("72788");
        for (int i = 0; i < listOfRecords.size(); i++) {
            if(listOfRecords.get(i)!=null) {
                dbRecordsString.add(listOfRecords.get(i).toString().trim());
            }
        }
        Assert.assertTrue(dbRecordsString.containsAll(newCustmrStateID));

    }

//    @Then("user validates all usa state data")
//    public void user_validates_all_usa_state_data() {
//        List<String> stateCountry=new ArrayList<>();
//        stateCountry.add("4");
//        stateCountry.add("3");
//        for (int i = 0; i < listOfRecords.size(); i++) {
//            if(listOfRecords.get(i)!=null) {
//                dbRecordsString.add(listOfRecords.get(i).toString().trim());
//            }
//        }
//        Assert.assertTrue(dbRecordsString.containsAll(stateCountry));

//        dbRecordsString=>stateler burda

// }

}
