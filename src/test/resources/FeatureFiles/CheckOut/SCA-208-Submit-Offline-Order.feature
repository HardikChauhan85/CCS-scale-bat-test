Feature: As a Buyer,
  I MUST be able to submit my Order to a Supplier by selecting to pay for the Order offline, 
  So that I can purchase my products without paying immediately

  Scenario: TC-1102_Verify that user is able to submit the order by paying offlines
    Given User navigates to BuyerUI
    And User login to buyerUI
    When User add 1 product in basket
    Then User completes the checkOut proccess
	
