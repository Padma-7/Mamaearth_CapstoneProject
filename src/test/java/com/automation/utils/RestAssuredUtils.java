package com.automation.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class RestAssuredUtils {
    static RequestSpecification requestSpecification = RestAssured.given();
    @Getter
    static Response response;
    static String endPoint;

    public static void setEndPoint(String endPoint)
    {
        RestAssuredUtils.clear();
        if(endPoint.contains("@id"))
        {
            endPoint=endPoint.replace("@id",ConfigReader.getConfigValue("id"));
        }
        RestAssuredUtils.endPoint= endPoint;
    }

    private static void clear() {
        requestSpecification = RestAssured.given();
    }

    public static void setHeader(String key, String value)
    {
        if(value.contains("@token"))
        {
            value=value.replace("@token",ConfigReader.getConfigValue("auth.token"));
        }
        requestSpecification.header(key,value);
    }


    public static void post()
    {
        requestSpecification.log().all();
        response=requestSpecification.post(endPoint);
        response.then().log().all();
    }

    public static void get()
    {
        requestSpecification.log().all();
        response= requestSpecification.get(endPoint);
        response.then().log().all();
    }

    public static void put()
    {
        requestSpecification.log().all();
        response= requestSpecification.put(endPoint);
        response.then().log().all();
    }


    public static int getStatusCode()
    {
        return response.getStatusCode();
    }

    public static void setBody(String fileName) throws FileNotFoundException {
        requestSpecification.body(RestAssuredUtils.getJsonFileContent(fileName));
    }

    private static String getJsonFileContent(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream(ConfigReader.getConfigValue("json.folder.path")+fileName));
        String content = sc.useDelimiter("\\Z").next();
        return content;
    }


    public static void storeResponseFieldValueToConfig(String jsonPath, String key) {
        ConfigReader.setConfigValue(key, RestAssuredUtils.getResponseFieldValue(jsonPath));
    }

    public static String getResponseFieldValue(String jsonPath) {
        System.out.println(response.jsonPath().getString(jsonPath));
        return response.jsonPath().getString(jsonPath);
    }

    public static void delete() {
        requestSpecification.log().all();
        response= requestSpecification.delete(endPoint);

    }
}
