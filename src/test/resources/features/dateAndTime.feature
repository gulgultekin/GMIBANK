@date
Feature: Date and time

  Scenario Outline:

    Given user goes to login page
    And user provides username "<username>" and password "<password>"
    Then user logs in
    Examples:
      | username    | password    |
      | team11admin | Team11admin |

  Scenario: The date should be created at the time of customer creation

    When user navigates to "Users" page
    And user clicks the "Create a new user" button
    And user fills out required fields to create user
    And user saves the current date and time
    And user clicks on the "Save" button
    Then user verifies that the creation date and time are same as saved current date and time

  Scenario: The date should be created as month, day, year, hour, and minute
    When user navigates to "Users" page
    And user clicks the "Create a new user" button
    And user fills out required fields to create user
    And user clicks on the "Save" button
    Then verify that date is created as month, day, year, hour and minute

  Scenario: User can choose a user from the registration and it cannot be blank
    When user navigates to "Users" page
    And user chooses one user by clicking on his id and lands on User page
    Then user verifies that first name field is not empty

  Scenario: User can select Zelle enrolled optionally and save it
    When User selects Manage Customers option from My Operations dropdown menu and lands on customers page
    And user clicks on Edit button
    And User selects Zelle Enrolled option and saves it