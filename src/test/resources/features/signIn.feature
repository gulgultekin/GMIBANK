@US-05-InvalidCredentials
Feature: Login page should not be accessible with invalid credentials

  Background:
    Given user goes to login page

  Scenario: Login with invalid username
    And user provides invalid username "invalidUserName" and valid password "validPassword"and click
    Then user should see error message



  Scenario: Login with invalid password
    And user provides valid "validUserName" and invalid "invalidPassword"and click
    Then user should see error message

  Scenario: Login with invalid username and invalid password
    And user provides invalid "invalidUserName" and invalid "invalidPassword"and click
    Then user should see error message

  Scenario: User can click Did you forget your password? link
    Then Did you forget your password? link should be visible and clickable
    And when user click link should navigate to the reset your password page
    Then user provide email  and click reset password button and see success message


  Scenario: User can click Register a new account link
    Then Register a new account link should be visible and clickable
    And when user click link should navigate to the Registration page
