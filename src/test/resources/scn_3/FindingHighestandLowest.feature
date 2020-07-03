Feature: find Highest and Lowest price
  I want to use this template to find Highest and Lowest price

  @Stringtag1
  Scenario: Title of your scenario
    Given I have browser opened and url is navigated to "https://www.flipkart.com/" and validate titleee
    When I Enter product Name "Samsung Mobiles" in SearchBox and validate search box is visiblee
    And  I Select Min Price "1000" and max price "30000" from price filter dropdown in left side, also validate min and max price dropdown is visible .
    Then I fetch and print one lowest and one highest price commdity from the list on console with their respective names.
  
