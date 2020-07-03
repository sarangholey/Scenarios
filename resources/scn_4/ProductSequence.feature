
@tag4
Feature: Product sequence validation

  Scenario: User should be able to get the sequence of products according to their adding sequence
   Given I have browser opened and url is navigated
    And I have 3 products added in the cart	 
    Then I validate the sequence of product is same as like they added in the cart
  
