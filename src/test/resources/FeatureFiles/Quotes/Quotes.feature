Feature: This User story covers the Firm quotes related scenarios

  #[US: SCA-91 (TC 01)]
  @testE2EFirmQuotes
  Scenario: TC-Verify user is able to see list of quotes which he has placed and quotes table is displayed with all columns
    Given User logged in as "supplier" in admin panel
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    And Check if the product is present in a catalogue if yes then delete
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    When User creates a product
    And User close the current browser
    And User navigates to BuyerUI
    And User login to buyerUI with API User
    When User search a product with SKU number
    And User clicks on "PLP image" in buyers UI
    And User clicks on "Add to basket" in buyers UI
    And User clicks on "Proceed to basket" in buyers UI
    And User validates the generic message "Your basket has been updated."
    And User clicks on "Quote" in buyers UI
    And User enter Quote name as "Firmquote"
    And User create "Firm" quote
    And User create "Indicative" quote
    And User clicks on "Raise quote" in buyers UI
    Then User get message "Quote raised successfully" on screen

  #[US: SCA-100 (TC: SCA-1958 )]
  @testE2EFirmQuotes
  Scenario: TC-Verify user is able to see list of quotes which he has placed and quotes table is displayed with all columns
    Given user clears the basket
    #  And user gets all the available products list
    #  And identify products which needs to be add in the list.
    #  And get the products variant ids
    #  And user adds a product to basket
    #  And user access the webservice of GetWishList
    #  And deletes the products from the WishList
    #  And user gets the multile products varient ids
    #  And user access the webservice of GetWishList
    #  And user adds the multiple products to WishList
    #UI Steps
    And User navigates to BuyerUI
    And User login to buyerUI with API User
    #	And User clicks on "Basket Link" in buyers UI
    When User clicks on "My Account link" in buyers UI
    And User clicks on "Manage quotes Visit link" in buyers UI
    And User searches for Quote reference "Q839436967" in buyers UI
    Then Quote table with all columns displayed on BuyerUI
    And Quote is displayed with "Q839436967;EK Firmquote 1;25/03/2021;novseasonal/Framework: RM6147L1;Firm;24/04/2021;£12.00;Accepted" details

  #[US: SCA-100 (TC: SCA-1959 )]
  @testE2EFirmQuotes
  Scenario: US-100 Verify when quote is created, it's status automatically assigned as 'Accepted'
    And User Validated a product details on basket page
    And User clicks on "Quote" in buyers UI
    And User enter Quote name as "Firmquote"
    And User create "Firm" quote
    And User create "Indicative" quote
    And User clicks on "Raise quote" in buyers UI
    Then User get message "Quote raised successfully" on screen
    And Quote table with all columns displayed on BuyerUI
    And Quote is displayed with "Q643392815;Firmquote9;16/03/2021;TestSFTPupload/Framework: RM6147L1;Firm;15/04/2021;£31.20;Accepted" details
