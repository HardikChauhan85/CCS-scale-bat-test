#User Story - 116
Feature: As a Supplier,
  I MUST be able to maintain (create, delete, update) my local product stock levels, 
  So that potential buyers know how much of the product they can order from me

	#
	@confidence @Supplier
  Scenario: SCA-384_Verify that supplier is able to update the stock of newly created product
  #Need to add a script to add new product
 		Given User logged in as "supplier" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    And Check if the product is present in a catalogue if yes then delete
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    When User creates a product
    #And User log off and close the application
    #Given User logged in as "supplier" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    And User clicks on edit button to view product details
    When User updates the stock quantity of a product
    Then A successful message should be displayed

	#
  @confidence @Supplier
  Scenario: SCA-386_Verify that stock levels is not updated when cancel button is clicked on stock level page
    Given User logged in as "supplier" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    When User clicks on edit button to view product details
    Then Updated quantity will be replaced by previous value on clicking cancel button
	
	# 
  @confidence @Supplier
  Scenario: SCA-391_Verify that Stock level field is not accepting decimal input
    Given User logged in as "supplier" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    When User clicks on edit button to view product details
    Then On updating "decimal" stock quantity an warning message will be displayed

	# 
  @confidence @Supplier
  Scenario: SCA-390_Verify that Stock level field is not accepting negative input
    Given User logged in as "supplier" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    When User clicks on edit button to view product details
    Then On updating "negative" stock quantity an warning message will be displayed

	# 
  @confidence @Supplier
  Scenario: SCA-389_Verify that Stock level field is not accepting alphanumeric input
    Given User logged in as "supplier" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User clicks on show link to view products
    When User clicks on edit button to view product details
    Then On updating "alphanumeric" stock quantity an warning message will be displayed
