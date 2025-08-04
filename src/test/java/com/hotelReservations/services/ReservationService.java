package com.hotelReservations.services;

import com.hotelReservations.baseUrl.BaseTest;
import com.hotelReservations.models.Auth;
import com.hotelReservations.models.Booking;
import com.hotelReservations.models.BookingResponse;
import com.hotelReservations.models.Bookingdates;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

public class ReservationService extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ReservationService.class);

    public  String generateAuthentications(){
        logger.info("Generating authentication token...");
        Auth authBody = new Auth("admin", "password123");

        Response response = given(spec)
                .body(authBody)
                .post("/auth");

        response
                .then()
                .statusCode(200);

        return response.jsonPath().getJsonObject("token");
    }
    public BookingResponse createBooking() {
        logger.info("Creating new hotel booking...");
        Bookingdates bookingdates = new Bookingdates("2025-08-04", "2025-08-05");
        Booking booking = new Booking("Arthur", "Morgan", 10000, false, bookingdates, "Pet care");

        Response response = given(spec)
                .body(booking)
                .post("/booking");
        response
                .then()
                .statusCode(200);
        logger.info("Booking created successfully.");
        return response.as(BookingResponse.class);

    }

    public void deleteReservation(String token, int bookingId) {
        logger.info("Deleting reservation with ID: {}", bookingId);
        Response response = given(spec)
                .header("Cookie","token="+token)
                .delete("/booking/"+bookingId);
        response.
                then().
                statusCode(201);
        logger.warn("Reservation deleted using token: {}", token);
    }
}
