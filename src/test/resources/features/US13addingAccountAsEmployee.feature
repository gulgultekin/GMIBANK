@130
 Feature:User should provide a balance for the first time account creation as Dollar

   @tag131
   Scenario : Create new account  as an employee and description can not be blank
     And  sign in as an employee username "mehmetemployee1" and password "Mehmet8691@"
     Then click my operation dropdown and choose manage accounts option
     And  can not be blank "This field is required." employee should create a description and provide a balance as a Dollar
     Then user can select an account type from dropdown "CHECKING","SAVING","CREDIT_CARD" or "INVESTING"
     And Account status should be defined as ACTIVE, SUSPENDED or CLOSED
     Then User can select an employee from the drop-down
