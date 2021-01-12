Feature: homepge

  Scenario: browser is open
    Given user is on home page
    When click on the searchbox
    And send keys
    Then navigate to next page1

  Scenario: list is displayed
    Given click on dropDown 
    When select the highest Price
    Then displays all the props decending from highest price

  Scenario: validate
    Given property info is open
    When select the fifth prop and click
    When opened the next page
    Then validate the agent
