@CountryReader
Feature: Read countries
  @CreateCountry
  Scenario Outline: Create country
    Given user sets the response using api end point "https://www.gmibank.com/api/tp-countries" and creates country using "<idJson>" and "<nameJson>"
    Examples: create country
      | idJson | nameJson |
      | name   | Mono     |
  Scenario: Read all countries
    Given user sets the countries to response using "https://www.gmibank.com/api/tp-countries"
    And user saves the countries to corresponding files
    Then user validates the countries
  @UpdateCountry
  Scenario Outline: update country
    Given user sets the response using api end point "https://www.gmibank.com/api/tp-countries" and updates country using "<idJson>" and "<nameJson>"
    Examples: update country
      | idJson | nameJson |
      | 73047  | Kingson  |
  @DeleteCountry
  Scenario Outline: delete country
    Given user deletes a country using endpoint "<endPoint>" and its extension "<id>"
    Examples:
      | endPoint                                 | id     |
      | https://www.gmibank.com/api/tp-countries | /73047 |