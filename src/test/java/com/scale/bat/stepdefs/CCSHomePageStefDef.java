package com.scale.bat.stepdefs;

import org.apache.log4j.Logger;

import com.scale.bat.context.TestContext;
import com.scale.bat.framework.utility.Log;
import com.scale.bat.framework.utility.PageObjectManager;

import cucumber.api.java.en.And;

public class CCSHomePageStefDef {
	private Logger log = Log.getLogger(CCSHomePageStefDef.class);

	private PageObjectManager objectManager;

	public CCSHomePageStefDef(TestContext testContextObj) {
		objectManager = testContextObj.getObjectManager();
	}

	@And("User click on \"([^\"]*)\" link on main sidebar")
	public void user_click_on_link_on_main_sidebar(String linkText) {
		switch (linkText.toLowerCase()) {
		case "productcatalogues":
			objectManager.getCCSHomePage().navigateToProductCatalogues();
			objectManager.getScreeShot().takeSnapShot1();
			break;
		case "orders":
			objectManager.getCCSHomePage().navigateToOrders();
			objectManager.getScreeShot().takeSnapShot1();
			break;
		case " returns":
			objectManager.getCCSHomePage().navigateToReturns();
			break;
		case "promotions":
			objectManager.getCCSHomePage().navigateToPromotions();
			break;
		case "users":
			objectManager.getCCSHomePage().navigateToUsers();
			break;
		case "configurations":
			objectManager.getCCSHomePage().navigateToConfigurations();
			break;
		case "suppliers":
			objectManager.getCCSHomePage().navigateToVendors();
			break;
		case "reports":
			objectManager.getCCSHomePage().navigateToReports();
			break;
		default:
			log.info("Check the BDD for proper spellings or wrong link text");
		}

	}
	

}
