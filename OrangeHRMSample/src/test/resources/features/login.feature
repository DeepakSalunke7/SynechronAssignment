Feature: Login to Orange HRM

  Background: Open a browser and user is on Login Page
    Given Open a browser
    And Navigates to Login Page

  Scenario: User login with valid credential
    When User entered admin username as "Admin" and password as "admin123"
    And User clicked on Login Button
    Then Login is successful

  Scenario Outline: User login with invalid credential
    When User entered username as <username> and password as <password>
    And User clicked on Login button
    Then Login failed

    Examples: 
      | username | password |
      | Admin    | admin125 |
      | Shiv     | admin123 |
      | cnlle09  | lkksiek  |
