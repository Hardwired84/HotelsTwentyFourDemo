Feature: Google search testing

  Background:
    Given I open Google Search page

  Scenario Outline: Google Search page results testing
    Given I search "<searched_text>"
    Then I check the search results page is "opened"
    Then I check the list of searched items is more then "8"
    Then I check the list of searched items contains "<searched_string>"
    Then I check the searched items count is more then "<count>"
    Examples:
      | searched_text | searched_string        | count    |
      | automation    | Automation - Wikipedia | 10000000 |

