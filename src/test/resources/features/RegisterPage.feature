@register @regression

  Feature: Test Store - Register page

    Background:
      Given I can access to test store register page


    Scenario: Validate successful account creation
      And I click on Mr radio option
      And I enter a specific firstname "TestingCR"
      And I enter a specific lastname "Bugs"
      And I enter a random email
      And I enter a specific password "bestPassword"
      And I enter a specific birthday "12/12/1970"
      And I left offers and newsletter empty
      And I click on terms and conditions checkbox
      And I click on the save button
      Then I should be able to see the name "TestingCR Bugs" logged