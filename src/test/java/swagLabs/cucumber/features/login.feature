@All
Feature: Login to the Swag Labs website

  @Regression
  Scenario: User success Login with valid credentials
    Given User access Swag Labs Login page
    When User input valid username
    And User input valid password
    And User click login button
    Then User redirected to Swag Labs home page website

  @Regression
  Scenario: User failed Login
    Given User access Swag Labs Login page
    When User input valid username
    And User input invalid password
    And User click login button
    Then User get error message
    And User still at login page
