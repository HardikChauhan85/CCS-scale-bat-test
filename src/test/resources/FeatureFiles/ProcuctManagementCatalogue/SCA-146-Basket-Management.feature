#User Story -146
Feature: If an End User is not logged in then they cannot add a product to the Basket

  @confidence
  Scenario: TC-693_Verify a Non logged in user is not able to view "Add to Basket" button for any product displayed in PLP and PDP of Buyers UI
    Given User navigates to BuyerUI
    #And Authorisation dialoxg box is handled
    When User navigates to PLP of buyers UI
    Then "Add to Basket" button should not be visible

  @confidence
  Scenario: TC-694_Verify a Non logged in user is not able view "Basket" link on top of PLP and PDP of Buyers UI.
    Given User navigates to BuyerUI
    #And Authorisation dialoxg box is handled
    When User navigates to PLP of buyers UI
    Then "Basket" button should not be visible
