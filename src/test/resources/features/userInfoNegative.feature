@userInfoNegative
Feature: User segment doesn't allow updates with invalid data

  Scenario: There should be user info being populated when navigating to user info

    Given User goes to login page
    When User provides username "team11admin" and password "Team11admin"
    And User logs in
    And User navigates and clicks on user info
    And User should see info being populated

  Scenario: Email with invalid data

    When User navigates and deletes the email
    And User writes the new Email "marygmail.com" without @ or . sign
    Then user verifies that "This field is invalid" is displayed

  Scenario: There should be 2 languages available "English and Turkish"
    When User goes to the language dropdown and clicks on it
    And User chooses English
    And User chooses Turkish

    Then user verifies that there is only following languages are displayed
      | English   |
      | Türkçe    |