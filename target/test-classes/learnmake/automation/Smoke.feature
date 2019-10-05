
Feature: Work in  progress ( NOT TO USE )

  @web @chrome @xxxLutz
  Scenario: I check one criteria element and then I remove that criteria filter
    Given I enter in the app with sweden language
    And I accept cookie
    When I check the the first element of article's list
    And I click the  show more criteria submenu
    And I click best price check box
    And I check if the first article has changed
    And I checkout first tag label.remove all
    Then I check if the first article is equal as no filters status







