Feature: This feature is used to create supplier in Admin Panel
  @test
  Scenario: Supplier Creation script
    Given User logged in as "superadmin" in admin panel
    When User click on "suppliers" link on main sidebar
    #Then User creates 3 supplier
