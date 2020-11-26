#User Story -501 - Completed
Feature: As a CCS administrator and a category manager,
  I should be able to see supplier name of the catalogue I'm viewing, 
  So that I know which supplier this catalogue relates to

  @test
  Scenario: SCA-520_Verify that product updated successfully message is displayed after updating a product
    Given User logged in as "superadmin" in admin panel
    And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User filter the catalogue list page using filter "supplier"
    When User clicks on show link to view products
    Then Title of each catalogue should have supplier and catalogue name
#
  #@test
  #Scenario: SCA-523_Verify that product updated successfully message is displayed after updating a product
    #Given User logged in as "categorymanager" in admin panel
    #And Authorisation dialoxg box is handled
    #And User click on "productcatalogues" link on main sidebar
    #And User filter the catalogue list page using filter "supplier"
    #When User clicks on show link to view products
    #Then Title of each catalogue should have supplier and catalogue name
#
  #@test
  #Scenario: SCA-521_Verify that super admin should not be able to see supplier name of other supplier on product catalogue
    #Given User logged in as "superadmin" in admin panel
    #And Authorisation dialoxg box is handled
    #And User click on "productcatalogues" link on main sidebar
    #And User filter the catalogue list page using filter "supplier"
    #When User clicks on show link to view products
    #Then Title of each catalogue should not have other supplier and catalogue name
#
  #@test
  #Scenario: SCA-522_Verify that category manager should not be able to see supplier name of other supplier on product catalogue
    #Given User logged in as "categorymanager" in admin panel
    #And Authorisation dialoxg box is handled
    #And User click on "productcatalogues" link on main sidebar
    #And User filter the catalogue list page using filter "supplier"
    #When User clicks on show link to view products
    #Then Title of each catalogue should not have other supplier and catalogue name
