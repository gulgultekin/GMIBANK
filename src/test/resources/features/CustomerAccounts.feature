@All
Feature:Customer Accounts feature


Background:Customer is in the login page
Given Customer is on the login page
Then Login to GMI Bank as customer
And Click My Operations icon on the top right corner of the page

#@MyAccounts
Scenario:User should see all account types and balance populated
Then Customer clicks My Accounts button


#@TransferMoney
Scenario:User can view transaction
Then Customer clicks Transfer Money and view transaction

