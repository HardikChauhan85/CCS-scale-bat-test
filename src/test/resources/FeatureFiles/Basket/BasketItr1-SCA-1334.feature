Feature: This User story covers the My List related scenarios
 		
	#[US-1334 (TC01) (TC02)]
	@confidence
  Scenario: TC-TBD_Verify Buyer can add all products after clicking Clear my basket and add these items button in the My list page clears the basket and adds all products in the My list page to the basket New 
  Given user clears the basket
  And user gets all the available products list
  And identify products which needs to be add in the list.
  And get the products variant ids
  And user adds a product to basket
  #UI Steps
	And User navigates to BuyerUI
	And User login to buyerUI with API User
	And User clicks on "Basket Link" in buyers UI
  And User Validated a product details on basket page
  And User validates the default delivery option should be pre-populated as "Standard UK Mainland (3-5 days)"
  And User validates the Delivery method drop down options