@filter
Feature: Filter Products

  Scenario: Filter Products by Price: Low to High
    Given I am on the login page
    When I enter username "standard_user" and password "secret_sauce" and log in
    And I should be logged in and in the product page
    When I apply a filter for "Price: Low to High"
    Then I should see the filtered products list
