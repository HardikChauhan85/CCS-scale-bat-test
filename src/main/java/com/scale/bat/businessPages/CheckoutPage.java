package com.scale.bat.businessPages;

import static org.junit.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.scale.bat.framework.utility.Actions;
import com.scale.bat.framework.utility.Log;
import cucumber.api.Scenario;

public class CheckoutPage extends Actions{
	private Logger log = Log.getLogger(CheckoutPage.class);

	private WebDriver driver;
	private String checkoutLabel = "Checkout";
	private String confirmationLabel = "Confirmation";
	private String paymentLabel = "Payment by invoice";
	private String deliveryLabel = "Confirm delivery method";
	private String defaultDeliveryText= "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sic, et quidem diligentius saepiusque ista loquemur inter nos agemusque communiter.";
	private String defaultPaymentText= "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sic, et quidem diligentius saepiusque ista loquemur inter nos agemusque communiter.";
	
	
	
	@FindBy(xpath = "//*[@id='main-content']/form/div/div[2]/button/text()")
	private WebElement nextButton_Address;
	
	@FindBy(xpath = "//*[@id='main-content']/form/div/div[2]/button")
	private WebElement nextButton_Delivery;
		
	@FindBy(xpath = "//*[@id='main-content']/form/div/div[1]/div[2]/input")
	private WebElement Po_Payement;
	
	@FindBy(xpath = "//*[@id='tos-agreement']")
	private WebElement termsAndConditions;
	
	@FindBy(xpath = "//*[@id='main-content']/div[4]/div/form/div[2]/button")
	private WebElement placeOrder;
		
	public CheckoutPage(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, 30);
	}
	
	public void completeCheckOutProcess() {
		log.assertLog(isElementPresent(checkoutLabel), "Element is not present - Checkout process has not started");
		clickButton("Next");
		log.assertLog(isElementPresent(deliveryLabel), "delivery label not found- Checkout process has not started");
		assertTrue("Text not same", getText(defaultDeliveryText).equalsIgnoreCase(defaultDeliveryText));
		clickButton("Next");
		log.info("SCA-1103 and aditional validation covered for default text in delivery");
		log.assertLog(isElementPresent(paymentLabel), "Element is not present - Checkout process has not started");
		log.info("SCA-1106 validation passed");	
		clickButton("Next");
		clickElement(termsAndConditions);
		clickElement(placeOrder);		
	}
	
	

}
