@LoginPageObjects
Feature: Login with admin user

  @LoginPageObjects
  Scenario: Login
    Given I open the aplication url PG
    When I put the user "admin" PG
    And I put the password "1234" PG
    When I click in the button Enviar PG
    Then I validate the home page PG
