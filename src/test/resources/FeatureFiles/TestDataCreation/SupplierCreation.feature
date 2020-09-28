Feature: This feature is used to create supplier in Admin Panel
  Scenario: Supplier Creation script
    Given User logged in as "superadmin" in admin panel
    And Authorisation dialoxg box is handled
    When User click on "suppliers" link on main sidebar
    Then User creates 2 supplier
