Feature: This User story covers the My List related scenarios
	
	#[US-1802 (TC01)]
  @testE2E
  Scenario: TC-TBD_Verify the buyer can add a product to the basket from the My list page	New
  	#API Steps
  	Given user clears the basket
 		And user gets all the available products list
		And identify products which needs to be add in the list.
		And get the products variant ids 
		And user access the webservice of GetWishList
		And user adds a product to basket
		#And deletes the products from the WishList
		#UI Steps
		And User navigates to BuyerUI
		And User login to buyerUI with API User
		And User clicks on "Basket Link" in buyers UI
		And User Validated a product details on basket page
		And User clicks on "Clear basket" in buyers UI
		And User validates the message after Clear basket button clicked
		
			
	#[US-1802 (TC02)]
	@testE2E
  Scenario: TC-TBD_Verify Buyer can add all products after clicking Clear my basket and add these items button in the My list page clears the basket and adds all products in the My list page to the basket New 
  Given user clears the basket
  #UI Steps
	And User navigates to BuyerUI
	And User login to buyerUI with API User
	And User clicks on "Basket Link" in buyers UI
  And User validates the Clear basket button and 'Your basket is empty' message on basket page
  
  
  
  