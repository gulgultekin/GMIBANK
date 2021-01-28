@Us-17
  Feature: System should allow the Admin to manage users

    Scenario Outline: go to sign in and user management
      Given user goes to login page
      And user provides username "<username>" and password "<password>"
      Then user logs in


      Examples:
        |username|password|
        |Sunny|Jsunny34*|


      Scenario: Admin go to Administration and user management and activate a role
        Given user logs in
        When user navigates to Administration
        And user clicks on User management