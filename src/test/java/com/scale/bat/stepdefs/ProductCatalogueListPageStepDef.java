package com.scale.bat.stepdefs;

import java.net.MalformedURLException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.scale.bat.businessPages.BuyersUIpage;
import com.scale.bat.context.ScenarioContext;
import com.scale.bat.context.TestContext;
import com.scale.bat.framework.utility.DateTimeUtils;
import com.scale.bat.framework.utility.JsonParser;
import com.scale.bat.framework.utility.Log;
import com.scale.bat.framework.utility.PageObjectManager;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductCatalogueListPageStepDef {
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;
	private Logger log = Log.getLogger(BuyersUIpage.class);

	public ProductCatalogueListPageStepDef(TestContext testContextObj, ScenarioContext context) {
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = context;
	}

	@And("User clicks on show link to view products")
	public void user_clicks_on_show_link_to_view_products() {
		objectManager.getProductCatalogueListPage().showProducts();
	}
	
	@Given("Check if the product is present in a catalogue if yes then delete")
	public void check_if_the_product_is_present_in_a_catalogue_if_yes_then_delete() {
	    
		objectManager.getProductCatalogueListPage().checkProductPresentInCatalogueIfYesThendelete();
	}


	@When("User creates a product")
	public void user_creates_a_product() {
		JSONObject jObj = new JSONObject(new JsonParser().convertJsonToString(scenarioContext.ScenarioDataFilePath))
				.getJSONObject("ProductCreation").getJSONObject("FromUi");
		objectManager.getProductCataloguePage().createNewProduct(jObj);
		scenarioContext.productDetails = jObj.toMap();
		log.info(scenarioContext.productDetails);
		log.info("Product is created!!");
	}

	/*@When("User delete a product")
	public void user_delete_a_product() {
		JSONObject jObj = new JSONObject(new JsonParser().convertJsonToString(scenarioContext.ScenarioDataFilePath));
		JSONObject details =jObj.getJSONObject("ProductCreation").getJSONObject("FromUi");
		objectManager.getProductCataloguePage().deleteProduct();
		scenarioContext.productDetails = details.toMap();
		
		jObj.put("SKU", "SKU01");
		scenarioContext.jsonParser.writeJsonFile(jObj, scenarioContext.ScenarioDataFilePath);
		log.info(scenarioContext.productDetails);
		log.info("Product is Deleted!!");
	}*/
	
	
	@When("User delete a product")
	public void user_delete_a_product() {
		JSONObject jObj = new JSONObject(new JsonParser().convertJsonToString(scenarioContext.ScenarioDataFilePath));
		JSONObject details =jObj.getJSONObject("ProductCreation").getJSONObject("FromUi");
		objectManager.getProductCataloguePage().deleteProduct();
		scenarioContext.productDetails = details.toMap();
		//jObj.put("SKU", "SKU01");
		//scenarioContext.jsonParser.writeJsonFile(jObj, scenarioContext.ScenarioDataFilePath);
		log.info(scenarioContext.productDetails);
		log.info("Product is Deleted!!");
	}

	@When("User updates a product")
	public void user_updates_a_product() {
		JSONObject jObj = new JSONObject(new JsonParser().convertJsonToString(scenarioContext.ScenarioDataFilePath));

		JSONObject fromUiObj = jObj.getJSONObject("ProductCreation").getJSONObject("FromUi");
		String UpdatedPrice = new DateTimeUtils().dateWithSpecificFormatt("dd");
		fromUiObj.put("Price", UpdatedPrice);
		fromUiObj.put("UNSPSC", fromUiObj.getString("UNSPSC") + UpdatedPrice);
		fromUiObj.put("SKU", fromUiObj.getString("SKU") + UpdatedPrice);

		jObj.put("FromUi", fromUiObj);

		Map<String, Object> pDetails = fromUiObj.toMap();
		objectManager.getproductDetailsPage().updateProduct(pDetails);
		scenarioContext.productDetails = pDetails;
		scenarioContext.jsonParser.writeJsonFile(jObj, scenarioContext.ScenarioDataFilePath);

		log.info(scenarioContext.productDetails);
		log.info("Product is Updated!!");

	}
	
	
	@When("User update the product details")
	public void user_update_the_product_details() {
	    
		JSONObject jObj = new JSONObject(new JsonParser().convertJsonToString(scenarioContext.ScenarioDataFilePath));
		JSONObject fromUiObj = jObj.getJSONObject("ProductCreation").getJSONObject("FromUi");
		String Currenntday = new DateTimeUtils().dateWithSpecificFormatt("dd");
		String Price1 = fromUiObj.getString("Price");
		double Price = Double.parseDouble(Price1);
		double UpdatedPriceDbl=Price-2;
		String UpdatedPrice=Double.toString(UpdatedPriceDbl);
		
		fromUiObj.put("Price", UpdatedPrice);
		fromUiObj.put("UNSPSC", fromUiObj.getString("UNSPSC") + Currenntday);
		fromUiObj.put("SKU", fromUiObj.getString("SKU") + Currenntday);

		jObj.put("FromUi", fromUiObj);

		Map<String, Object> pDetails = fromUiObj.toMap();
		objectManager.getproductDetailsPage().updateProduct(pDetails);
		scenarioContext.productDetails = pDetails;
		scenarioContext.jsonParser.writeJsonFile(jObj, scenarioContext.ScenarioDataFilePath);

		log.info(scenarioContext.productDetails);
		log.info("Product is Updated!!");

	}

	

	// Hardcoded value is provided for now. Hard code value will be removed later
	@Then("User filter the catalogue list page using filter \"([^\"]*)\"")
	public void filter_product_catalogue_list_page(String filtertype) {
		scenarioContext.setKeyValue(filtertype, "Vendor 4.0");
		objectManager.getProductCatalogueListPage().filterData(filtertype, scenarioContext.getContext(filtertype));
	}

	@Then("Title of each catalogue should have supplier and catalogue name")
	public void verify_title_of_each_catalogue() {
		objectManager.getProductCatalogueListPage().verifyContent(scenarioContext.getContext("supplier"));
	}

	@And("User clicks on edit button to view product details")
	public void user_clicks_on_edit_button_to_view_products() {
		objectManager.getProductCatalogueListPage().editProduct();
	}

	@And("Updated quantity will be replaced by previous value on clicking cancel button")
	public void update_qty_will_be_replaced_by_previous_value() {
//		objectManager.getproductDetailsPage().changeQuantity();
//		objectManager.getproductDetailsPage().cancelTheUpdatedQuantity();

	}

	@And("User updates the stock quantity of a product")
	public void user_updates_the_stock_quantity_of_a_product() {
		objectManager.getproductDetailsPage().updateStockQuantity();
	}

	@Then("Title of each catalogue should not have other supplier and catalogue name")
	public void Title_of_each_catalogue_should_not_have_other_supplier_and_catalogue_name() {
		objectManager.getProductCatalogueListPage().verifyContent(scenarioContext.getContext("supplier"));
	}

	@Then("On updating \"([^\"]*)\" stock quantity an warning message will be displayed")
	public void on_updating_stock_quantity_an_warning_message_will_be_displayed(String inputTyp) {
		objectManager.getproductDetailsPage().checkWarningMessageOnStockField(inputTyp);
	}
	
	//Filter StepDefination
	
	@Given("User counts the given filter value {string} in the PCLP table {string} applying filter {string}")
	public void user_counts_the_given_filter_value_in_the_PCLP_table_applying_filter(String filterValue, String before, String filter) throws MalformedURLException, InterruptedException{
	    
		objectManager.getProductCatalogueListPage().checkTotalRowsCountOfSelectedCAR(filterValue, before, filter);
	}
	
	@Given("User selects the value {string} from the filter {string}")
	public void user_selects_the_value_from_the_filter(String value, String filter) throws Exception{
		
		objectManager.getProductCatalogueListPage().filterData(filter, value);
	}
	
	
	@When("User clicks on Search button")
	public void user_clicks_on_Search_button() throws Exception{
	 
		objectManager.getProductCatalogueListPage().searchButton();
	}
	
	
	@Then("Verify the filter {string} with result value {string}")
	public void verify_the_filter_with_result_value(String fillter, String filterValue) {
	   
		objectManager.getProductCatalogueListPage().verifyFilterValue(fillter, filterValue);
	}
	
	

}
