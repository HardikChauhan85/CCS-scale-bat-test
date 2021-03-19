Feature: This User story covers the My List related scenarios
	
	#[US-161 (TC01)]
 	@confidence
  Scenario: TC-TBD_Verify the buyer can add a product to the basket from the My list page	New
  	#API Steps
  	Given user access the webservice of GetWishList
  	And deletes the products from the WishList
  	And user clears the basket
 		And user gets all the available products list
		And identify products which needs to be add in the list.
		And get the products variant ids 
		And user access the webservice of GetWishList  
		And user add the WishList
		#And deletes the products from the WishList
		#UI Steps
		And User navigates to BuyerUI
		And User login to buyerUI with API User
		And User clicks on "My Account link" in buyers UI
		And User clicks on My List Visit button
		And User Clicks on AddToBasket button of the selected product on My List page
		And User validates the product message Product added to your basket
		#And User Validated the product details on basket page
		And User Validated a product details on basket page
		
				 		
	#[US-161 (TC06)]
	@confidence
  Scenario: TC-TBD_Verify Buyer can add all products after clicking Clear my basket and add these items button in the My list page clears the basket and adds all products in the My list page to the basket New 
  Given user clears the basket
  And user gets all the available products list
  And identify products which needs to be add in the list.
  And get the products variant ids
  And user adds a product to basket
  And user access the webservice of GetWishList
  And deletes the products from the WishList
  And user gets the multile products varient ids
  And user access the webservice of GetWishList
  And user adds the multiple products to WishList
  #UI Steps
	And User navigates to BuyerUI
	And User login to buyerUI with API User
	And User clicks on "Basket Link" in buyers UI
  And User Validated a product details on basket page
  And User clicks on "My Account link" in buyers UI
	And User clicks on My List Visit button
  And User Clicks on Clear my basket and add these items button
  And User validates the product message All products were added to your basket
  And User Validated multiple products details on basket page
  
  
  #[US-161 (TC08)(TC07)]
	@confidence
  Scenario: TC-TBD_Verify after clicking Add these items to current basket button in My list page DOES NOT deletes and clear the basket before adding wish list items to basket New
  Given user clears the basket
  And user gets all the available products list
  And identify products which needs to be add in the list.
  And get the products variant ids
  And user adds a product to basket
  And user access the webservice of GetWishList
  And deletes the products from the WishList
  And user gets the multile products varient ids
  And user access the webservice of GetWishList
  And user adds the multiple products to WishList
  #UI Steps
	And User navigates to BuyerUI
	And User login to buyerUI with API User
	And User clicks on "Basket Link" in buyers UI
  And User Validated a product details on basket page
  And User clicks on "My Account link" in buyers UI
	And User clicks on My List Visit button
  And User Clicks on Add these items to current basket button
  And User validates the product message All products were added to your basket
  And User Validates products details after clicking on Add these items to current basket button
  
  #[US-161 (TC02)(TC03)(TC05)(TC09)(TC10)]
  @confidence
  Scenario: TC-Verify Buyer can search for a product using Search bar on PLP & should be able to add the product to the My List page from PDP
 	 #API Steps
    And user clears the basket
    And user access the webservice of GetWishList
    And deletes the products from the WishList
 	 #UI Steps
  	Given User logged in as "supplier" in admin panel
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    And Check if the product is present in a catalogue if yes then delete
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    When User creates a product
    And User navigates to BuyerUI
  	And User login to buyerUI with API User
    #And User login to buyerUI
    When User search a product with SKU number
    And User clicks on "PLP image" in buyers UI
    And User clicks on "Add to list" in buyers UI
    And User clicks on "View list" in buyers UI
    And User validates the products details on Mylist page
    And User Clicks on AddToBasket button of the selected product on My List page
		And User validates the product message Product added to your basket
		And User clicks on "My Account link" in buyers UI
		And User clicks on "My list visit button" in buyers UI
		And User Clicks on AddToBasket button of the selected product on My List page
		And User validates the product message Product added to your basket
		And User validates the product quantity on basket page
		And User clicks on "My Account link" in buyers UI
		And User clicks on "My list visit button" in buyers UI
		And User validates the products details on Mylist page
		And User upadates the product quantity more than available stock of the product
		And User validates the warning message "Unable to supply" items
		And User Clicks on AddToBasket button of the selected product on My List page
		And User validates the error message when product has exceed the number of units in stock for the product
		And User clicks on "My list delete button" in buyers UI
    
  
  #[US-161 (TC09)]
	@confidence
  Scenario: TC-Verify Buyer can search for a product using Search bar on PLP & should be able to add the product to the My List page from comparison page
    #API Steps
    And user clears the basket
    And user access the webservice of GetWishList
    And deletes the products from the WishList
 	  #UI Steps
  	Given User logged in as "supplier" in admin panel
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    And Check if the product is present in a catalogue if yes then delete
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    When User creates a product
    #UI Steps
  	And User navigates to BuyerUI
  	And User login to buyerUI with API User
    #And User login to buyerUI
    When User search a product with SKU number
    And User clicks on "Compare button" in buyers UI
    And User clicks on "Add to list Compare Page" in buyers UI
    And User clicks on "View list" in buyers UI
    And User validates the products details on Mylist page
    And User clicks on "back link" in buyers UI
    And User clicks on "back link" in buyers UI
    And User clicks on "Romove link" in buyers UI
		
		
		