package com.gmibank.stepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmibank.pojos.Customer;
import com.gmibank.utilities.ConfigurationReader;
import com.gmibank.utilities.ReadTxt;
import com.gmibank.utilities.WriteToTxt;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CustomerApiSteps {
    Response response;
    Customer[] customer;
    String bearerToken = ConfigurationReader.getProperty("api_bearer_token");
    String path = "src/test/resources/test_data/Project3CustomerSSNs.txt";


    @Given("user sets customer api end point to response {string}")
    public void user_sets_customer_api_end_point_to_response(String url) {

        response = given().headers(
                "Authorization",
                "Bearer " + bearerToken,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .get(url)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        //   response.prettyPrint();
    }

    @Given("user reads all customers info using")
    public void user_reads_all_customers_info_using() throws Exception {

        ObjectMapper obj = new ObjectMapper();

        customer = obj.readValue(response.asString(), Customer[].class);

        for (int i = 0; i < customer.length; i++) {
            if (customer[i].getUser() != null) {
                System.out.println(customer[i].getFirstName());
            }
        }
//        System.out.println(customer[0].getSsn());
//        System.out.println(customer[0].getFirstName());


        for (int i = 0; i < customer.length; i++) {
            System.out.println(customer[i].getSsn());
        }

    }

    @Given("user saves customer data to correspondent files")
    public void user_saves_customer_data_to_correspondent_files() {

        //WriteToTxt.saveAllCustomerSSNWithApi(path, customer);

    }

    @Then("user validates all customer data")
    public void user_validates_all_customer_data() {
        List<String> allCurrentSSNs = new ArrayList<String>();
        allCurrentSSNs.add("108-53-6655");
        allCurrentSSNs.add("224-71-4004");

        List<String> customerSSNListWithApi = ReadTxt.returnCustomerSNNList(path);

        Assert.assertTrue("The SSNs are not matching", customerSSNListWithApi.containsAll(allCurrentSSNs));
    }


}
