@US20
Feature: Customer Api Steps


  Scenario: read all customers
    Given user go to api end point "https://www.gmibank.com/api/tp-customers"
    And read all customer and create pojo class
    Then user validates all customer data

