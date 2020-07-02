
@tag
Feature: Scn_3

 @tag1
  Scenario: Validate product price according to the apply filter
    Given I have browser open and url is navigated and validate the title
    When I Search for product as "samsung mobiles" and also validate the searchbox is visible or not
    And Apply filter with min price as "10000" and max price as "30000"
    Then Validate min and max price dropdown is visible or not also fetch Highest and Lowest price commodity from list with their name.
 