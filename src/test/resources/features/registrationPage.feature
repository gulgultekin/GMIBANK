@registrationPage
  Feature:registration
    Scenario:user register a new account
      Given user is on the home page
      When user go to registration page
      Then user enters ssn number as "231-42-5761"
      Then user enters firstname and lastname as "team24" and "gmibank"
      Then user provides address "USA"
      Then user provides mobilephone as "123-456-7890"
      Then user provides a username "TEAM24"
      Then user provides email id as "gmibankteam24@gmail.com"
      Then user enters the password as "Team.24"
      Then user confirms the new password "Team.24"
      Then user clicks on register button and sees the success message










