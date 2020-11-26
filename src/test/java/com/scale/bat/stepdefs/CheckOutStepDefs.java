package com.scale.bat.stepdefs;

import org.apache.log4j.Logger;
import com.scale.bat.context.ScenarioContext;
import com.scale.bat.context.TestContext;
import com.scale.bat.framework.utility.Log;
import com.scale.bat.framework.utility.PageObjectManager;

import cucumber.api.java.en.Given;

public class CheckOutStepDefs {
	private Logger log = Log.getLogger(CheckOutStepDefs.class);

	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;

	public CheckOutStepDefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}

	@Given("User completes the checkOut proccess")
	public void user_completes_the_checkOut_proccess() {
//		objectManager.getBuyersUIpage().navigateToCheckoutProcess();
		log.info("Started CheckOut Process");
		

	}
}
