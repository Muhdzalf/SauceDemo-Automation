@All
  Feature: Checkout

    Scenario: User can see product in the cart
      Given User access Swag Labs Login page
      When User input valid username
      And User input valid password
      And User click login button
      And User select light bike product
      And User click add to cart button
      And User click cart icon
      Then User redirected to cart page
      And User can see the light bike product in the cart