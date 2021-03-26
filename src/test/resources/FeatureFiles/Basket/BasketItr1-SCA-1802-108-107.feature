Feature: This User story covers the My List related scenarios
	
	#[US-1802 (TC01)]
  @confidence
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
	@confidence
  Scenario: TC-TBD_Verify Buyer can add all products after clicking Clear my basket and add these items button in the My list page clears the basket and adds all products in the My list page to the basket New 
  Given user clears the basket
  #UI Steps
	And User navigates to BuyerUI
	And User login to buyerUI with API User
	And User clicks on "Basket Link" in buyers UI
  And User validates the Clear basket button and 'Your basket is empty' message on basket page
  
  #[SCA-108 TC01, TC02]
  #[SCA-107 TC03 TC01]
  
  @confidence
  Scenario: TC-TBD_Verify Buyer always be shown refreshed/up-to-date product prices in basket
  
  	#API Steps
  	Given user clears the basket
  	#UI Steps
  	And User logged in as "supplier" in admin panel
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    And Check if the product is present in a catalogue if yes then delete
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    When User creates a product
    And User close the current browser
    #And User log off and close the application
  	And User navigates to BuyerUI
    #And User login to buyerUI
    And User login to buyerUI with API User
    When User search a product with SKU number
    And User clicks on "PLP image" in buyers UI
    And User clicks on "Add to basket" in buyers UI
    And User clicks on "Proceed to basket" in buyers UI
    And User validates the generic message "Your basket has been updated."
    And User validates the product price on basket page
    And User update the product quantity by "2".
    And User clicks on "Quantity Update button" in buyers UI
    And User validates the delivery cost as per delivery method selected
    And User validates the generic message "Your basket has been updated."
    
    #Then verify the product details in buyers UI
    #And User log off and close the buyer UI
    #Given User logged in as "supplier" in admin panel
    #And User click on "productcatalogues" link on main sidebar
    #And User clicks on show link to view products
    #And User clicks on edit button to view product details
    #When User update the product details
    #And User log off and close the application
    #And User navigates to BuyerUI
    #And User login to buyerUI
    #And User clicks on "Basket Link" in buyers UI
    #Then "Basket" is shown to the buyer
    #And User validates the product price on basket page
    Given user clears the basket
    And User log off and close the buyer UI
  
  
  