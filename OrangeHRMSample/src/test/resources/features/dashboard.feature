Feature: Base page button works at the home page

  Scenario: Ensure Dashboard page buttons works
    When User entered admin username as "Admin" and password as "admin123"
    And User clicked on Login Button
    Then all the button works at the dashboard page
    Then user is logout