Feature: Login to Orange HRM

  Background: User is in the Login Page
    Given User is in the Login Page
    And User clicked on Login Button

  Scenario: Admin login with valid credential
    When User entered admin username as "Admin" and password as "admin123"
    Then Login is successful

  Scenario Outline: Login to the Application Successfully
    When User entered username as <username> and password as <password>
    Then Login failed

    Examples: 
      | username | password |
      | Admin    | admin125 |
      | Shiv     | admin123 |
      | cnlle09  | lkksiek  |
