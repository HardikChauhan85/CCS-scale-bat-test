Feature: As a supplier, CCS administrator and Category manager,
  I should be able to filter product catalogues by various parameters, 
  So that I can locate the catalogue I am looking for quickly

	#[US-291 (TC-SCA-425, SCA-426, SCA-427, SCA-428)], 
	#[US-327(SCA-448, SCA-449, SCA-450, SCA-451, SCA-452, SCA-455, SCA-456, SCA-454, SCA-453, )]
	@testAdminFilter
  Scenario Outline: CCS Admin should be able to filter products in product catalogue list page
    Given User logged in as "superadmin" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User counts the given filter value "<filterValue>" in the PCLP table "before" applying filter "<filter>"
    And User selects the value "<filterValue>" from the filter "<filter>"
    When User clicks on Search button
    Then User counts the given filter value "<filterValue>" in the PCLP table "after" applying filter "<filter>"
    And Verify the filter "<filter>" with result value "<filterValue>"
    
    #And User logged out from the admin panel
    #And Close the browser
		# New defect SCA-800

		
  Examples: 
  | filter   | filterValue |
  | supplier | cogautosupplier2  |
 	#|published|published|
  #|unpublished|unpublished|
  #|commercial agreement reference|RM6147|
  #|publishedunpublished|published&unpublished|
  ##|publishedCAR|published&RM6147|
  #|unpublishedCAR|unpublished&RM6147|
  #|supplierpublished	|Vendor 4.0&published	|
  #|supplierCAR	|Vendor 4.0&RM6147|
  #|CARUnpublishedPublished	|RM6147&published&unpublished|
  
  
  
  
  #[US-291 (TC-SCA-413, SCA-414, SCA-415, SCA-416)] Done
  @testSupplierFilterDone
  Scenario Outline: Supplier should be able to filter products in product catalogue list page
    Given User logged in as "supplier2" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User counts the given filter value "<filterValue>" in the PCLP table "before" applying filter "<filter>"
    And User selects the value "<filterValue>" from the filter "<filter>"
    When User clicks on Search button
    Then User counts the given filter value "<filterValue>" in the PCLP table "after" applying filter "<filter>"
    And Verify the filter "<filter>" with result value "<filterValue>"

    Examples: 
      | filter                         | filterValue           |
      | commercial agreement reference | RM6147                |
      | published                      | published             |
      | unpublished                    | unpublished           |
      | publishedunpublished           | published&unpublished |
      | publishedCAR                   | published&RM6147      |
      | unpublishedCAR                 | unpublished&RM6147    |


	#[US-291 (TC-SCA-370, SCA-398, SCA-399, SCA-400, SCA-401, SCA-402, SCA-403)]
  @test
  Scenario Outline: Category Manager should be able to filter products in product catalogue list page
    Given User logged in as "categoryManager" in admin panel
    And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User counts the given filter value "<filterValue>" in the PCLP table "before" applying filter "<filter>"
    And User selects the value "<filterValue>" from the filter "<filter>"
    When User clicks on Search button
    Then User counts the given filter value "<filterValue>" in the PCLP table "after" applying filter "<filter>"
    And Verify the filter "<filter>" with result value "<filterValue>"

    Examples: 
      | filter                         | filterValue           |
      | published                      | published             |
      | unpublished                    | unpublished           |
      | supplier                       | Vendor 4.0            |
      | commercial agreement reference | RM6147                |
      | publishedunpublished           | published&unpublished |
      #| publishedCAR                   | published&RM6147      |
      | unpublishedCAR                 | unpublished&RM6147    |
      | supplierpublished              | Vendor 4.0&published  |




	#[US-291 (TC-SCA-429, SCA-430, SCA-431, SCA-435, SCA-432)]
  # PRODUCT CATALOGUE PAGE
  @test
  Scenario Outline: CCS Admin should be able to filter products in product catalogue page
    Given User logged in as "superadmin" in admin panel
    And Authorisation dialoxg box is handled
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
     | supplierFilter | supplierValue | filter    | filterValue |
     | supplier       | ShownTell  | published | published   |
		 |supplier			|ShownTell	|unpublished	|unpublished|
		 |supplier			|ShownTell	|MPN	|137610-001|
		 |supplier			|ShownTell	|SKU	|SKU10|
  	 |supplier			|ShownTell	|publishedunpublished	|Published&Unpublished|
  	 |supplier    	| ShownTell  | productname | Compaq - Battery charger   |
  	 | supplier    | QACogTestSupplier  | publisheddelete | Published&Deleted   |
    
  
  #Due to defect not able to test
  # PRODUCT CATALOGUE PAGE
  @test
  Scenario Outline: CCS Admin should be able to filter products in product catalogue page
    Given User logged in as "supplier2" in admin panel
    And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    #And User selects the value "<supplierValue>" from the filter "<supplierFilter>"
    #When User clicks on Search button
    And User clicks on show link to view products
    And User checks the count of filter value "<filterValue>" present in the PCP result list "before" applying filter "<filter>"
    And User selects the value "<filterValue>" from the filter "<filter>"
    When User clicks on Search button
    And User checks the count of filter value "<filterValue>" present in the PCP result list "after" applying filter "<filter>"
    #And Verify the filter results
    And Verify the filter "<filter>" with result value "<supplierValue>"

    Examples: 
      | supplierFilter | supplierValue | filter | filterValue |
      |supplier			|ShownTell	|published	|published	|
      |supplier			|Test Vendor	|unpublished	|unpublished|
      |supplier			|Test Vendor	|publishedunpublished	|Published&Unpublished|
      |supplier			|Test Vendor	|MPN	|MPN40|
      | supplier       | Test Vendor   | SKU    | SKU22       |
      | supplier    | QACogTestSupplier  | publisheddelete | Published&Deleted   |

	#[US-291 (TC-SCA-404, SCA-405, SCA-406, SCA-407, SCA-408)]
  @test
  Scenario Outline: CCS Admin should be able to filter products in product catalogue page
    Given User logged in as "categoryManager" in admin panel
    And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar
    And User selects the value "<supplierValue>" from the filter "<supplierFilter>"
    When User clicks on Search button
    And User clicks on show link to view products
    And User checks the count of filter value "<filterValue>" present in the PCP result list "before" applying filter "<filter>"
    And User selects the value "<filterValue>" from the filter "<filter>"
    When User clicks on Search button
    And User checks the count of filter value "<filterValue>" present in the PCP result list "after" applying filter "<filter>"
    #And Verify the filter results
    And Verify the filter "<filter>" with result value "<supplierValue>"

    Examples: 
      | supplierFilter | supplierValue | filter | filterValue |
      |supplier			|ShownTell	|published	|published	|
      |supplier			|ShownTell	|unpublished	|unpublished|
      |supplier			|ShownTell	|MPN	|137610-001|
      | supplier       | ShownTell   | SKU    | SKU10       |
      |supplier			|ShownTell	|publishedunpublished	|Published&Unpublished|
     	| supplier    | ShownTell  | productname | Compaq - Battery charger   |
     	| supplier    | QACogTestSupplier  | publisheddelete | Published&Deleted   |
     	#| supplier    | QACogTestSupplier  | unpublisheddelete | Unpublished&Deleted   |