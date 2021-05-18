Feature: This user validates that user can add address


  Background: API - navigate to basket
    #API Steps
    Given user clears the basket
    And user gets all the available products list
    And identify products which needs to be add in the list.
    And get the products variant ids
    And user adds a product to basket

    #[US-2036 TC01(SCA-2434)]

  Scenario:Verify that user can add Wales postal address
  #UI Steps
    And User navigates to BuyerUI
    And User login to buyerUI with API User
    And User clicks on "Basket Link" in buyers UI
    And User clicks on "Add new address" in buyers UI
    Then I am on the "Add new address" page
    When I enter the following data:
      | First Name | Last Name | Building and Street | Town or city | Postcode | Phone       |
      | Test       | Auto      | 12 Street name      |    London    | NW14DF   | 02086928876 |
