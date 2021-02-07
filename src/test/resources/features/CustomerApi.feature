Feature: Customer Api Steps


  Background: Provide customer api end point
    Given user sets customer api end point to response "https://www.gmibank.com/api/tp-customers"

  @ReadCustomers
  Scenario: Read all customers
    Given user reads all customers info
    And user saves customer data to correspondent files
    Then user validates all customer data
