Feature: xxxLutz challenge



  @web @chrome @xxxLutz
  Scenario Outline: I check I can  enter in all the elements of the category
    Given I enter in the app with sweden language
    And I accept cookie
    When I select the <position> category
    Then I check I can click in the first Button

    Examples:

    |position            |
    |Soffor              |
    |Mediaforvaring      |
    |Mediamobler         |
    |Vardagsrumsbord     |
    |Vardagsrumsforvaring|
    |Smamobler           |
    |Hyllor              |
    |Rumsavdelare        |








