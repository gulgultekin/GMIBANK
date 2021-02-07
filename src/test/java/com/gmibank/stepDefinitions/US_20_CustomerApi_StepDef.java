package com.gmibank.stepDefinitions;

import com.gmibank.pojos.Customer;
import com.gmibank.utilities.ConfigurationReader;
import com.gmibank.utilities.WriteToTxt;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import cucumber.api.java.en.Given;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class US_20_CustomerApi_StepDef {

    Response response;
    Customer[] customer;
    List<String> stringlist= new ArrayList<>();

    @Given("user go to api end point {string}")
    public void user_go_to_api_end_point(String api_end_point) {

        response = given().headers(
                        "Authorization",
                        "Bearer " + ConfigurationReader.getProperty("api_bearer_token"),
                        "Content_Type", ContentType.JSON,
                         "Accept", ContentType.JSON)
                .when()
                        .get(api_end_point)
                .then()
                        .contentType(ContentType.JSON)
                         .statusCode(200)
                        .extract()
                        .response();
        response.prettyPrint();

    }

    @Given("read all customer and create pojo class")
    public void read_all_customer_and_create_pojo_class() throws IOException {

        ObjectMapper objectMapper=new ObjectMapper(); //json i pojoya cevirmek icin kullaniyoruz
        customer=objectMapper.readValue(response.asString(),Customer[].class); //responce u customer pojo clasina atiyoruz​
        //  //deserilization yaptik, yukardaki metodla

//        for(Customer each: customer){
//            System.out.println(each.getFirstName());
//        }



        for(int i=0; i<customer.length; i++){
            stringlist.add(customer[i].getSsn());
           // System.out.println(customer[i].getSsn());
        }
        //customer clasindaki userlarin lastname null olmayanlarin lastnameni getir
        for(Customer each: customer) {
            if (each.getUser()!=null) {
                System.out.println(each.getUser().getLastName());
            }
        }
    }

    @Then("user validates all customer data")
    public void user_validates_all_customer_data() {

        List<String> createcustomerSSn = new ArrayList<>();

        createcustomerSSn.add("186-48-4946");
        createcustomerSSn.add("234-55-8998");
        createcustomerSSn.add("511-18-8543");
        createcustomerSSn.add("333-34-2395");

        Assert.assertTrue("This SSN not found",stringlist.containsAll(createcustomerSSn));

       // Assert.assertTrue("This SSN not found",response.getBody().asString().contains("170-22-3594"));



    }

}
