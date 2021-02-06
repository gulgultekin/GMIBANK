
Feature: Read states

  @CreateState
  Scenario Outline: create a state
    Given user sets the response using api end point "https://www.gmibank.com/api/tp-states" and creates states using "<idJson>" and "<nameJson>"


    Examples: create states
    |idJson  |nameJson |
    | 73867  | PARIS   |
    | 73867  | OLDCITY |



    Scenario: read all states
      Given user sets the states to response using "https://www.gmibank.com/api/tp-states"
      And user saves the states to corresponding files
      Then user validates the states
