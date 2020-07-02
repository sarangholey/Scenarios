
@tag
Feature: Scn_2

  @tag1
  Scenario: Validate quick suggestion Dropdown
    Given I have browser open and url is navigated and validate the title
    When Enter the product name "Philips" in SearchBox and also validate the searchbox is visible or not
    Then Print and validate the keyword "philips" coming in the quick suggestion drop down.

