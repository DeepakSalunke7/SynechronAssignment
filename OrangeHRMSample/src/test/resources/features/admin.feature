Feature: Search records for Admin or ESS

  Scenario: Create Admin with all details
    And Ensure application is opened
    When User entered admin username as "Admin" and password as "admin123"
    And User clicked on Login Button
    And User click employee tab
    Then User click on add button
    And User enter following details
      | User Role | Employee Name | Status  | Username | Password          | Confirm Passsword |
      | Admin     | Lisa  Andrews | Enabled | Deepak   | deepak1@gmail.com | deepak1@gmail.com |
    And User click on save button
