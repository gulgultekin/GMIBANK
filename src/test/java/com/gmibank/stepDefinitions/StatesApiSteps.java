package com.gmibank.stepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmibank.pojos.States;
import com.gmibank.utilities.ConfigurationReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StatesApiSteps {

    Response response;
    States[] states;


    @Given("user sets the response using api end point {string} and creates states using {string} and {string}")
    public void user_sets_the_response_using_api_end_point_and_creates_states_using_and(String endPoint, String id, String name) {

        response = given().headers(
                "Authorization",
                "Bearer " + ConfigurationReader.getProperty("api_bearer_token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when().body("{\"countryId\": "+id+",\"name\": \""+name+"\"}")
                .post(endPoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

    }

    @Given("user sets the states to response using {string}")
    public void user_sets_the_states_to_response_using(String url) {

        response = given().headers(
                "Authorization",
                "Bearer " +ConfigurationReader.getProperty("api_bearer_token"),
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

    }

    @Given("user saves the states to corresponding files")
    public void user_saves_the_states_to_corresponding_files() throws Exception{

        response.prettyPrint();
        ObjectMapper obj = new ObjectMapper();
        states = obj.readValue(response.asString(), States[].class);
        System.out.println(states[0].getName());
    }

    @Then("user validates the states")
    public void user_validates_the_states() {

    }

}
