
Feature: Supplier can't leave their Notification Email field blank

	#SCA-1144 [TC-01 and TC02]
	# TC-01(US-1994) Verify user get error message when 'Notification email' field is kept blank
	# TC-02(US-1995) Verify user is able to update 'Notification email' field with valid email ID
	# TC-03(US-1996) Verify user get error message when 'Notification email' field is updated with invalid email ID
	@confidence
  Scenario: TC_Verify Notification Email field with balnk, correct and incorrect email id
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
    
    
  