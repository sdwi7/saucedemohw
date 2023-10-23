@login
Feature: Login Feature

  Scenario Outline: Valid Login
    Given I am on the login page
    When I enter username <username> and password <password>
    And I click the login button
    Then I should be on the products page
    Examples:
      | username        | password       |
      | "standard_user" | "secret_sauce" |

  Scenario Outline: Invalid Login
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should see an error message
    Examples:
      | username | password     |
      | statuses | secret_sauce |



