Feature: As an End User,
  I MUST be able to select a product to view it's product details (product details TBC), 
  So that I can decide, based on the detail if the product meets my needs

  @confidence
  Scenario: TC-1035_Verify that User is able to view product details on cliking image or text from PLP
  Given User navigates to BuyerUI
  #And Authorisation dialoxg box is handled
  And User login to buyerUI
  When User navigates to PLP of buyers UI
  And User clicks on "PLP image" in buyers UI
  Then "PDP" is shown to the buyer
  
  @confidence
  Scenario: TC-1036_Verify that User should be able to return to PLP after viewing the product details
  Given User navigates to BuyerUI
  #And Authorisation dialoxg box is handled
  And User login to buyerUI
  When User navigates to PLP of buyers UI
  And User clicks on "PLP image" in buyers UI
  Then "PDP" is shown to the buyer
  And User clicks on "browser back button" in buyers UI
  And "PLP" is shown to the buyer
  
  @confidence
  Scenario: TC-1037_Verify that User should be able to navigate to the Basket
  Given User navigates to BuyerUI
  #And Authorisation dialoxg box is handled
  And User login to buyerUI
  When User navigates to PLP of buyers UI
  And User clicks on "Basket Link" in buyers UI
  Then "Basket" is shown to the buyer
  
  @confidence
  Scenario: TC-1038_Verify that User is able to view product details on cliking image or text from confirmation page
    Given User navigates to BuyerUI
    #And Authorisation dialoxg box is handled
    And User login to buyerUI
    When User navigates to PLP of buyers UI
    And User clicks on "Add to basket" in buyers UI
