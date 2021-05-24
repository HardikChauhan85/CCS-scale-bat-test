Feature: validates that user can add address

  Background: Navigate to account settings page
    And User navigates to BuyerUI
    And User login to buyerUI
    And User clicks on "My Account link" in buyers UI
    And User clicks on My List Visit button

    #[US-2036 TC01(SCA-2434)]
  @demo
  Scenario:Verify that user can add Wales postal address
  #UI Steps
    And User navigates to BuyerUI
    And User login to buyerUI with API User
    And User clicks on "Basket Link" in buyers UI
    And User clicks on "Add new address" in buyers UI
    Then I am on the "Add new address" page
    When I enter the following data:
      | First Name | Last Name | Building and Street | Town or city | Postcode | Phone       |
      | Test       | Auto      | 12 Street name      |    Cardiff   | CF10 1AE | 02086928876 |
    And User selects "Wales; Cymru" from the country drop down option
    And User clicks on Add new address button
    Then I am on the "Basket" page


#    #[US-2036 TC01(SCA-2435)]
  @demo
  Scenario:Verify that user can add England postal address
  #UI Steps
    And User navigates to BuyerUI
    And User login to buyerUI with API User
    And User clicks on "Basket Link" in buyers UI
    And User clicks on "Add new address" in buyers UI
    Then I am on the "Add new address" page
    When I enter the following data:
      | First Name | Last Name | Building and Street | Town or city | Postcode | Phone       |
      | Test       | Auto      | 12 Street name      |    Manchester   | M11AH | 02086928876 |
    And User selects "England" from the country drop down option
    And User clicks on Add new address button
    Then I am on the "Basket" page

#  #[US-2036 TC01(SCA-2435)]
  @demo
#  Scenario:Verify that user can add a Scotland postal address
    And User navigates to BuyerUI
    And User login to buyerUI with API User
    And User clicks on "Basket Link" in buyers UI
    And User clicks on "Add new address" in buyers UI
    Then I am on the "Add new address" page
    When I enter the following data:
      | First Name | Last Name | Building and Street | Town or city | Postcode | Phone       |
      | Test       | Auto      | 12 Street name      |  Edinburgh   | EH11BE   | 02086928876 |
    And User selects "Scotland" from the country drop down option
    And User clicks on Add new address button
    Then I am on the "Basket" page

#  #[US-2036 TC01(SCA-2437)]
  @demo
  Scenario:Verify that user can add Northern Ireland postal address
    And User navigates to BuyerUI
    And User login to buyerUI with API User
    And User clicks on "Basket Link" in buyers UI
    And User clicks on "Add new address" in buyers UI
    Then I am on the "Add new address" page
    When I enter the following data:
      | First Name | Last Name | Building and Street | Town or city | Postcode | Phone       |
      | Test       | Auto      | 12 Street name      |  Belfast     | BT11FT   | 02086928876 |
    And User selects "Scotland" from the country drop down option
    And User clicks on Add new address button
    Then I am on the "Basket" page

  #[US-2036 TC01(SCA-2438)]
  @demo
  Scenario:Verify that error message is displayed when mandatory fields are blank
    And User navigates to BuyerUI
    And User login to buyerUI with API User
    And User clicks on "Basket Link" in buyers UI
    And User clicks on "Add new address" in buyers UI
    Then I am on the "Add new address" page
    When User clicks on Add new address button
    Then I should see address validation error messages


#  #[US-2036 TC01(SCA-2438)]
  @demo
  Scenario:Verify user is redirected back to the basket when user clicks on cancel
    And User navigates to BuyerUI
    And User login to buyerUI with API User
    And User clicks on "Basket Link" in buyers UI
    And User clicks on "Add new address" in buyers UI
    Then I am on the "Add new address" page
    When User clicks on cancel add address button
    Then I am on the "Basket" page




