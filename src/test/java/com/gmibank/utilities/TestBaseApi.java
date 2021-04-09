package com.gmibank.utilities;

import cucumber.api.java.Before;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.testng.asserts.SoftAssert;

public class TestBaseApi
{
    static protected RequestSpecification requestSpecification01;

    protected Response response;
    protected JsonPath jsonPath;
    protected SoftAssert softAssert;

    @BeforeEach
    static public void setUp01(){
        requestSpecification01=new RequestSpecBuilder().
                setBaseUri("https://www.gmibank.com/api").//BASE URL+path param
                build();
        //requestSpecification01 object'in içinde END-POINT'im var
        //FOR TESTS, I SET UP BASE URL
    }


    public static <ClassType> void getSpecObjOfResponse(ClassType[] objArr) {
/*
        for(int i=0; i<objArr.length;i++) {
            if (objArr[i].getCountry() != null) {
                System.out.println(objArr[i].getCountry());
            }
        }
*/
    }
}
