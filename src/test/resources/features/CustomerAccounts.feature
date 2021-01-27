
@all
  Feature: Customer Accounts feature

    Background: Customer is in the login page
      Given Customer is on the login page
      When Login to GMI Bank as customer
      Then Click My Operations icon on the top right corner of the page

    @myAccounts
    Scenario: User should see all account types and balance populated
      Then Customer clicks on My Accounts button

    @transferMoney
    Scenario: User can view transaction
      Then Customer clicks on Transfer Money and view transaction










#@all
#Feature:Customer Accounts feature
#
#  Background:Customer is in the login page
#    Given Customer is on the login page
#    When Login to GMI Bank as customer
#    Then Click My Operations icon on the top right corner of the page
#
#  @myAccounts
#  Scenario:User should see all account types and balance populated
#    Then Customer clicks My Accounts button
#
#
#  @transferMoney
#  Scenario:User can view transaction
#    Then Customer clicks Transfer Money and view transaction
#
