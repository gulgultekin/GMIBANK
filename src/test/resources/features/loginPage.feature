@login
Feature: login page
  Scenario: User go to login page
    Given user on the login page


    Feature: login page

    Background:
        Given user goes to login page

    Scenario Outline: User validates login
        And user logins as "<role>"
        Then user logs in
        Then user validates successful login with sign out
    Examples:
        |role|
        |user|
        |admin|
        |manager|
        |employee|

    Scenario Outline: User validates cancel with information
        And user logins as "<role>"
        And user clicks cancel button
        Then user validates return to homepage
    Examples:
            |role|
            |user|
            |admin|
            |manager|
            |employee|

    Scenario: User validates cancel without information
        And user clicks cancel button
        Then user validates return to homepage

