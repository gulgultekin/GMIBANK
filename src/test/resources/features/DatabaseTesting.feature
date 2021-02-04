@database
Feature:Database Testing

  Background: create a connection with GMI Bank Database
    Given user creates a connection with GMI-DB using "jdbc:postgresql://157.230.48.97:5432/gmibank_db", "techprodb_user" and "Techpro_@126"

  Scenario Outline: Check all user data
    Given user provides the query "<query>" and "<columnName>" and gets column data
    Then user validates all user data

    Examples:
      | query                                 | columnName |
      | Select * from tpaccount_registration; | ssn        |


  Scenario Outline: Check all country data
    Given user provides the query "<query>" and "<columnName>" and gets column data
    Then user validates country data

    Examples:
      | query                     | columnName |
      | Select * from tp_country; | id      |
#    country table dan ulke id lerini al

#  Scenario Outline: Check all USA state data
#    Given user provides the query "<query>" and "<columnName>" and gets column data
#    Then user validates all usa state data
#
#    Examples:
#      | query                     | columnName |
#      | Select * from tp_state; | tpcountry_id      |
#    state tablosundan butun country id lerini topla sonra USA id exist mi?

