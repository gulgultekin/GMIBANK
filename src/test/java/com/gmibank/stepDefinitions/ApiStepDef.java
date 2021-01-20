package com.gmibank.stepDefinitions;

import cucumber.api.java.en.Given;

import javax.xml.ws.Response;

public class ApiStepDef
{

    Response response;
    @Given("user go to api end point {string}")
    public void user_go_to_api_end_point(String string)
    {
/*
        response=given().headers(
                    "Authorization",
                    "Bearer"+ ConfigurationReader.getProperty("api_bearer_token"),
                    "Content-Type",
                    ContentType.JSON,
                    "Accept",
                    ContentType.JSON)
                        .when()
                        .get(api_end_point)
                        .then()
                        .contentType(ContentType.JSON)
                        .extract()
                        .response();

 */

    }

    @Given("read all customer and sets response")
    public void read_all_customer_and_sets_response() {
        //response.prettyPrint();
    }


}
