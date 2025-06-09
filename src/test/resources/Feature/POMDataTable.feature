@tags
Feature: Testing the DataTable with POM

  @Tag1
  Scenario Outline: Testing the login with scenario outline
    Given Navigate to the midoc Website
    Then Entering the "<email>" and "<pass>" in the login page
    Then Check the current URL

    Examples:
      | email           | pass     |
      | zampa@gmail.com | midoc123 |

  @Tag2
  Scenario: Testing the login with DataTable
    Given Navigate to the midoc Website
    Then Entering the following credentials in the login page
      | email           | pass     |
      | zampa@gmail.com | midoc123 |
    Then Check the current URL
