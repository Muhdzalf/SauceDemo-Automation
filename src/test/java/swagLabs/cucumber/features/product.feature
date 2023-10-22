@All
Feature: Product
  Scenario: User can see detail product
    Given User access Swag Labs Login page
    When User input valid username
    And User input valid password
    And User click login button
    Then User at product page
    And User click product
    Then User redirected to product detail page
    And User can see product detail

  @Regression
  Scenario: User can add product
    Given User access Swag Labs Login page
    When User input valid username
    And User input valid password
    And User click login button
    And User select light bike product
    And User click add to cart button
    Then product added to cart
    And User can see number icon at card logo

  @Regression
  Scenario: User remove product from cart
    Given User access Swag Labs Login page
    When User input valid username
    And User input valid password
    And User click login button
    And User select light bike product
    And User click add to cart button
    And User click remove button
    Then Product removed from cart
    And Number icon removed from cart

  @Regression
  Scenario: User cannot add product twice
    Given User access Swag Labs Login page
    When User input valid username
    And User input valid password
    And User click login button
    And User select light bike product
    And User click add to cart button
    Then Button add to cart changed to remove
