@Scenario_4
Feature: Product sequence validation
  @tag1
  Scenario: Add few product in the cart and validate sequence in the cart respectively
  	Given I have browser opened and url is navigated and validate the title
  	When  I Enter product as "Samsung Mobile" in serachbox 
  	And I add few product in the cart 
 		Then I validate the cart for sequence of the product 
    