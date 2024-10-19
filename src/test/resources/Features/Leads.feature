@regression
Feature: lead functionality

  Background:
    Given user should be on login page
    When user enter valid credentials and click on login button

  @leads
  Scenario: TC04_CreateLead_with_mandatory_fields
    Given user should be on lead creation form
    When user enters the all mandatories fields and click on save button
    Then lead should be created successfully
    And close browser