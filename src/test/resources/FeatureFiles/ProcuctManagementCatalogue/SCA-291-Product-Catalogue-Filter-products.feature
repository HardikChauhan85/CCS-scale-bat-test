Feature: As a supplier, CCS administrator and Category manager,
  I should be able to filter product catalogues by various parameters, 
  So that I can locate the catalogue I am looking for quickly

	#[US-291 (TC-SCA-425, SCA-426, SCA-427, SCA-428)], 
	#[US-327(SCA-448, SCA-449, SCA-450, SCA-451, SCA-452, SCA-455, SCA-456, SCA-454, SCA-453, )]
	@confidence
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
 # |supplier | cogautosupplier2  |
 #	|published|published|
 # |unpublished|unpublished|
  |commercial agreement reference|RM6147|
  |publishedunpublished|published&unpublished|
  |publishedCAR|published&RM6147|
  |unpublishedCAR|unpublished&RM6147|
  |supplierpublished	|cogautosupplier2&published	|
  |supplierCAR	|cogautosupplier2&RM6147|
  |CARUnpublishedPublished	|RM6147&published&unpublished|
  
  
  
  
  #[US-291 (TC-SCA-413, SCA-414, SCA-415, SCA-416)] Done
  @confidence
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
  @confidence
  Scenario Outline: Category Manager should be able to filter products in product catalogue list page
    Given User logged in as "categoryManager" in admin panel
    #And Authorisation dialoxg box is handled
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
      | supplier                       | cogautosupplier2            |
      | commercial agreement reference | RM6147                |
      | publishedunpublished           | published&unpublished |
      #| publishedCAR                   | published&RM6147      |
      | unpublishedCAR                 | unpublished&RM6147    |
      | supplierpublished              | cogautosupplier2&published  |




	#[US-291 (TC-SCA-429, SCA-430, SCA-431, SCA-435, SCA-432)]
  # PRODUCT CATALOGUE PAGE
  @confidence
  Scenario Outline: CCS Admin should be able to filter products in product catalogue page
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
     | supplierFilter | supplierValue | filter    | filterValue |
     #| supplier       | cogautosupplier2  | published | published   |
		 #|supplier			|cogautosupplier2	|unpublished	|unpublished|
		 #|supplier			|cogautosupplier2	|MPN	|DT-740|
		 #|supplier			|cogautosupplier2	|SKU	|SKU22|
  	 |supplier			|cogautosupplier2	|publishedunpublished	|Published&Unpublished|
  	 #|supplier    	| cogautosupplier2  | productname | Kyocera FS-7002 Plus - Printer   |
  	 | supplier    | cogautosupplier2  | publisheddelete | Published&Deleted   |
    
  
  #Due to defect not able to test
  # PRODUCT CATALOGUE PAGE
  @confidence
  Scenario Outline: CCS Admin should be able to filter products in product catalogue page
    Given User logged in as "supplier2" in admin panel
    #And Authorisation dialoxg box is handled
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
      |supplier			|cogautosupplier2	|published	|published	|
      |supplier			|cogautosupplier2	|unpublished	|unpublished|
      |supplier			|cogautosupplier2	|publishedunpublished	|Published&Unpublished|
      |supplier			|cogautosupplier2	|MPN	|DT-740|
      | supplier    | cogautosupplier2   | SKU    | SKU22       |
      | supplier    | cogautosupplier2  | publisheddelete | Published&Deleted   |

	#[US-291 (TC-SCA-404, SCA-405, SCA-406, SCA-407, SCA-408)]
  @confidence
  Scenario Outline: CCS Admin should be able to filter products in product catalogue page
    Given User logged in as "categoryManager" in admin panel
    #And Authorisation dialoxg box is handled
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
      |supplier			|cogautosupplier2	|published	|published	|
      |supplier			|cogautosupplier2	|unpublished	|unpublished|
      |supplier			|cogautosupplier2	|MPN	|DT-740|
      | supplier    |cogautosupplier2   | SKU    | SKU22       |
      |supplier			|cogautosupplier2	|publishedunpublished	|Published&Unpublished|
     	| supplier    | cogautosupplier2  | productname | Kyocera FS-7002 Plus - Printer   |
     	| supplier    | cogautosupplier2  | publisheddelete | Published&Deleted   |
     	| supplier    | cogautosupplier2  | unpublisheddelete | Unpublished&Deleted   |