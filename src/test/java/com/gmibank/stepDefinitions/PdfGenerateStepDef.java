package com.gmibank.stepDefinitions;

import com.gmibank.utilities.DatabaseUtility;
import com.gmibank.utilities.PDFGenerator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PdfGenerateStepDef {

    List<Map<String,Object>> listOfAllRecords;

    @Given("user provides the query {string} and gets all data")
    public void user_provides_the_query_and_gets_all_data(String query) {
        listOfAllRecords=DatabaseUtility.getQueryResultMap(query);
    }

    @Then("user generates pdf")
    public void user_generates_pdf() {
        List<String> userSSNs=new ArrayList<>();
        userSSNs.add("585-12-1234"); // Mehmetemployee1
        userSSNs.add("222-22-3333"); // mehmetuser1
        userSSNs.add("321-05-9588"); // mngr
        userSSNs.add("234-56-4567"); // admin

        PDFGenerator.pdfGeneratorRowsAndCellsAllUserList("All User Info",listOfAllRecords,userSSNs,"src/test/resources/test_data/allUserInfo.pdf");


    }
    @Then("user validate pdf exist")
    public void user_validate_pdf_exist() {
        String pdf_path = "src/test/resources/test_data/allUserInfo.pdf";
        File file=new File(pdf_path);
        Assert.assertTrue(file.exists());
    }
}
