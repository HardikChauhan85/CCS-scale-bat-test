#User Story -81
Feature: As a CCS Administrator,
  I MUST be able to set the status of a Supplier's Product Catalogue to unpublished, 
  So that if a Supplier has breached their Agreement T&Cs their content can be removed by setting it as unpublished

  
	@confidence
  Scenario: SCA-496_Verify that super admin should be able to unpublish entire product in catalogue of a supplier
    Given User logged in as "superadmin" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User filter the catalogue list page using filter "supplier"
    And User clicks on show link to view products

  #When User clicks on edit button to view product details
  #Code will be written after the test data
  @confidence
  Scenario: SCA-496_Verify that super admin should be able to publish entire product in catalogue of a supplier
    Given User logged in as "superadmin" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User filter the catalogue list page using filter "supplier"
    And User clicks on show link to view products
    When User clicks on edit button to view product details
		#Code will be written after the test data
	
	
