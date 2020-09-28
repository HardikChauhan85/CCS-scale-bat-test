Feature: This User story covers the ETE functionality from creating a product in admin UI to validating the product in Buyer's UI#

  @aa @TestE2E
  Scenario: TC-TBD_Verify that newly created product from UI is available on Buyers Ui
    Given User logged in as "supplier" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    When User creates a product
    And User log off and close the application
    #Add code to check the details in Database
    And User navigates to BuyerUI
    #And Authorisation dialoxg box is handled
    And User login to buyerUI
    When User search a product with SKU number
    Then verify the product details in buyers UI
    
    
    @e2eTC2 @TestE2E
  	Scenario: TC-TBD_Verify that newly created product from UI is available on Buyers Ui
    Given User logged in as "supplier1" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    When User creates a product
    And User log off and close the application
    #Add code to check the details in Database
    And User navigates to BuyerUI
    #And Authorisation dialoxg box is handled
    And User login to buyerUI
    And User search a product with SKU number
    #When User search a product with Product Name number
    When verify the product details in buyers UI
    Then User Validate last updated product by supplier "Supplier1" is showing in PDP price table on buyers UI
    
    
  @e2eTC3 @TestE2E
  Scenario: TC-TBD_Verify that updated product from UI is available on Buyers Ui with updates
    Given User logged in as "supplier" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    And User clicks on edit button to view product details
    ##When User updates a product
    When User update the product details
    And User log off and close the application
    #Add code to check the details in Database
    And User navigates to BuyerUI
    #And Authorisation dialoxg box is handled
    And User login to buyerUI
    When User search a product with SKU number
    Then verify the product details in buyers UI
    Then User Validate last updated product by supplier "supplier" is showing in PDP price table on buyers UI
    
  
#
  #@test
  #Scenario: TC-TBD_Verify that updated product from UI is available on Buyers Ui with updates
    #Given User logged in as "supplier" in admin panel
    #And Authorisation dialoxg box is handled
    #And User click on "productcatalogues" link on main sidebar
    #And User clicks on show link to view products
    #And User clicks on edit button to view product details
    #When User updates a product
    #And User log off and close the application
    #Add code to check the details in Database
    #And User navigates to BuyerUI
    #And Authorisation dialoxg box is handled
    #And User login to buyerUI
    #When User search a product with SKU number
    #Then verify the product details in buyers UI
    
	@test @TestE2E
  Scenario: TC-TBD_Verify that unpublished product from UI is available on Buyers Ui with updates
    Given User logged in as "supplier" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    And User clicks on edit button to view product details
    When User clicks on "Unpublish" button on product details page
    And User log off and close the application
    #Add code to check the details in Database
    And User navigates to BuyerUI
    #And Authorisation dialoxg box is handled
    And User login to buyerUI
    When User search a product with SKU number
    Then verify the product details should not be available on buyers UI
#
  @test @TestE2E
  Scenario: TC-TBD_Verify that deleted product from UI is not available on Buyers Ui with updates
    Given User logged in as "supplier" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    When User delete a product
    And User log off and close the application
    #Add code to check the details in Database
    And User navigates to BuyerUI
    #And Authorisation dialoxg box is handled
    And User login to buyerUI
    When User search a product with SKU number
    Then verify the product details should not be available on buyers UI
    
    #To Delete the Supplier1 product not a part of E2E TC
    @test @TestE2E
  	Scenario: TC-TBD_Verify that deleted product from UI is not available on Buyers Ui with updates
    Given User logged in as "supplier1" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    When User delete a product
    And User log off and close the application
    #Add code to check the details in Database
    And User navigates to BuyerUI
    #And Authorisation dialoxg box is handled
    And User login to buyerUI
    When User search a product with SKU number
    Then verify the product details should not be available on buyers UI