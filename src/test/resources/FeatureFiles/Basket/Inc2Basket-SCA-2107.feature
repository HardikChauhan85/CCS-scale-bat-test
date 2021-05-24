Feature: My Account Settings Page - I must be able to add new manual delivery and invoice addresses

  Background: API - navigate to basket
    #API Steps
    Given User navigates to BuyerUI
    And User login to buyerUI
    And User clicks on "My Account link" in buyers UI
    When User clicks on update account details button
    Then I am on the "Update account details" page

    #[US-2107 TC01(SCA-2565)]
  @demo
  Scenario:Verify that user can add Wales postal address on my account page
    And User clicks on add address button on account details page
    Then I am on the "Add new address" page
    When I enter the following data:
      | First Name | Last Name | Building and Street | Town or city | Postcode | Phone       |
      | Test       | Auto      | 12 Street name      |    Cardiff   | CF10 1AE | 02086928876 |
    And User selects "Wales; Cymru" from the country drop down option
    And User clicks on Add new address button
    Then I am on the "Update account details" page


##    #[US-2107 TC01(SCA-2566)]
  @demo
  Scenario:Verify that user can add England postal address on my account page
    And User clicks on add address button on account details page
    Then I am on the "Add new address" page
    When I enter the following data:
      | First Name | Last Name | Building and Street | Town or city | Postcode | Phone       |
      | Test       | Auto      | 12 Street name      |    Manchester   | M11AH | 02086928876 |
    And User selects "England" from the country drop down option
    And User clicks on Add new address button
    Then I am on the "Basket" page

#  #[US-2107 TC01(SCA-2568)]
  @demo
  Scenario:Verify that user can add a Scotland postal address on my account page
    And User clicks on add address button on account details page
    Then I am on the "Add new address" page
    When I enter the following data:
      | First Name | Last Name | Building and Street | Town or city | Postcode | Phone       |
      | Test       | Auto      | 12 Street name      |  Edinburgh   | EH11BE   | 02086928876 |
    And User selects "Scotland" from the country drop down option
    And User clicks on Add new address button
    Then I am on the "Basket" page

##  #[US-2107 TC01(SCA-2437)]
  @demo
  Scenario:Verify that user can add Northern Ireland postal address on my account page
    And User clicks on add address button on account details page
    Then I am on the "Add new address" page
    When I enter the following data:
      | First Name | Last Name | Building and Street | Town or city | Postcode | Phone       |
      | Test       | Auto      | 12 Street name      |  Belfast     | BT11FT   | 02086928876 |
    And User selects "Scotland" from the country drop down option
    And User clicks on Add new address button
    Then I am on the "Basket" page

  #[US-2107 TC01(SCA-2569)]
  @demo
  Scenario:Account page-Verify that error message is displayed when mandatory fields are blank
    And User clicks on add address button on account details page
    Then I am on the "Add new address" page
    When User clicks on Add new address button
    Then I should see address validation error messages

#  #[US-2107 TC01(SCA-2570)]
  @demo
  Scenario:Account page - Verify user is redirected back to the basket when user clicks on cancel
    And User clicks on add address button on account details page
    Then I am on the "Add new address" page
    When User clicks on cancel add address button
    Then I am on the "Basket" page

    ##  #[US-2107 TC01(SCA-2579)]
  @demo
  Scenario:Account page-Verify that validation error message is displayed when invalid UK postcode format is entered
    And User clicks on add address button on account details page
    Then I am on the "Add new address" page
    When I enter the following data:
      | First Name | Last Name | Building and Street | Town or city | Postcode | Phone       |
      | Test       | Auto      | 12 Street name      |  Belfast     |  SE9     | 02086928876 |
    And User selects "Scotland" from the country drop down option
    And User clicks on Add new address button
    Then I should see invalid postcode error messages