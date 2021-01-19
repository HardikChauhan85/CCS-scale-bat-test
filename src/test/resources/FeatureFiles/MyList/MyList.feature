Feature: This User story covers the List Management related scenarios

  @testE2E1
  Scenario: TC-TBD_Verify the buyer can add a product to the basket from the My list page and buyer is redirected to the basket page and
	message Product added to your basket is displayed once product is added successfully 
	already in the basket.
		And User navigates to BuyerUI
		And User login to buyerUI
		And User clicks on "Basket Link" in buyers UI
		And User clears the basket
		And User clicks on "My Account link" in buyers UI
		And User clicks on My List Visit button
		#And User clears the Mylist
		#And User reads the "supplier" details
		And User validates the products detail in My List page
		And User Clicks on AddToBasket button of the selected product on My List page
		And User validates the product message Product added to your basket
		And User Validated the product details on basket page
		
		
  @testE2E2
  Scenario: TC-TBD_Verify Buyer can add a product after clicking Clear my basket and add these items button in the My list page clears the basket 
	and add all products in the My list page to the basket and it DOES NOT delete products from the wish list.
		
		And User navigates to BuyerUI
		And User login to buyerUI
		And User clicks on "Basket Link" in buyers UI
		And User clears the basket
		And User clicks on "My Account link" in buyers UI
		And User clicks on My List Visit button
		#And User clears the Mylist
		#And User reads the "supplier" details
		And User validates the products detail in My List page
		And User Clicks on Clear my basket and add these items button
		And User validates the product message All products were added to your basket
		And User Validated the product details on basket page
		
		
		@testE2E3
  	Scenario: TC-TBD_Verify after clicking Add these items to current basket button in My list page DOES NOT deletes and clear the basket before adding wish list items to basket.
		
		And User navigates to BuyerUI
		And User login to buyerUI
		And User clicks on "Basket Link" in buyers UI
		And User clears the basket
		And User clicks on "My Account link" in buyers UI
		And User clicks on My List Visit button
		#And User clears the Mylist
		#And User reads the "supplier" details
		And User validates the products detail in My List page
		And User Clicks on Add these items to current basket button
		And User validates the product message All products were added to your basket
		And User Validated the product details on basket page
		
		
		
		@testE2E4
  	Scenario: TC-TBD_Verify Buyer can add all products after clicking Clear my basket and add these items button in the My list page clears the basket 
		and add all products in the My list page to the basket and it DOES NOT delete products from the wish list.
		
		And User navigates to BuyerUI
		And User login to buyerUI
		And User clicks on "Basket Link" in buyers UI
		And User clears the basket
		And User clicks on "My Account link" in buyers UI
		And User clicks on My List Visit button
		#And User clears the Mylist
		#And User reads the "supplier" details
		And User Validates the more than one products details in My List page
		And User Clicks on Add these items to current basket button
		And User validates the product message All products were added to your basket
		And User Validated the more than one products details on basket page
		
		#And User clicks on "My Account link" in buyers UI
		#And User clicks on My List Visit button
		#And User Validates the more than one products details in My List page
		
		
	@testE2E5
  Scenario: TC-TBD_ify a warning Message You cannot add the selected product to the basket Its out of stock is displayed on the My list page 
	if buyers tries to add a product which is out of stock.
	already in the basket.
		And User navigates to BuyerUI
		And User login to buyerUI
		And User clicks on "Basket Link" in buyers UI
		And User clears the basket
		And User clicks on "My Account link" in buyers UI
		And User clicks on My List Visit button
		#And User clears the Mylist
		#And User reads the "supplier" details
		And User validates the products detail in My List page
		#And User update the stock of the product to zero
		And User Clicks on AddToBasket button of the selected product on My List page
		And User validates the product message You cannot add the selected product to the basket Its out of stock
		
		
		