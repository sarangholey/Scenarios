@tag
Feature: Scn_4


  @tag1
  Scenario: Validate add to cart product sequence
    Given I have browser open and url is navigated and validate the title
    When I add few product in cart
    Then Validate sequence of product is same
