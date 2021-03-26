Feature: This User story covers the My List related scenarios
 		
	#[US-1334 (TC01) (TC02) (TC04)]
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
  And User validates the Delivery method drop down options
  #And User validates the default delivery option should be pre-populated as "Standard UK Mainland (3-5 days)"
  And User select the Delivery option "Next Business Day (Orders after Midday)"
  And User clicks on "Clear basket" in buyers UI
	And User validates the message after Clear basket button clicked
	And User clicks on "My Account link" in buyers UI
  #API Steps
  Given user clears the basket
  And user gets all the available products list
  And identify products which needs to be add in the list.
  And get the products variant ids
  And user adds a product to basket
  And User clicks on "Basket Link" in buyers UI
  And User validates the default delivery option should be pre-populated as "Standard UK Mainland (3-5 days)"
  
  
  
  #[US-1334 (TC03)]
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
  #And User validates the Delivery method drop down options
  #And User validates the default delivery option should be pre-populated as "Standard UK Mainland (3-5 days)"
  And User select the Delivery option "Next Business Day (Orders after Midday)"
  And User clicks on "My Account link" in buyers UI
  #API Steps
  And user gets all the available products list
  And identify products which needs to be add in the list.
  And get the products variant ids
  And user adds a product to basket
  #UI Steps
  And User clicks on "Basket Link" in buyers UI
  And User validates the default delivery option should be pre-populated as "Next Business Day (Orders after Midday)"
  And User select the Delivery option "Standard UK Non Mainland (3-5 days)"
  And User clicks on "My Account link" in buyers UI
  #API Steps
  And user gets all the available products list
  And identify products which needs to be add in the list.
  And get the products variant ids
  And user adds a product to basket
  #UI Steps
  And User clicks on "Basket Link" in buyers UI
  And User validates the default delivery option should be pre-populated as "Standard UK Non Mainland (3-5 days)"
  And User select the Delivery option "Standard UK Mainland (3-5 days)"
  And User clicks on "My Account link" in buyers UI
  #API Steps
  And user gets all the available products list
  And identify products which needs to be add in the list.
  And get the products variant ids
  And user adds a product to basket
  #UI Steps
  And User clicks on "Basket Link" in buyers UI
  And User validates the default delivery option should be pre-populated as "Standard UK Mainland (3-5 days)"
 
  
  
  
   