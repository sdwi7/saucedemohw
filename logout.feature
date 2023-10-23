@logout
Feature: Logout Functionality

  Scenario: User can log out successfully
    Given I am on the login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be on the products page
    When I click on the menu bar
    And I click logout button
    Then I should be logged out
