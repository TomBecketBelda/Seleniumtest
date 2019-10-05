Feature: xxxLutz challenge


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

     #Tthis scenario should works perfectly


  @web @chrome @xxxLutz
  Scenario Outline: I check I can enter in all the elements of the category menu and I click one of them
    Given I enter in the app with sweden language
    And I accept cookie
    When I select the <values> category
    Then I check I can click in the first Button of the subcategory

    Examples:

      |values              |
      |Soffor              |
      |Mediaforvaring      |
      |Mediamobler         |
      |Vardagsrumsbord     |
      |Vardagsrumsforvaring|
      |Smamobler           |
      |Hyllor              |
      |Rumsavdelare        |

    # The last scenario fails because maybe there is a bug.That category Rumsavdelare doesn't follow the patterns of the other

  @web @chrome @xxxLutz
  Scenario Outline: I check if the breadcrumbs returns to the same category page
    Given I enter in the app with sweden language
    And I accept cookie
    And I check the category page values
    When I select the <values> category
    And  I return to category from the submenu
    Then I check if the values of the categorypage have changed

    Examples:

      |values              |
      |Soffor              |
      |Mediaforvaring      |
      |Mediamobler         |
      |Vardagsrumsbord     |
      |Vardagsrumsforvaring|
      |Smamobler           |
      |Hyllor              |
      |Rumsavdelare        |

    # This scenario fails because there is bug. When you go back from the subcategory, you don't return to the previous page









