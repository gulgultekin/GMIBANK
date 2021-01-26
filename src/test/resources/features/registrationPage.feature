@registrationPage
  Feature:registration
    Scenario:user register a new account
      Given user is on the home page
      When user go to registration page
      Then user enters ssn number
      Then user enters firstname and lastname
      Then user provides address
      Then user provides mobilephoneNumber
      Then user provides a username
      Then user provides email
      Then user enters the password
      Then user confirms the new password
      Then user clicks on register button and sees the success message










