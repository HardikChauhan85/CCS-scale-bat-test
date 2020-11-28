package com.scale.bat.stepdefs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import com.scale.bat.businessPages.BuyersUIpage;
import com.scale.bat.context.ScenarioContext;
import com.scale.bat.context.TestContext;
import com.scale.bat.framework.utility.Log;
import com.scale.bat.framework.utility.PageObjectManager;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuyerUiStepDefs {
	private Logger log = Log.getLogger(BuyersUIpage.class);

	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;

	public BuyerUiStepDefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}

	@When("User add {int} product in basket")
	public void user_add_product_in_basket(int numberOfProducts) {
		objectManager.getBuyersUIpage().addProductToBasket(numberOfProducts);
	}
	
	@And("User removes all the products from the basket")
	public void user_removes_all_the_products_from_the_basket() {
	    
		objectManager.getBuyersUIpage().removeProductsFromTheBasket();
	}

	@When("User add {int} products to compare")
	public void user_add_product_to_compare(int numberOfProducts) {
		objectManager.getBuyersUIpage().compareProducts(numberOfProducts);
	}

	@Then("{string} is shown to the buyer")
	public void is_shown_to_the_buyer(String pageName) {
		objectManager.getBuyersUIpage().isBuyerNavigatedToGivenPage(pageName);
	}

	@And("User clicks on {string} in buyers UI")
	public void user_clicks_on_button_on_buyers_UI(String button) {
		switch (button) {
		case "Continue Shopping":
			objectManager.getBuyersUIpage().clickElement(objectManager.getBuyersUIpage().getContinueShoppingElement());
			break;
		case "Proceed to basket":
			objectManager.getBuyersUIpage().clickElement(objectManager.getBuyersUIpage().getProceedToBasketElement());
			break;
		case "browser back button":
			objectManager.getBuyersUIpage().navigateBackfromBrowser();
			break;
		case "continue shopping link":
			objectManager.getBuyersUIpage()
					.clickByLinkText(objectManager.getBuyersUIpage().getContinueShoppingLinkOnBasketPage());
			break;
		case "Delete button":
			objectManager.getBuyersUIpage().clickElement(objectManager.getBuyersUIpage().deleteButtonOnBasketElement());
			break;
		case "PLP image":
			objectManager.getBuyersUIpage().navigateToPDPPage();
			break;
		case "Basket Link":
			objectManager.getBuyersUIpage().clickElement(objectManager.getBuyersUIpage().getBasketLink());
			break;
		case "Add to basket":
			objectManager.getBuyersUIpage().addElementToBasket();
			
			break;
		
		

		}
	}

	@And("User navigates to PLP of buyers UI")
	public void user_navigates_to_PLP_of_buyers_UI() {
		objectManager.getBuyersUIpage().navigateToPLPPage();
	}

	@Then("{string} button should not be visible")
	public void button_should_not_be_visible(String buttonOrLinkText) {
		switch (buttonOrLinkText) {
		case "Add to Basket":
			assertFalse(
					objectManager.getBuyersUIpage().isElementPresent(objectManager.getBuyersUIpage().getAddToBasket()));
			break;
		case "Basket":
			assertFalse(
					objectManager.getBuyersUIpage().isElementPresent(objectManager.getBuyersUIpage().getBasketLink()));
			break;
		}
	}

	@When("User search a product with SKU number")
	public void user_search_a_product_with_SKU_number() {
		log.info(scenarioContext.productDetails);
		objectManager.getBuyersUIpage().searchProduct(scenarioContext.productDetails.get("SKU").toString());
	}

	@Then("verify the product details in buyers UI")
	public void verify_the_product_details_in_buyers_UI() {
		objectManager.getBuyersUIpage().navigateToPDPPage();
		objectManager.getBuyersUIPDPPage().verifyProductDetails(scenarioContext.productDetails);
	}

	@Then("verify the product details should not be available on buyers UI")
	public void verify_the_product_details_unavialable_on_buyers_UI() {
		//objectManager.getBuyersUIpage().isElementPresent("0 results");
		objectManager.getBuyersUIpage().isElementPresent("No results found.");
		
	}

	@Then("User Validate last updated product by supplier {string} is showing in PDP price table on buyers UI")
	public void user_Validate_last_updated_product_by_supplier_is_showing_in_PDP_price_table_on_buyers_UI(
			String supplierName) {

		objectManager.getBuyersUIPDPPage().verifyLastUpdatedProductDetails(scenarioContext.productDetails,
				supplierName);
	}
}
