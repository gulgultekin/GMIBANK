package com.gmibank.stepDefinitions;

import com.gmibank.utilities.DatabaseUtility;
import com.gmibank.utilities.WriteToTxt;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;

public class DatabaseStepDef {
    List<Object>listOfIds;
    String fileName = "CustomerIds.txt";
    String filePath = "src/test/resources/test_data/CustomerIds.txt";

//    @Given("user connect database and print all data")
//    public void user_connect_database_and_print_all_data() {
//        DatabaseUtility.createConnection();
//
//        String query= "select * from public.tp_customer";
//        List<Object> list= DatabaseUtility.getColumnData(query,"email");
//
//        for(Object w: list){
//            System.out.println(w.toString());
//        }
//    }

    @Given("user creates a connection with GMI-DB using {string}, {string} and {string}")
    public void user_creates_a_connection_with_GMI_DB_using_and(String url, String username, String password) {

        DatabaseUtility.createConnection(url,username,password);
    }

    @Given("user reads database info")
    public void user_reads_database_info() {

        String query = "Select * from tp_customer";
        String columnName = "id";

//      List<Object>list = DatabaseUtility.getColumnData(query,columnName);
//        System.out.println(list);

        String cell =DatabaseUtility.getCellValue(query).toString();
        System.out.println(cell);//42688 ->first row first cell


    }


    @Given("user provides the query {string} and {string} and gets column data")
    public void user_provides_the_query_and_and_gets_column_data(String query, String columnName) {

        //listOfIds = DatabaseUtility.getColumnData(query,columnName);
       // WriteToTxt.
    }

    @Given("user validates column Data")
    public void user_validates_column_Data() {

        List<String> currentIds = new ArrayList<>();
        currentIds.add("35128");
        currentIds.add("36529");
        currentIds.add("61419");
        currentIds.add("40385");
    }

    @Then("user prints all columnData with user")
    public void user_prints_all_columnData_with_user() {

    }





}
