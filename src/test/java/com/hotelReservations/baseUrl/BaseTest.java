package com.hotelReservations.baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

public class BaseTest {
    public static RequestSpecification spec;
    private static final String BASE_URI = "https://restful-booker.herokuapp.com";

    public BaseTest() {
        try {
            new File("logs").mkdirs();
            PrintStream log = new PrintStream(new FileOutputStream("logs/logging.txt"));
            spec = new RequestSpecBuilder()
                    .setContentType(ContentType.JSON)
                    .setBaseUri(BASE_URI)
                    .addFilters(Arrays.asList(
                            new RequestLoggingFilter(log),
                            new ResponseLoggingFilter(log)))
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
