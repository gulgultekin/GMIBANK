package com.gmibank.stepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmibank.pojos.Country;
import com.gmibank.utilities.ConfigurationReader;
import com.gmibank.utilities.ReadTxt;
import com.gmibank.utilities.WriteToTxt;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;

public class CountryApiSteps {
    Response response;
    Country[] country;
    String bearerToken = ConfigurationReader.getProperty("api_bearer_token");
    String pathCountryFile = "src/test/resources/test_data/CountryFile.txt";

    @Given("user sets the response using api end point {string} and creates country using {string} and {string}")
    public void user_sets_the_response_using_api_end_point_and_creates_country_using_and(String url, String type, String country) {
        response = given().headers(
                "Authorization",
                "Bearer " + bearerToken,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when().body("{\"" + type + "\":\"" + country + "\"}")
                .post(url)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        //response.prettyPrint();
    }

    @Given("user sets the countries to response using {string}")
    public void user_sets_the_countries_to_response_using(String url) {
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
        response.prettyPrint();
    }

    @Given("user saves the countries to corresponding files")
    public void user_saves_the_countries_to_corresponding_files() throws Exception {
        ObjectMapper obj = new ObjectMapper();
        country = obj.readValue(response.asString(), Country[].class);
        WriteToTxt.saveAllCountries(pathCountryFile, country);
    }

    @Then("user validates the countries")
    public void user_validates_the_countries() {
        List<String> allCountries = new ArrayList<String>();
        allCountries.add("FRANCE");
        allCountries.add("Sweden");
        allCountries.add("Scotland");
        List<String> countryNames = ReadTxt.returnAllCountries(pathCountryFile);
        Assert.assertTrue("The country names are not matching", countryNames.containsAll(allCountries));
    }

    @Given("user sets the response using api end point {string} and updates country using {string} and {string}")
    public void user_sets_the_response_using_api_end_point_and_updates_country_using_and(String endPoint, String id, String name) {
        response = given().headers(
                "Authorization",
                "Bearer " + bearerToken,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when().body("{\"id\": " + id + ",\"name\": \"" + name + "\"}")
                .put(endPoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        //response.prettyPrint();
    }

    @Given("user deletes a country using endpoint {string} and its extension {string}")
    public void user_deletes_a_country_using_endpoint_and_its_extension(String endPoint, String id) {
        response = given().headers(
                "Authorization",
                "Bearer " + bearerToken,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .delete(endPoint + id)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        //response.prettyPrint();
    }
}