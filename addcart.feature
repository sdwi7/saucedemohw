@addcart
Feature: Adding Product to Cart

  Scenario: User can add a product to the cart
    Given I am already logged in to my account with username "standard_user" and password "secret_sauce"
    When I select a product with the name "Sauce Labs Backpack"
    And I add it to the cart
    Then The product "Sauce Labs Backpack" should be visible in the cart
