    @login
    Feature: login page

    Background:
        Given user on the login page
        When user clicks sign in button under user icon

    Scenario: User validates login
        Then user enters valid username "user2020"
        And user enters valid password "user2020"
        And user clicks sign in button
        Then user validates successful login with sign out

    Scenario: User validates cancel with information
        Then user enters valid username "user2020"
        And user enters valid password "user2020"
        And user clicks cancel button
        Then user validates return to homepage

    Scenario: User validates cancel without information
        And user clicks cancel button
        Then user validates return to homepage