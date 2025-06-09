
@Tags("NegativeScenario")
Feature: NegativeScenario with Doctor Login

  @Tag1
  Scenario: Login with valid details
    Given Opening the application
    Then Login with valid details
    Then I should be redirected to the doctor home pages


    @Tag2
    Scenario: Login with valid credentials
      Given Opening the application
      Then Login with valid "zampa@gmail.com" and "123456"
      Then I should be redirected to the doctor home page