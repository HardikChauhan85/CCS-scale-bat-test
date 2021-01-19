package com.scale.bat.businessPages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

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

public class BuyersUIMyListPage extends Actions  {
	
	private Logger log = Log.getLogger(BuyersUIPDPPage.class);
	private ConfigurationReader configReaderObj;
	
	public BuyersUIMyListPage(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(super.driver, 30);
		configReaderObj = new ConfigurationReader();
	}
	

		@FindBy(xpath ="//*[@id='main-content']/div[1]/div/ul/li[1]/div/div[3]/div/span")
		private WebElement priceOnMyList;
		
		@FindBy(xpath = "//*[@id='main-content']/div[1]/div/ul/li[1]/div/div[2]/div/span[1]")
		private WebElement manufaturerMyList;
		
		@FindBy(xpath ="//*[@id='main-content']/div[1]/div/ul/li[1]/div/div[2]/div/a")
		private WebElement productNameMyList;
		
		@FindBy(xpath ="//*[@id='main-content']/div[1]/div/ul/li[1]/div/div[2]/div/span[2]")
		private WebElement skuMyList;
		
		@FindBy(xpath ="//*[@id='main-content']/div[1]/div/ul/li[1]/div/div[4]/form/button")
		private WebElement addToBasketButton;
		
		@FindBy(xpath ="//*[@class='govuk-button govuk-button--secondary']")
		private WebElement clearMyBasketAndAddTheseItemsbutton;
		
		@FindBy(xpath ="//*[@class='govuk-button govuk-button--primary']")
		private WebElement addTheseItemsToCurrentBasketbutton;
		
		
		
	
	
//	public void verifyProductDetailsOnMyListPage(Map<String, Object> pDetails, String path) {
		public void verifyProductDetailsOnMyListPage(String path) {
		waitForSeconds(2);
		
		JSONObject jObj = new JSONObject(new JsonParser().convertJsonToString(path));
		//Retrieving the array
        JSONArray jsonArray = (JSONArray) jObj.getJSONArray("data");
        for(int i=0;i<jsonArray.length();i++) {
          		
        	JSONObject obj=jsonArray.getJSONObject(i);
        	JSONObject attributes=obj.getJSONObject("attributes");
        	int j=i+1;
        	
        	System.out.println("productNameUI = " + getTextXpath("//*[@id='main-content']/div[1]/div/ul/li["+j+"]/div/div[2]/div/a") + " jsonproductName = " + attributes.getString("name"));
        	
        	System.out.println("ManiftrUI = " + getTextXpath("//*[@id='main-content']/div[1]/div/ul/li["+j+"]/div/div[2]/div/span[1]") + " jsonMfr = " + attributes.getString("manufacturer"));
        	
        	System.out.println("skuUI = " + getTextXpath("//*[@id='main-content']/div[1]/div/ul/li["+j+"]/div/div[2]/div/span[2]") + " jsonsku = " + attributes.getString("SKU"));
        	
        	//Product Name Validation
        	assertTrue(getTextXpath("//*[@id='main-content']/div[1]/div/ul/li["+j+"]/div/div[2]/div/a").contains(attributes.getString("name")));
        	        	
        	//Manufacturer Name Validation
        	assertTrue(getTextXpath("//*[@id='main-content']/div[1]/div/ul/li["+j+"]/div/div[2]/div/span[1]").contains(attributes.getString("manufacturer")));
        	//SKU Validation
        	assertTrue(getTextXpath("//*[@id='main-content']/div[1]/div/ul/li["+j+"]/div/div[2]/div/span[2]").contains(attributes.getString("SKU")));
        	
        	/*assertTrue(getText(productNameMyList).contains(attributes.getString("name")));
        	assertTrue(getText(manufaturerMyList).contains(attributes.getString("manufacturer")));
        	assertTrue(getText(skuMyList).contains(attributes.getString("SKU")));*/
        	log.info("Validation completed on MyList Page UI");
        	//assertTrue(getText(priceOnMyList).contains(attributes.getString("display_price")));
        	
	}
		
	}
        
	public void clickOnAddtoBasketButton() {
		
		clickElement(addToBasketButton);
		
	}
	
	public void clickOnClearMyBasketAndAddTheseItemsbutton() {
		
		clickElement(clearMyBasketAndAddTheseItemsbutton);
		
	}
	
	public void clickOnAddTheseItemsToCurrentBasketbutton() {
		
		clickElement(addTheseItemsToCurrentBasketbutton);
		
	}
	
	
	

}
