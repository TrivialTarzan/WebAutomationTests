@saucedemo
Feature: Saucedemo.com ordering a product and proceeding to checkout

  @saucedemo
  Scenario: A user can log in, select a product and proceed to checkout
    Given User is on main page
    When User logs in using username: "problem_user" and password: "secret_sauce"
    When User adds to cart any product
    Then User sees "1" product is added to the cart and goes to the cart view page
    And User clicks on the cart and sees his product in the cart view page
    Then User proceeds to checkout and verifies the info: "Checkout: Your Information" and presence of three fields: First Name, Last Name and Postal Code
    And User goes back to the cart view page and removes the product from the cart
    And Closes the browser
