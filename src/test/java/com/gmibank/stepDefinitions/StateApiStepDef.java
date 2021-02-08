package com.gmibank.stepDefinitions;

import com.gmibank.pojos.States;
import com.gmibank.utilities.ConfigurationReader;
import com.gmibank.utilities.ReadTxt;
import com.gmibank.utilities.WriteToTxt;
import cucumber.api.java.en.*;
import io.restassured.http.ContentType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Assert;
import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.given;

public class StateApiStepDef {

    Response response;
    States[] state;
    String path="src/test/resources/test_data/StateNames.txt";

    @Given("user sets the response using api end point {string} and creates states using {string} and {string}")
    public void user_sets_the_response_using_api_end_point_and_creates_states_using_and(String URL, String key, String value) {
        response=given().headers(
                "Authorization",
                "Bearer "+ ConfigurationReader.getProperty("api_bearer_token"),
                "Content-Type", ContentType.JSON,
                "Accept",ContentType.JSON)
                .when().body("{\""+key+"\":\""+value+"\"}")
                .post(URL)
                .then()
                .contentType(ContentType.JSON)
                .extract().response();
        response.prettyPrint();
    }

    @Given("user sets the states to response using {string}")
    public void user_sets_the_states_to_response_using(String url) {
        response=given().headers(
                "Authorization",
                "Bearer "+ ConfigurationReader.getProperty("api_bearer_token"),
                "Content-Type", ContentType.JSON,
                "Accept",ContentType.JSON)
                .when()
                .get(url)
                .then()
                .contentType(ContentType.JSON)
                .extract().response();
        response.prettyPrint();
    }

    @Given("user saves the states to correspondent files")
    public void user_saves_the_states_to_correspondent_files() throws IOException {

        System.out.println("test "+response);

        ObjectMapper objectMapper=new ObjectMapper();
        state=objectMapper.readValue(response.asString(),States[].class);

        WriteToTxt.saveAllStates2(path,state);

    }

    @Then("user validates the states")
    public void user_validates_the_states() throws IOException{
       List<String> allAddedStates=new ArrayList<String>();
        allAddedStates.add("Idaho");
        allAddedStates.add("Nevada");
        allAddedStates.add("North Dakota");

        List<String> allStatesWithApi= ReadTxt.returnAllStates3(path);

        Assert.assertTrue("The states are not matching ",allStatesWithApi.containsAll(allAddedStates));

    }



}
