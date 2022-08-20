Feature: Application Login
  Scenario: Positive Test Case
    Given Driver and system setup
    And Navigate to url "https://www.flipkart.com/"
    And cancel login popup
    And click on Login
    When User enter username "6290397034" password "Nitish@123"
    And Click on Submit
    Then Login Page Displayed and verify User profile "Nitish Kumar"
    And driver should be closed
