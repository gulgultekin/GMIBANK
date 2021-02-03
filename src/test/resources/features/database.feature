@db
  Feature:  Database Test

    Background: create a connection with GMI Bank Database
      Given user creates a connection with GMI-DB using "jdbc:postgresql://157.230.48.97:5432/gmibank_db", "techprodb_user" and "Techpro_@126"

    Scenario: read data using database
      Given user reads database info

      Scenario Outline: Check all column Data
        Given user provides the query "<query>" and "<columnName>" and gets column data
        And user validates column Data
        Then user prints all columnData with user

        Examples:all data set
        |query|columnName|
        |  Select * from tp_customer;   |  id        |

