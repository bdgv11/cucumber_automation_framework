@product

Feature: Test Store - product page

  Background:
    Given I can access to store home page

  Scenario: Validate that women clothes sub-category has products available
    When I click to women clothes sub category
    Then I should be presented with at least one available listed product

  Scenario Outline: Validate that selecting available filters those will be shown in tags within active filters
    When I click to men clothes sub category
    And I select <size> size filter
    And I select <color> color filter
    Then I should be presented with <sizeFilterExpected> size filter and <sizeFilterExpected> color filter

    Examples:
      | size | color | sizeFilterExpected | sizeFilterExpected |
      | S    | White | Size: S            | Color: White       |
      | M    | Black | Size: M            | Color: Black       |
      | L    | White | Size: L            | Color: White       |
      | XL   | Black | Size: XL           | Color: Black       |

  Scenario Outline: Validate that women product is able to add to cart via quick view
    When I click to women clothes sub category
    And I select the quick view on first produc listed
    And I select <size> size option on quick view
    And I select <quantity> quantity option on quick view
    And I click on add to cart button
    Then I should be presented with the correct <sizeExpected> size, <quantityExpected> quantity and <successfulAddedMessage> message

    Examples:
      | size | quantity | sizeExpected | quantityExpected | successfulAddedMessage                           |
      | S    | 3        | S            | 3                | Product successfully added to your shopping cart |
      | M    | 2        | M            | 2                | Product successfully added to your shopping cart |
      | L    | 1        | L            | 1                | Product successfully added to your shopping cart |
      | XL   | 4        | XL           | 4                | Product successfully added to your shopping cart |


  Scenario: Validate that sorting by `Name, A to Z` the Stationery products are displayed correctly
    When I click to stationery accessories sub category
    And I choose the sort by option "Name, A to Z"
    Then I should be presented with the products listed sorted alphabetically

  Scenario: Validate that applying some Home Accessories filters reduce products quantity and after clear them they back to started quantity
    When I click to home accessories sub category
    And I click on black filter
    And I remove the filter selected
    Then I should be presented with the original products quantity

  Scenario: Validate that adding a more than 1 quantity product from Art category it'll show the correct final price on pre-checkout view
    When I click to art category
    And I select the first listed product
    And I change the quantity to 4
    And I clcik on add to cart button
    Then I should be presented with the correct quantity and price information

  Scenario: Validate that adding a more than 1 quantity product from Art category it'll show the correct final price on cart page
    When I click to art category
    And I select the first listed product
    And I change the quantity to 4
    And I clcik on add to cart button
    And I close the details information
    And I click to shopping cart button
    Then I should be presented with the correct quantity and price information

  Scenario: Validate successful product checkout
    When I click to art category
    And I select the first listed product
    And I change the quantity to 4
    And I clcik on add to cart button
    And I close the details information
    And I click to shopping cart button
    And I click on proceed to checkout button
    And I fill the personal information correctly and continue
    And I fill the address information and continue
    And I click on my carrier shipping method option and continue
    And I select the pay by check payment option
    And I click on agree to terms of service checkbox
    And I click on order with an obligation to pay button
    Then I should be able to see the confirmation message and order details correctly






