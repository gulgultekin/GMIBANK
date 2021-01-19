    @login
    Feature: login page

    Background:
        Given user on the login page

    Scenario: User go to login page


    Scenario: User validates login success message
        When user clicks sign in button under user icon
        Then user enters valid username "user2020"
        And user enters valid password "user2020"
        And user clicks sign in button
        Then user validates successful login with message


    Scenario: User validates login
        When user clicks sign in button under user icon
        Then user enters valid username "user2020"
        And user enters valid password "user2020"
        And user clicks sign in button
        Then user validates successful login with sign out


    Scenario: User validates cancel with information
        When user clicks sign in button under user icon
        Then user enters valid username "user2020"
        And user enters valid password "user2020"
        And user clicks cancel button
        Then user validates return to homepage


    Scenario: User validates cancel without information
        When user clicks sign in button under user icon
        And user clicks cancel button
        Then user validates return to homepage