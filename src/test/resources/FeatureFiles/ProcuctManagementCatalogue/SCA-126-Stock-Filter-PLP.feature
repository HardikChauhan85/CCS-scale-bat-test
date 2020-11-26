Feature: As a Supplier,
  I MUST be able to show which of my products are unavailable for a buyer to place an order, 
  So that a buyer knows I do sell that particular product but that it's unavailable at the moment

  @a
  Scenario: TC-906-905_Verify that users are able to filter in-stock products using filter
    Given User navigates to BuyerUI
    And User login to buyerUI
    And User navigates to PLP of buyers UI
    When User filters the catalogue by checking the "In stock only" check box
    Then User should be able to view in stock products only

  @a
  Scenario: TC-908-907_Verify that product is shown as out-of stock on PLP only if the product is out of stock for all suppliers
    Given User navigates to BuyerUI
    And User login to buyerUI
    And User navigates to PLP of buyers UI
    When User filters the catalogue by checking the "out of stock only" check box
    Then User should be able to view out of stock products only
