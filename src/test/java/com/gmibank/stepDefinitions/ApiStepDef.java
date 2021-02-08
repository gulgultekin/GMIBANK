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
import io.restassured.response.Response;
import java.io.IOException;


public class ApiStepDef
{
 Response response;
 Customer[] customer;
 @Given("user go to api end point {string}")
 public void user_go_to_api_end_point(String api_end_point) {
  response=given().headers(
          "Authorization",
          "Bearer "+ConfigurationReader.getProperty("api_bearer_token"),
          "Content_Type",ContentType.JSON,
          "Accept",ContentType.JSON)
          .when()
          .get(api_end_point)
          .then()
          .contentType(ContentType.JSON)
          .extract()
          .response();
  response.prettyPrint();

 }
 @Given("read all customer and sets response")
 public void read_all_customer_and_sets_creat_pojo_class() throws IOException {

  ObjectMapper objectMapper=new ObjectMapper();
  customer=objectMapper.readValue(response.asString(),Customer[].class);
  for (int i=0; i<customer.length;i++){
   //System.out.println(customer[i].getSsn());
  }
  System.out.println("*********************************");
  for(int i=0; i<customer.length;i++) {
   if (customer[i].getUser() != null) {
    //            System.out.println(customer[i].getUser().getId());
   }
  }
 }
 @Then("Validate data")
 public void validate_data() {
  WriteToTxt.saveAllCustomerSsn("allCustomerSSN.txt",customer);
 }
}