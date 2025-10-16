package com.mantis.api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Specs {

    private static final String BASE_URL = ConfigReader.getProperty("api.baseUrl");
    private static final String TOKEN = ConfigReader.getProperty("api.token");

    public static RequestSpecification authSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Content-type", "application/json")
                .addHeader("Authorization", TOKEN)
                .addHeader("Accept", "*/*")
                .build()
                ;
    }

    public static RequestSpecification withoutAuthSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Content-type", "application/json")
                .addHeader("Accept", "*/*")
                .build()
                ;
    }
}