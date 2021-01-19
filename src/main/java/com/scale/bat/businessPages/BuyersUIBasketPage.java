package com.scale.bat.businessPages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.apache.commons.math3.geometry.euclidean.twod.Line;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.scale.bat.framework.utility.Actions;
import com.scale.bat.framework.utility.ConfigurationReader;
import com.scale.bat.framework.utility.JsonParser;
import com.scale.bat.framework.utility.Log;

import cucumber.api.Scenario;

public class BuyersUIBasketPage  extends Actions{
	
	private Logger log = Log.getLogger(BuyersUIPDPPage.class);
	private ConfigurationReader configReaderObj;

	public BuyersUIBasketPage(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(super.driver, 30);
		configReaderObj = new ConfigurationReader();
	}
	
	
	@FindBy(xpath ="//*[@id='main-content']/div/div/div/div[1]/ul/li[1]/div/div/table/tbody/tr/td[5]")
	private WebElement priceOnBasket;
	
	@FindBy(xpath = "")
	private WebElement manufaturerBasket;
	
	@FindBy(xpath ="//*[@id='main-content']/div/div/div/div[1]/ul/li[1]/div/form/div/div[2]/a")
	private WebElement productNameBasket;
	
	@FindBy(xpath ="//*[@id='main-content']/div/div/div/div[1]/ul/li[1]/div/div/table/tbody/tr/td[2]")
	private WebElement skuBasket;
	
	@FindBy(xpath ="//*[@id='main-content']/div/div/div/div[1]/ul/li[1]/div/form/div/div[2]/span")
	private WebElement mpnBasket;
	
	@FindBy(xpath ="//*[@id='main-content']/div/div/div/div[1]/ul/li[1]/div/div/table/tbody/tr/td[4]")
	private WebElement qtyBasket;
			
	@FindBy(xpath ="//*[@id='confirmation-message-title']")
	private WebElement productAddToBasketMsg;
	
	@FindBy(xpath ="//*[@class='bat-confirmation-message__title']")
	private WebElement allProductsWereAddedToYourBasket;
	
	@FindBy(xpath ="//*[@class='govuk-warning-text__text']")
	private WebElement YouCannotAddTheSelectedProductToTheBasketItsOutOfStockMsg;
	
	
	
	
//	public void verifyProductDetailsOnBasketPage(Map<String, Object> pDetails) {
	public void verifyProductDetailsOnBasketPage(String path) {
		waitForSeconds(2);
		
		JSONObject jObj = new JSONObject(new JsonParser().convertJsonToString(path));
		//Retrieving the array
        JSONArray jsonArray = (JSONArray) jObj.getJSONArray("data");
        for(int i=0;i<jsonArray.length();i++) {
          		
        	JSONObject obj=jsonArray.getJSONObject(i);
        	JSONObject attributes=obj.getJSONObject("attributes");
        	int j=i+1;
        	
        	
        	System.out.println("productPriceUI = " + getTextXpath("//*[@id='main-content']/div/div/div/div[1]/ul/li["+j+"]/div/div/table/tbody/tr/td[5]").replaceAll("[^a-zA-Z0-9]","") + " jsonPrice = " + attributes.getString("display_price").replaceAll("[^a-zA-Z0-9]",""));
        	
        	System.out.println("productNameUI = " + getTextXpath("//*[@id='main-content']/div/div/div/div[1]/ul/li["+j+"]/div/form/div/div[2]/a") + " jsonproductName = " + attributes.getString("name"));
        	
        	System.out.println("skuUI = " + getTextXpath("//*[@id='main-content']/div/div/div/div[1]/ul/li["+j+"]/div/div/table/tbody/tr/td[2]") + " jsonsku = " + attributes.getString("SKU"));
        	
        	System.out.println("MPNUI = " + getTextXpath("//*[@id='main-content']/div/div/div/div[1]/ul/li["+j+"]/div/form/div/div[2]/span") + " jsonMPN = " + attributes.getString("mpn_number"));
        	
        	
        	
        	//Product Price UI
        	assertTrue(getTextXpath("//*[@id='main-content']/div/div/div/div[1]/ul/li["+j+"]/div/div/table/tbody/tr/td[5]").replaceAll("[^a-zA-Z0-9]","").contains(attributes.getString("display_price").replaceAll("[^a-zA-Z0-9]","")));
        	
        	//Product Name Validation
        	assertTrue(getTextXpath("//*[@id='main-content']/div/div/div/div[1]/ul/li["+j+"]/div/form/div/div[2]/a").contains(attributes.getString("name")));
        	        	        	
        	//SKU Validation
        	assertTrue(getTextXpath("//*[@id='main-content']/div/div/div/div[1]/ul/li["+j+"]/div/div/table/tbody/tr/td[2]").contains(attributes.getString("SKU")));
        	
        	//MPN
        	assertTrue(getTextXpath("//*[@id='main-content']/div/div/div/div[1]/ul/li["+j+"]/div/form/div/div[2]/span").contains(attributes.getString("mpn_number")));
        		
    		log.info("Validation completed on Basket Page UI");
        	
        	
		
	}

	}
	
	
	public void verifyMessageAllProductsWereAddedToYourBasket() {
		
		assertEquals(getText(allProductsWereAddedToYourBasket), "All products were added to your basket");
	}
	
	public void verifyMessageProductAddToBasketMsg() {
		
		assertEquals(getText(productAddToBasketMsg), "Product added to your basket");
	}
	
	public void VerifyMessageItsOutOfStock() {
		String contents = getText(YouCannotAddTheSelectedProductToTheBasketItsOutOfStockMsg);
		String[] lines = contents.split("\\r?\\n");
		System.out.println("OUT Of Stock SPLIT 0 " + lines[0]);
		System.out.println("OUT Of Stock SPLIT 1 " + lines[1]);
		System.out.println("OUT Of Stock MGS " + getText(YouCannotAddTheSelectedProductToTheBasketItsOutOfStockMsg));
		
		assertEquals(lines[1], "You cannot add the selected product to the basket. It's out of stock.");
	}
	
	
	
	
}
