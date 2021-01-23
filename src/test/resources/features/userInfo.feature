#User info segment (User Settings) should be editable on Homepage
#TC_01 "There should be user info being populated
# when navigating to user info ""firstname, lastname email and language"""
@userInfo
Feature: Editable User Info Segment
  Agile Story: User info segment (User Settings) should be editable on Homepage
  @userInfo1
  Scenario: There should be user info being populated when navigating to user info
    Given User goes to login page
    When User provides username "Sunny" and password "Jsunny34*"
    And User logs in
    And User navigates and clicks on user info
    And User should see info being populated
  @userInfo2
#TC_02 There should be 2 languages available "English and Turkish"
  Scenario: There should be 2 languages available "English and Turkish"
    When User goes to the language dropdown and clicks on it
    And User chooses English
    And User chooses Turkish

#TC_03 There should be an option to update firstname
  Scenario:There should be an option to update firstname
    When User navigates and deletes the first name
    And User writes the new name "sunny" to update

#TC_04 There should be an option to update lastname
  Scenario:There should be an option to update lastname
    When User navigates and deletes the last name
    And User writes the new last name "sun" to update

#TC_05 There should be an option to update email id adding "@" sign and "." extension
  Scenario:There should be an option to update email
    When User navigates and deletes the email
    And User writes the new Email "jack@gmail.com" adding @ sign and . extension to update