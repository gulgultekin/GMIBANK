@Smoke
  Feature: Adding Account As an Employee
    Scenario: Verify adding Account
      Given user goes to login page
      When And user provides username  "mehmetemployee1" and password "Mehmet8691@"
      Then navigate to Create an Account page
      And description can not be blank  Employee see that message"This field is required."
      Then employee should create a description
      And employee provide a balance as a Dollar
      When Employee click account type can see option  CHECKING,SAVING,CREDIT_CARD or INVESTING
      Then Account status should be defined as ACTIVE, SUSPENDED or CLOSED
      And User can select an employee from the drop-down