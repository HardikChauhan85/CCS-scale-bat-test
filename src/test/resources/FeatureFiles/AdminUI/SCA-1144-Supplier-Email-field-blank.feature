
Feature: Supplier can't leave their Notification Email field blank
	#SCA-1144 [TC-01 and TC02]
	@confidence
  Scenario: CCS Admin should be able to filter products in product catalogue list page
    Given User logged in as "superadmin" in admin panel
    #And Authorisation dialoxg box is handled
    And User click on "Suppliers" link on main sidebar
    And User enters the "CogNewTestSupplier1.0" on Name textbox
    And User clicks on "Filter Results" button
    And User clicks on edit link
    And User removes the email from the Notification email textbox
    And User clicks on Update Button
    And User should not be able to update the supplier details and a message "Please fill out field." should display
    And User enters the valid email "qtesting45@gmail.com" in Notification email textbox
    And User clicks on Update Button
    And User should be able to update the supplier details and a message "Vendor "CogNewTestSupplier1.0" has been successfully updated!" should display
    
    
    #SCA-1144 [TC-03] Below are TC03 steps blocked due to defect
    #And User removes the email from the Notification email textbox
    #And enters the invalid email "qtesting45@gmail" in Notification email textbox
    #And User clicks on Update Button
    #And should not be able to update the supplier details and a message "Please fill out field." should display
    
    
  