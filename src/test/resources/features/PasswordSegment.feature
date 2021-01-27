@User_US08
#noinspection CucumberUndefinedStep
Feature:Password segment on homepage should be editable

  Scenario Outline: Password Segment should be editable
    Given User is on the GMIBank page
    Then user should click on user Icon
    Then user enter "<username>" and "<password>" and click sign in button
    And user navigates to userIcon and click to select Password dropdown
    Then user is on the password page
    And user click on current password inputBox and enter current "<password>"
    Then user click on newPassword inputBox and enter "<newPassword>"
    And user click on new password confirmation inputBox and enter "<newPassword>" again
    Then user clicks on Save button and see password change message
    Examples:
      |username|password|newPassword|
      |testname1|Password1*|Password1*|


    #TC_002_There should be at least 1 lowercase char and see the level chart change accordingly
  Scenario: Password include at least one lowercase
    Then User deletes new password field
    Then User see password strength color turn red and Your Password required message


     #TC_003_There should be at least 1 uppercase char and see the level chart change accordingly
  Scenario: Password include at least one upper
    When User  enter six lowercase char and one uppercase char
    Then User see password strength color turn orange

     #TC_004_There should be at least 1 digit and see the level chart change accordingly
  Scenario: Password include at least one digit
    When User  enter six lowercase char and one uppercase char and one digit
    Then User see password strength color turn four level green

    #TC_005_TC_006_There should be at least 1 special char and see the level bar change accordingly
  Scenario: Password include at least one special char
    When User  enter six lowercase char and one uppercase char and 1 digit and 1 special char
    Then User see password strength color turn five level green

    #TC_007_The new password should be confirmed

  Scenario: New password should be confirmed
    Given User click on save button
    Then user should see success message



