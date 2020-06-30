
@tag
Feature: Scn_1

  @tag1
  Scenario: User should be able to fetch all prices of product available on page and able to make total of it
    Given I have browser open and url is navigated and validate the title
    When I Search for product as "oneplus" and also validate the searchbox is visible or not
    Then I Fetch all the prices from the first page and make total of all prices and print it on console window


 