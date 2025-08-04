Feature: User can create a hotel reservation
  @booking
  Scenario: User can create and delete a hotel reservation
    Given The user is creating a new reservation
    And The user provides the required reservation details
    When The user submits the hotel reservation
    Then The reservation is successfully created
    And The user cancels the created reservation