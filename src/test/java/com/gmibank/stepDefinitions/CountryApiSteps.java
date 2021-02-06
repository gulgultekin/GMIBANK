package com.gmibank.stepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmibank.pojos.Country;
import com.gmibank.utilities.ConfigurationReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CountryApiSteps {

    Response response;
    Country[] countries;
    String bearerToken = ConfigurationReader.getProperty("api_bearer_token");


    @Given("user sets the response using api end point {string} and creates country using {string} and {string}")
    public void user_sets_the_response_using_api_end_point_and_creates_country_using_and(String url, String type, String country) {


        response =given().headers(
                "Authorization",
                "Bearer "+bearerToken,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when().body("{\""+type+"\":\""+country+"\"}")
                .post(url)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();


    }

    @Given("user sets the countries to response using {string}")
    public void user_sets_the_countries_to_response_using(String url) {

        response=given().headers(
                "Authorization",
                "Bearer " +bearerToken,
                "Content_Type",
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

    @Given("user saves the countries to correspond files")
    public void user_saves_the_countries_to_correspond_files() throws Exception{
        response.prettyPrint();
        ObjectMapper obj = new ObjectMapper();
        countries = obj.readValue(response.asString(), Country[].class);
        System.out.println(countries[0].getName());


    }

    @Then("user validates the countries")
    public void user_validates_the_countries() {

    }

    @Given("user deletes the country using end point {string} and its extension {string}")
    public void user_deletes_the_country_using_end_point_and_its_extension(String string, String string2) {

    }

    @Given("user sees all logs {string}")
    public void user_sees_all_logs(String string) {

    }

}
