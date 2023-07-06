@login

  Feature: Test Store - Login page

    Background:
      Given I can access to test store login page

    Scenario: Validate successful login
      And I type a email "test.bd@gmail.com"
      And I type a password "12345678"
      And I click on sign in button
      Then I should be able to log in and see the home page

    Scenario: Validate unsuccessful login
      And I type a email "test123@mail.com"
      And I type a password "password123"
      And I click on sign in button
      Then I should be able to see the "Authentication failed." error message