Feature: This User story covers the ETE functionality from creating a product in admin UI to validating the product in Buyer's UI#

  @testE2E @confidence
  Scenario: TC01_Verify that product should not be available in the catalogue of the supplier1 in supplier admin
    Given User logged in as "supplier" in admin panel
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    And Check if the product is present in a catalogue if yes then delete
    And User log off and close the application

  @testE2E @confidence
  Scenario: TC02_Verify that product should not be available in the catalogue of the supplier2 in supplier admin
    Given User logged in as "supplier1" in admin panel
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    And Check if the product is present in a catalogue if yes then delete
    And User log off and close the application

  @testE2E @confidence
  Scenario: TC03_Verify that newly created product by Supplier1 from UI is available on Buyers UI
    Given User logged in as "supplier" in admin panel
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    And Check if the product is present in a catalogue if yes then delete
    #And User log off and close the application
    
    #Given User logged in as "supplier" in admin panel
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

  #
  @testE2E @confidence
  Scenario: TC04_Verify that newly created product by Supplier2 from UI is available on Buyers UI
    Given User logged in as "supplier1" in admin panel
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    And Check if the product is present in a catalogue if yes then delete
    
    
    #Given User logged in as "supplier1" in admin panel
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

  #
  #
  @testE2E @confidence
  Scenario: TC05_Verify that Supplier1 updated product from UI is available on Buyers UI with updates
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
  #
  #
  #@testABC
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
  #
  @testE2E @confidence
  Scenario: TC06_Verify that Supplier1 unpublished product from UI is available on Buyers UI with updates
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
  @testE2E @confidence
  Scenario: TC07_Verify that Supplier1 deleted product from UI is not available on Buyers UI with updates
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

  #
  #To Delete the Supplier1 product not a part of E2E TC
  @testE2E @confidence 
  Scenario: TC08_Verify that Supplier2 deleted product from UI is not available on Buyers UI with updates
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

  #[US-291] # PRODUCT CATALOGUE LIST PAGE
  @testE2E @confidence
  Scenario Outline: TC09_CCS Admin should be able to filter products in product catalogue list page
    Given User logged in as "superadmin" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User counts the given filter value "<filterValue>" in the PCLP table "before" applying filter "<filter>"
    And User selects the value "<filterValue>" from the filter "<filter>"
    When User clicks on Search button
    Then User counts the given filter value "<filterValue>" in the PCLP table "after" applying filter "<filter>"
    And Verify the filter "<filter>" with result value "<filterValue>"

    Examples: 
      | filter      | filterValue      |
      | supplier    | cogautosupplier2 |
      | published   | published        |
      | unpublished | unpublished      |

  #[US-291] # PRODUCT CATALOGUE PAGE
  @testE2E @confidence
  Scenario Outline: TC10_CCS Admin should be able to filter products in product catalogue page
    Given User logged in as "superadmin" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User selects the value "<supplierValue>" from the filter "<supplierFilter>"
    When User clicks on Search button
    And User clicks on show link to view products
    #And User selects the per page count "125"
    And User checks the count of filter value "<filterValue>" present in the PCP result list "before" applying filter "<filter>"
    And User selects the value "<filterValue>" from the filter "<filter>"
    When User clicks on Search button
    #And User selects the per page count "125"
    And User checks the count of filter value "<filterValue>" present in the PCP result list "after" applying filter "<filter>"
    And Verify the filter "<filter>" with result value "<supplierValue>"

    Examples: 
      | supplierFilter | supplierValue    | filter      | filterValue                    |
      | supplier       | cogautosupplier2 | published   | published                      |
      | supplier       | cogautosupplier2 | unpublished | unpublished                    |
      | supplier       | cogautosupplier2 | MPN         | DT-740                         |
      | supplier       | cogautosupplier2 | SKU         | SKU22                          |
      | supplier       | cogautosupplier2 | productname | Kyocera FS-7002 Plus - Printer |
