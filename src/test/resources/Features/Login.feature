@regression
Feature: Login functionality

Background:
  Given user should be on login page
@login
Scenario: TC01_Valid_Login
  When user enter valid credentials and click on login button
  Then user should be navigated to home page
  And close browser


Scenario: TC02_InValid_Login
  When user enter invalid credentials and click on login button
  Then user should be navigated to login page
  And user can see the error message
  And close browser

@rajnikant
Scenario Outline: TC03_InValid_Login_Parameterized
  When user enter userid as "<userid>" and password as "<password>" and click on login button
  Then user should be navigated to login page
  And user can see the error message
  And close browser
Examples:
  |userid | password|
  |ad1    | pwd1    |
  |ad2    | pwd2    |
  |ad3    | pwd3    |


