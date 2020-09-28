package com.scale.bat.stepdefs;

import com.scale.bat.context.ScenarioContext;
import com.scale.bat.context.TestContext;
import com.scale.bat.framework.utility.PageObjectManager;

import cucumber.api.java.en.Then;

public class SupplierUIStepDefs {
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;

	public SupplierUIStepDefs(TestContext testContextObj, ScenarioContext context) {
		testContextObj.getDriver();
		this.objectManager = testContextObj.getObjectManager();
		this.scenarioContext = context;
	}

	@Then("User creates {int} supplier")
	public void user_creates_supplier(int numberOfSuppliers) {
		for (int i = 0; i < numberOfSuppliers; i++) {
			objectManager.getSupplierPage().createSupplier();
		}
	}

}
