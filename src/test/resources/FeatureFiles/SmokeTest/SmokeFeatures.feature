Feature: Smoke tests will be triggered first on the CI.

  @smokeTest
  Scenario: Verify super admin is able to login to admin panel
    Given User logged in as "superadmin" in admin panel
    And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar

  @smokeTest
  Scenario: Verify category manager is able to login to admin panel
    Given User logged in as "categorymanager" in admin panel
    And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar

  @smokeTest
  Scenario: Verify supplier is able to login to admin panel
    Given User logged in as "supplier" in admin panel
    And Authorisation dialoxg box is handled
    And User click on "productcatalogues" link on main sidebar