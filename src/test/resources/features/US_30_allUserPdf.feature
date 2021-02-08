@pdfGenerate
Feature:PDF generate

  Background: create a connection with GMI Bank Database
    Given user creates a connection with GMI-DB using "jdbc:postgresql://157.230.48.97:5432/gmibank_db", "techprodb_user" and "Techpro_@126"

  Scenario Outline: All user info pdf generate
    Given user provides the query "<query>" and gets all data
    Then user generates pdf
    Then user validate pdf exist

    Examples:
      | query                                                                                                                             |
      | Select * from tpaccount_registration left join jhi_user_authority on tpaccount_registration.user_id = jhi_user_authority.user_id; |
