Feature: Basic Searching
  As a web surfer,
  I want to search using different search engines.

  @web @chrome @google
  Scenario: Simple search with Google
    Given a web browser is on the search engine page
    When the search phrase "aristophanes" is entered
    Then results for "aristophanes" are shown
    And  I write a text

