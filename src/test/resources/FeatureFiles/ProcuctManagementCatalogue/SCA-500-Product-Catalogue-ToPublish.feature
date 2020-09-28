#User Story -500
Feature:As a supplier, 
I MUST be able to publish my catalogues
So that all of the products in the catalogue can become available for purchase

  Scenario: TBD_Verify that supplier is able to publish the entire catalogue
    Given User logged in as "supplier" in admin panel
    And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    #When User clicks on "" button on product details list page