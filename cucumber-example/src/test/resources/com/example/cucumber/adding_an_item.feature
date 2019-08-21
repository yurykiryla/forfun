Feature: Adding an item to order
  I want to be able to add an item to a current order.
  
  Background:
    Given I have not yet ordered anything

  Scenario: Adding an item to an empty order
    When I go to the "Burgers" category
    And I select a "Cheeseburger"
    Then I have a new order
    And the order has 1 item in it

  Scenario Outline: Price of a single item order
    When I go to the "<category>" category
    And I select <item>
    Then my current order total is <price>

    Examples: 
      | category   | item                 | price |
      | Sandwiches | a "Chicken Sandwich" | 9     |
      | Dessert    | an "Oreo Cheesecake" | 7     |