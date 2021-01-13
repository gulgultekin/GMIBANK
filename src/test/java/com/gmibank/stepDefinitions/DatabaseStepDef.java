package com.gmibank.stepDefinitions;

import com.gmibank.utilities.DatabaseUtility;
import cucumber.api.java.en.Given;

import javax.xml.crypto.Data;
import java.awt.*;
import java.sql.*;
import java.util.List;

public class DatabaseStepDef {

    @Given("user connect database and print all data")
    public void user_connect_database_and_print_all_data() {
        DatabaseUtility.createConnection();

        String query= "select * from public.tp_customer";
        List<Object> list= DatabaseUtility.getColumnData(query,"email");

        for(Object w: list){
            System.out.println(w.toString());
        }
    }



}
