@login @regression

Feature: Test Store - Login page

  Background:
    Given I can access to test store login page

  Scenario: Validate successful login
    And I type a email "test.bd@gmail.com"
    And I type a password "12345678"
    And I click on sign in button
    Then I should be able to log in and see the name logged "Bryan Test"

  Scenario: Validate unsuccessful login
    And I type a email "test123@mail.com"
    And I type a password "password123"
    And I click on sign in button
    Then I should be able to see the "Authentication failed." error message

  @login-smoke
  Scenario Outline: Validate error messages on email text field
    And I enter a email <email>
    And I enter a password <password>
    And I click on sign in button
    Then I should be presented with the following email validation messages <loginExpectedMessage>

    Examples:

      | email | password | loginExpectedMessage                                                                                      |
      | email | test1234 | Incluye un signo "@" en la dirección de correo electrónico. La dirección "email" no incluye el signo "@". |
      |       | abc123   | Completa este campo                                                                                       |
      |       |          | Completa este campo                                                                                       |

  @login-smoke
  Scenario Outline: Validate error messages on email password field
    And I enter a email <email>
    And I enter a password <password>
    And I click on sign in button
    Then I should be presented with the following password validation messages <loginExpectedMessage>

    Examples:

      | email         | password | loginExpectedMessage                 |
      | test@test.com | 12as     | Haz coincidir el formato solicitado. |
      | test@test.com |          | Completa este campo                  |
