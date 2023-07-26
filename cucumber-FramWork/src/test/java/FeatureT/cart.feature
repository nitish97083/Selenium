Feature: Mobile Cart

  Scenario Outline: Add to Cart
    Given Driver and system setup
    And  Navigate to Login page Url "http://live.techpanda.org/"
    When click on Mobile link
    And click on add to cart of the "<mobile>" from the list
    Then Update cart  qty and verify updated qty or error
    And  Empty the cart qty and verify cart should be empty
    Examples:
      | mobile |
      | SONY  |