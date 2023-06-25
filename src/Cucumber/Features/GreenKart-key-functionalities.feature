
@green-kart
Feature: Testing key functionalities of the GreenKart website

  Background:
    Given I'm on the main page
    And my cart is empty

  @successful-purchase
  Scenario: Successful purchase
    When I click on my cart icon
    Then I see the message: "You cart is empty!"
    And the proceed to checkout button is disabled

    When I search for "walnuts"
    Then I'm on the product page
    And I see product's name: "walnuts" and price: "170"
    And I select the desired quantity: "20"
    Then I add the product to my cart

    When I return to the main page
    And I look for "musk melon"
    Then I'm on the product page
    And I see the product name: "musk melon"
    And I choose the desired quantity: "16"
    And I add the product to the cart

    When I click on my cart and proceed to checkout
    Then I see the chosen products: "Walnuts" and "Musk Melon" displayed on the screen
    And the expected price of products: "3652" matches the total price

    When I place order
    And I choose country for the delivery: "Vietnam"
    When I don't accept the T&M checkbox and click on Proceed button, I see the message: "Please accept Terms & Conditions - Required"
    Then I accept T&M checkbox and click on Proceed button

    Then I successfully placed my order and I am redirected to the main page

    Then I close the browser
