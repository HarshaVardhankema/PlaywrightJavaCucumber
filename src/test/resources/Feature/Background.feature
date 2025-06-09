Feature: Web navigation testing

  Background:
    Given I open the browser

  @Tag1
  Scenario: Youtube Video
    And I navigate to "https://www.youtube.com"
    And I search for "Samsung s24ultra"
    And I click on the first video
    And I should see the video playing

  @Tag2
  Scenario: Google Search
    And I navigate to "https://www.google.com"
    And I search for "iphone16promax"
    And I click on the first link
    And I should see the search results page
