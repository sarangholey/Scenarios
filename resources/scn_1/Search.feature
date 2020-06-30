
@tag1
Feature: Price validation

  Scenario: User should be able to search the product and print sum of all the prices present on the first page
    Given I have browser opened and url is navigated
    And I search for the product as "OnePlus"
    When I fetch all the prices from the first page
    Then I print sum of all the prices on the console
