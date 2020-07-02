
@tag3
Feature: Filter product within minimum and maximum price 

  Scenario: User should be able to select product within minimum and maximum range 
    Given I have browser opened and url is navigated
    And I search for the product as "samsung mobiles"
    When I select minimum and maximum price range from the filters dropdown
    Then I print one lowest and highest price product from the updated product list 