@US17
Feature: System should allow the Admin to manage users

  Scenario Outline: go to sign in and user management
    Given user goes to login page
    And user provides username "<username>" and password "<password>"
    Then user logs in


    Examples:
      | username | password  |
      | Sunny    | Jsunny34* |


  Scenario Outline: Admin go to Administration and user management and activate a role
    Given user logs in
    When Admin navigates to Administration dropdown
    And Admin clicks on User management
    And Admin find current user "Yusuf2001" and click edit button
    Then Admin can give"<role>" and activated

    Examples: admin can give role
      | role          |
      | ROLE_ADMIN    |
        #  | ROLE_USER     |
         # | ROLE_EMPLOYEE |
          #| ROLE_MANAGER  |
          #| ROLE_CUSTOMER |

  Scenario: Admin can view all user info
    Given user navigates to my operations
    When user clicks on manageCustomer
     # And user clicks on View button
     # Then verify that customer info displayed
