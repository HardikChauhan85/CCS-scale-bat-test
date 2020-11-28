package com.scale.bat.businessPages;

import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.scale.bat.framework.utility.Actions;
import com.scale.bat.framework.utility.DateTimeUtils;
import cucumber.api.Scenario;

public class ProductCataloguePage extends Actions {

	private String newProductButton = "New Product";

	@FindBy(xpath = "//*[@id='product_mpn_number']")
	private WebElement mpnNumberTextBox;

	@FindBy(xpath = "//*[@id='new_product']/div/input")
	private WebElement createProductButton;

	@FindBy(xpath = "//*[@id='product_manufacturer_id_field']/div")
	private WebElement manufacturerName;

	@FindBy(xpath = "//*[@id='s2id_autogen1_search']")
	private WebElement manufacturerNameInput;

	@FindBy(xpath = "//*[@id='product_name']")
	private WebElement productName;

	@FindBy(xpath = "//*[@id='product_new_product_local_stock_volume_field']/input")
	private WebElement lockStockVolume;

	@FindBy(xpath = "//*[@id='product_price']")
	private WebElement price;

	@FindBy(xpath = "//*[@id='product_unspsc']")
	private WebElement UNSPSC;

	@FindBy(xpath = "//*[@id='product_sku']")
	private WebElement SKU;

	@FindBy(xpath = "//*[@id='s2id_product_tax_category_id']")
	//@FindBy(xpath = "//*[@id='s2id_product_tax_category_id']/a/span[2]")
	private WebElement taxCategory;
	
	//private String taxCategoryStr = "//*[@id='s2id_product_tax_category_id']/a/span[2]";
	private String taxCategoryStr = "//*[@id='s2id_product_tax_category_id']";

	@FindBy(xpath = "//*[@id='select2-results-1']/li[2]/div")
	private WebElement selectTaxCategory;
	
	//private String selectTaxCategoryStr = "//*[@id='select2-results-1']/li[2]/div";

	@FindBy(xpath = "//*[@id='product_available_on']")
	private WebElement publishFromDate;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement findButtonOnNewProduct;

	@FindBy(xpath = "//*[@id='product_delivery_charges_attributes_standard_delivery_available']")
	private WebElement standardDeliveryCheckBox;

	@FindBy(xpath = "//*[@id='product_delivery_charges_attributes_next_day_charge_product_uk_mainland']")
	private WebElement nextDayChargeProduct;

	@FindBy(xpath = "//*[@id='product_delivery_charges_attributes_next_day_charge_basket']")
	private WebElement nextDayChargeBasket;

	@FindBy(xpath = "//*[@id='main-part']/div[2]/div[1]/div")
	private WebElement successfulMessageforProductCreation;

	@FindBy(xpath = "//*[@id='content']/table/tbody/tr/td[7]/a[2]")
	private WebElement deleteFirstProduct;
	
	@FindBy(xpath = "//*[@id='product_delivery_charges_attributes_standard_charge_product_uk_mainland']")
	private WebElement StandardChargeProductUKMainland;
	
	@FindBy(xpath = "//*[@id='product_delivery_charges_attributes_standard_charge_basket']")
	private WebElement StandardChargeBasket;
	
	@FindBy(xpath = "//*[@id='product_delivery_charges_attributes_standard_charge_product_uk_non_mainland']")
	private WebElement StandardChargeProductUKNonMainland;
	
	@FindBy(xpath = "//*[@id='product_delivery_charges_attributes_standard_delivery_time']")
	private WebElement StandardDeliveryTimeIndays;
	
	@FindBy(xpath = "//*[@id='admin_new_product']")
	private WebElement PublishButton;
	
	
	
	public ProductCataloguePage(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, 30);
	}

	public void createNewProduct(JSONObject jObj) {
		clickElement(newProductButton);
		enterText(mpnNumberTextBox, jObj.getString("MPN"));
		waitForSeconds(2);
		clickElement(manufacturerName);
		waitForSeconds(3);
		enterText(manufacturerNameInput, jObj.getString("ManufacturerName"));
		waitForSeconds(3);
		selectManufacturer(jObj.getString("ManufacturerName"));
		waitForSeconds(2);
		clickElement(findButtonOnNewProduct);
		enterText(price, jObj.getString("Price"));
		enterText(lockStockVolume, jObj.getString("LocalStockVolume"));
		enterText(UNSPSC, "UNSPSC-Num");
		enterText(SKU, jObj.getString("SKU"));
		//enterText(SKU, "SKU00");
		//clickElement(standardDeliveryCheckBox);
		enterText(StandardChargeProductUKMainland, jObj.getString("StandardChargeProductUKMainland"));
		enterText(nextDayChargeProduct, jObj.getString("nextDayChargeProduct"));
		enterText(nextDayChargeBasket, jObj.getString("nextDayChargeBasket"));
		enterText(publishFromDate, new DateTimeUtils().dateWithSpecificFormatt("yyyy/MM/dd"));
		enterText(StandardChargeBasket, jObj.getString("StandardChargeBasket"));
		waitForSeconds(2);
		clickElement(taxCategory);
		//clickElementWithJavaScript(taxCategoryStr);
		waitForSeconds(2);
		
		
		clickElement(selectTaxCategory);
		//clickElementWithJavaScript(selectTaxCategoryStr);
		
		enterText(StandardChargeProductUKNonMainland, jObj.getString("StandardChargeProductUKNonMainland"));
		enterText(StandardDeliveryTimeIndays, jObj.getString("StandardDeliveryTimeIndays"));
		clickElement(createProductButton);
		
		waitForSeconds(2);
		assertTrue("Product is not created successfully..", isElementPresent("successfully created"));
		
		if(getText(PublishButton).contains("Publish")) {
			waitForSeconds(1);
			clickElement(PublishButton);
			waitForSeconds(2);
			assertTrue("Product is not created successfully..", isElementPresent("Published successfully"));
		}
		
		
	}

	public void deleteProduct() {
		clickElement(deleteFirstProduct);
		waitForAlert();
		driver.switchTo().alert().accept();
		waitForSeconds(2);
		assertTrue("Product is not deleted successfully..", isElementPresent("Product has been deleted"));
	}

	public void selectManufacturer(String manufacturerName) {
		waitForSeconds(2);
		String XPATH = "//div[@class='select2-result-label']/span[contains(text(),'" + manufacturerName + "')]";
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
		element.click();
		// log.info("User is ble to select the Manufacturer" + manufacturerName + " ");
		scenario.write(" User Clicked on " + manufacturerName + " button");
	}
}