@StateAPI
Feature: Read states

  @CreateState
  Scenario Outline: create a state
    Given user sets the response using api end point "https://www.gmibank.com/api/tp-states" and creates states using "<key>" and "<value>"

    Examples: create states
      | key  | value        |
      | name | Idaho        |
      | name | Nevada       |
      | name | North Dakota |

  Scenario: read all states
    Given user sets the states to response using "https://www.gmibank.com/api/tp-states"
    And user saves the states to correspondent files
    Then user validates the states


