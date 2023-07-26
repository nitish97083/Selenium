Feature: Mobile Page

  //Background:

  Scenario Outline: Verify the price of the mobile
    Given Driver and system setup
    And  Navigate to Login page Url "http://live.techpanda.org/"
    When click on Mobile link
    Then store the cost of <mobile> from the list
    And click on image
    And store the cost of from the details page
    And  compare the list and details page price for the mobile

    Examples:
      | mobile |
      | "SONY" |
#      | "IPHONE"|
#      |"SAMSUNG"|


