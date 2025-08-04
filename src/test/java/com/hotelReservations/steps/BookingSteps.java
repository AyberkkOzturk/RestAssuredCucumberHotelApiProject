package com.hotelReservations.steps;

import com.hotelReservations.models.BookingResponse;
import com.hotelReservations.services.ReservationService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class BookingSteps {
    ReservationService reservationService;
    String authKey;
    BookingResponse bookingResponse;
    @Given("The user is creating a new reservation")
    public void theUserIsCreatingANewReservation() {
        reservationService = new ReservationService();

    }

    @And("The user provides the required reservation details")
    public void theUserProvidesTheRequiredReservationDetails() {
        authKey = reservationService.generateAuthentications();
    }

    @When("The user submits the hotel reservation")
    public void theUserSubmitsTheHotelReservation() {
        bookingResponse = reservationService.createBooking();
    }

    @Then("The reservation is successfully created")
    public void theReservationIsSuccessfullyCreated() {
        Assertions.assertEquals("Arthur",bookingResponse.getBooking().getFirstname());
        Assertions.assertEquals("Morgan",bookingResponse.getBooking().getLastname());
        Assertions.assertEquals(10000,bookingResponse.getBooking().getTotalprice());
        Assertions.assertFalse(bookingResponse.getBooking().isDepositpaid());
        Assertions.assertEquals("Pet care",bookingResponse.getBooking().getAdditionalneeds());

    }

    @And("The user cancels the created reservation")
    public void theUserCancelsTheCreatedReservation() {
        reservationService.deleteReservation(authKey,bookingResponse.getBookingid());
    }
}
