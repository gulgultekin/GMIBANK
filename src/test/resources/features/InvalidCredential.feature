@USO2
Feature:RegistrationPageCheck

  Background: Going to the Registration Page
    Given user is on the homepage
    When user go to registrationpage


  Scenario:Warning Message
    Given user clicks on register button
    And user verifies that warning messages are displayed


  Scenario Outline: Invalid Credentials
    Then user enters ssn number with invalid char "<invalidSSN>"
    Then user sees Your SSN is invalid error message
    Then user provides mobile phone with non numeric char "<invalidPhoneNumber>"
    Then user sees Your mobile phone number is invalid error message
    Then user provides email id without @ sign "<invalidEmail>"
    Then user sees This field is invalid error message
    Examples:
      |invalidSSN     |  invalidPhoneNumber  |invalidEmail    |
      | 123*34-5678   |   A1s*345-678033     | gmibankgmail.com    |
    #  | S34-45-675A   |   123*234-5678       |gmibank24@gmailcom    |
