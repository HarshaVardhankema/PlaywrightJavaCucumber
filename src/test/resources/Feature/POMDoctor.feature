Feature: Doctor Login

  Scenario: Login with valid credentials
    Given Opening the application
    Then Login with valid credentials
    Then I should be redirected to the doctor home page