@login
Feature: login page
  Scenario: User go to login page
    Given user on the login page

    Scenario: User validates login success message
        Given user on the login page
        When user clicks sign in button under user icon
        Then user enters valid username "user2020"
        And user enters valid password "user2020"
        And user clicks sign in button
        Then user validates successful login with message


  Scenario: User validates login
      Given user on the login page
      When user clicks sign in button under user icon
      Then user enters valid username "user2020"
      And user enters valid password "user2020"
      And user clicks sign in button
      Then user validates successful login with sign out


  Scenario: User validates cancel with information
          Given user on the login page
          When user clicks sign in button under user icon
          Then user enters valid username "user2020"
          And user enters valid password "user2020"
          And user clicks cancel button
          Then user validates return to homepage


  Scenario: User validates cancel without information
          Given user on the login page
          When user clicks sign in button under user icon
          And user clicks cancel button
          Then user validates return to homepage