package com.scale.bat.stepdefs;

import java.net.MalformedURLException;

import com.scale.bat.context.ScenarioContext;
import com.scale.bat.context.TestContext;
import com.scale.bat.framework.utility.PageObjectManager;

import cucumber.api.java.en.Given;

public class ProductCataloguePageStepdef {
	
	
	private PageObjectManager objectManager;
	public ScenarioContext context;

	public ProductCataloguePageStepdef(TestContext testContextObj, ScenarioContext context) {
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.context = context;
	}
	
	
	@Given("User checks the count of filter value {string} present in the PCP result list {string} applying filter {string}")
	public void user_checks_the_count_of_filter_value_present_in_the_PCP_result_list_applying_filter(String filterValue, String before, String filter) throws MalformedURLException, InterruptedException{
	    
		objectManager.getProductCatalogueListPage().checkTotalRowCountsOfSelectedFilterInPCP(filterValue, before, filter);
	}
	
	

}
