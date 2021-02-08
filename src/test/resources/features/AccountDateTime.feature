@accountDate
Feature: Account date and time

  Background:
    Given user goes to login page

  Scenario Outline: User login
    And user logins as "<role>"
    Then user logs in
    Examples:
      | role     |
      | employee |

  Scenario Outline: employee can create a new account
    And user navigates to my operations
    And user clicks on manageAccounts
    And user clicks on Create a new Account button
    Then user navigates to the Create or edit a Account page
    And and provide an "<Description>"
    Then go to  Balance inputbox and provide "<Balance>" as dollar
    And go to Account type dropdown and choose an "<Account type>"
    Then go to Account Status type dropdown and choose "<Account Status Type>"
    Then go to Employee inpuBox and choose an Employee
    Then user saves creation date
    Then click save button
    Then user validates creation date
    Then user validates date format
    Examples:
      | Description            | Balance | Account type | Account Status Type |
      | account date test 1003 | 5000    | CHECKING     | ACTIVE              |

  Scenario: User validates account description is not blank
    And user navigates to my operations
    And user clicks on manageAccounts
    Then user clicks id of an account
    Then user validates account info is loaded
    Then user validates description is not empty
