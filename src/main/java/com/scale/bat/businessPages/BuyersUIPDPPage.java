package com.scale.bat.businessPages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.scale.bat.framework.utility.Actions;
import com.scale.bat.framework.utility.ConfigurationReader;
import com.scale.bat.framework.utility.DateTimeUtils;
import com.scale.bat.framework.utility.Log;

import cucumber.api.Scenario;

public class BuyersUIPDPPage extends Actions {

	private Logger log = Log.getLogger(BuyersUIPDPPage.class);
	private ConfigurationReader configReaderObj;
	
	//@FindBy(xpath = "//*[@id='main-content']/div/div[2]/div[2]/p/span[2]")
	@FindBy(xpath ="//*[@class='bat-product__price--price']")
	private WebElement priceOnPdP;
	
	//@FindBy(xpath = "//*[@id='main-content']/div/div[2]/div[2]/p[3]/span[2]")
	@FindBy(xpath = "//*[@class='bat-product__info--sku']")
	private WebElement mpnNumber;
	
	//@FindBy(xpath = "//*[@id='main-content']/div/div[2]/div[2]/p[3]/span[1]")
	@FindBy(xpath = "//*[@class='bat-product__info--company']")
	private WebElement manufaturer;

	public BuyersUIPDPPage(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(super.driver, 30);
		configReaderObj = new ConfigurationReader();
	}

	public void verifyProductDetails(Map<String, Object> pDetails) {
		waitForSeconds(2);
		assertTrue(getText(priceOnPdP).replaceAll("[^a-zA-Z0-9]","").contains(pDetails.get("Price").toString().replaceAll("[^a-zA-Z0-9]","")));
		assertEquals(getText(mpnNumber), pDetails.get("MPN").toString());
		assertEquals(getText(manufaturer), pDetails.get("ManufacturerName").toString());
		log.info("Validation completed on buyer UI");
	}
	
	
	
	
	
public void verifyLastUpdatedProductDetails(Map<String, Object> pDetails, String Supplier) {
		
		String supplierName=configReaderObj.adminPanelSupplierName(Supplier);
		String SKU=pDetails.get("SKU").toString();
		String[] splitDate = new DateTimeUtils().dateWithSpecificFormatt("dd/MMMM/yyyy").split("/");
		String Stock=pDetails.get("LocalStockVolume").toString();
		String Price=pDetails.get("Price").toString();
		String StandardChargeProductUKMainland=pDetails.get("StandardChargeProductUKMainland").toString();
		double TotalCostint=Double.parseDouble(Price);
		double StandardChargeProductUKMainlandint=Double.parseDouble(StandardChargeProductUKMainland);
		TotalCostint=TotalCostint+StandardChargeProductUKMainlandint;
		String TotalCost= Double.toString(TotalCostint);
		String LastUpdateProduct="//tbody[@class='govuk-table__body']/tr[1]/td[text()="+"'"+supplierName+"'"+"]"+"/following-sibling::td[2][text()="+"'"+SKU+"'"+"]"+"/following-sibling::td[text()="+"'"+Stock+"'"+"]"+"/following-sibling::td[contains (text(),"+"'"+Price+"')"+"]"+"/following-sibling::td[contains (text(),"+"'"+StandardChargeProductUKMainland+"')"+"]"+"/following-sibling::td[contains (text(),"+"'"+TotalCost+"')"+"]";
		//Validate the latest updated Product price should be shown at the top of the price table if 2 products of the different supplier having cheapest price
		assertTrue("Last Updated Product having cheapest Price table is not visible in top of the price table",existsElement(LastUpdateProduct));
		log.info("Validation of Last Updated Product having cheapest Price is visible in top of the price table is successful");
		
		String chepestProductPriceOnTopLeft="//span[text()='Product Unit Cost From']/following-sibling::span[contains (text(),"+"'"+Price+"')"+"]";
		assertTrue("Last Updated Product having cheapest Price table is not visible in top of the price table",existsElement(chepestProductPriceOnTopLeft));
		log.info("Validation of 'Best Price' "+ Price+ " of the product in top left of the PDP is successful");
		
	}
	
}
