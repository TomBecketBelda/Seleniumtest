Feature: Tinder trap



  @web @chrome @Tinder
  Scenario Outline: I want to try tinder
    Given I enter in the app and  register with facebook
    When I write <email> and <password>
    And  I accept geolocalization
    Then I press I like Button



    Examples:

    |email                 |password  |
    |tomasbecket@gmail.com | Tbelda78*|






