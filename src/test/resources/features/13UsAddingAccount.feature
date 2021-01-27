@Us-13
Feature: Manage Account workflow

  Scenario Outline: go to sign in
    Given user goes to login page
    And user provides username "<username>" and password "<password>"
    Then user logs in
    And user navigates to my operations
    When user clicks on manageAccounts

    Examples:
      |username|password|
      |Rosa2001|Rosa2001@|


  Scenario Outline: employee can create a new account
    And user navigates to my operations
    When user clicks on manageAccounts
    And user clicks on Create a new Account button
    Then user navigates to the Create or edit a Account page
    Then go to  Description inputbox it can not be blank
    And and provide an "<Description>"
    Then go to  Balance inputbox it can not be blank
    Then go to  Balance inputbox and provide "<Balance>" as dollar
    And go to Account type dropdown and choose an "<Account type>"
    Then go to Account Status type dropdown and choose "<Account Status Type>"
    Then go to Employee inpuBox and choose an Employee
    Then click save button

    Examples:
      | Description                      | Balance | Account type | Account Status Type |
      | Checking Account for customer    | 5000    | CHECKING     | ACTIVE              |
      | Saving Account for customer      | 15000   | SAVING       | ACTIVE              |
      | Credit_Card Account for customer | 20000   | CREDIT_CARD  | SUSPENDING          |
      | Investing Account for customer   | 10000   | INVESTING    | CLOSED              |
