@ManageCustomer_US12
Feature: Manage Customer workflow

  Scenario Outline: go to sign in and view
    Given user goes to login page
    And user provides username "<username>" and password "<password>"
    Then user logs in
    And user navigates to my operations
    When user clicks on manageCustomer
    Then user clicks on View button
    Then verify that customer info displayed

    Examples:
      |username|password|
      |Rosa2001|Rosa2001@|

  Scenario Outline: edit customer info
    And user navigates to my operations
    When user clicks on manageCustomer
    And user clicks on Edit button
    Then user goes  inputbox and edit "<mobilePhoneNum>"and "<email>"
    And user scroll down and click save button
    Then verify success message is displayed

    Examples:
    |mobilePhoneNum|email|
    |555-555-5555|newemail.com|


  Scenario: delete customer
    And user navigates to my operations
    When user clicks on manageCustomer
    And user clicks on Delete button
    Then verify that confirmation Delete Question is displayed
    And click confirmation Delete button
    Then validate if the success message displayed
    Then verify that customer info deleted

