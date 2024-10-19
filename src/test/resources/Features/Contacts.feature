Feature: contact functionality

  Background:
    Given user should be on login page
    When user enter valid credentials and click on login button

  @contact
  Scenario: TC05_CreateContact_with_mandatory_fields
    Given user should be on contact form
    When user enters the all required fields and click on save button
    Then contact should be created successfully
    And close browser