@Login
Feature: Login with admin user

@Login
  Scenario: Login
    Given I open the aplication
    When I put the user "admin"
    And I put the password "1234"
    When I click in the button Enviar
    Then I validate the home page
