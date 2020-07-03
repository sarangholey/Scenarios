@tag
Feature: Product Sequnce Validation
  I want to use this template for amazone product sequnce validation

  @tag1
  Scenario: Product sequnce Validation
    Given I have browser opened and url is navigated to "https://www.amazon.in/" and validate titleeeee
    When I Add any three products in cart
    Then I validate whether sequnce of product is same as like they added in cart.
    