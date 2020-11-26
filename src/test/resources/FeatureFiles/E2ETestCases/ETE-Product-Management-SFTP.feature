Feature: This User story covers the ETE functionality from creating a product
  via SFTP uploads to validating the product in Buyer's UI#

  @test
  Scenario: TC-TBD_Verify that newly created product via SFTP upload is available on Buyers Ui
    Given User creates a CSV with 10 records
    #And User uploads the file to s3 bucket
    #Add code to check the details in Database
    #And User navigates to BuyerUI
    #And Authorisation dialoxg box is handled
    #And User login to buyerUI
    #When User search a product with SKU number
    #Then verify the product details in buyers UI
#
  #@test
  #Scenario: TC-TBD_Verify that updated product from SFTP upload is available on Buyers Ui
    #Given User creates a CSV with 10 records
    #And User uploads the file to s3 bucket
    #And User navigates to BuyerUI
    #And Authorisation dialoxg box is handled
    #And User login to buyerUI
    #When User search a product with SKU number
    #Then verify the product details in buyers UI
#
  #@test
  #Scenario: TC-TBD_Verify that deleted product from UI is not available on Buyers Ui with updates
    #Given User logged in as "supplier" in admin panel
    #And Authorisation dialoxg box is handled
    #And User click on "productcatalogues" link on main sidebar
    #And User clicks on show link to view products
    #When User delete a product
    #And User log off and close the application
    #And User navigates to BuyerUI
    #And Authorisation dialoxg box is handled
    #And User login to buyerUI
    #When User search a product with SKU number
    #Then verify the product details should not be available on buyers UI
