package com.scale.bat.businessPages;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.scale.bat.framework.utility.Actions;
import com.scale.bat.framework.utility.DateTimeUtils;
import com.scale.bat.framework.utility.Log;

import cucumber.api.Scenario;

public class SupplierPage extends Actions {
	private Logger log = Log.getLogger(SupplierPage.class);
	public SupplierPage(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, 30);
	}

	@FindBy(xpath = "//*[@id='main-part']/div[1]/div/div/a")
	private WebElement newSupplier;
	
	@FindBy(xpath = "//*[@id='vendor_name_field']/input")
	private WebElement supplierName;
	
	@FindBy(xpath = "//*[@id='vendor_about_us_field']")
	private WebElement aboutUs;
	
	@FindBy(xpath = "//*[@id='vendor_contact_us_field']")
	private WebElement contactUs;
	
	@FindBy(xpath = "//*[@id='s2id_vendor_state']")
	private WebElement state;
	
	@FindBy(xpath = "//*[@id='select2-drop']/ul/li[1]")
	private WebElement selectState;
	
	private String createButton = "Create";

	public void createSupplier() {
		String date = new DateTimeUtils().dateWithSpecificFormatt("yyyyMMdd hhmmss");
		assertTrue(newSupplier.isDisplayed());
		clickElement(newSupplier);
		enterText(supplierName, "Auto-".concat(date));
		assertTrue(supplierName.isDisplayed());
		clickElement(state);
		clickElement(selectState);
		assertTrue(state.isDisplayed());
		assertTrue(aboutUs.isDisplayed());
		assertTrue(contactUs.isDisplayed());
		clickButton(createButton);
		waitForSeconds(2);
		log.info("Supplier created - " +"Auto-".concat(date));
	}
	
}

