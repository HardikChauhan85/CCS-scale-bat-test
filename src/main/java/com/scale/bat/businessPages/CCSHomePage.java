package com.scale.bat.businessPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.scale.bat.framework.utility.Actions;
import cucumber.api.Scenario;

public class CCSHomePage extends Actions {
	private WebDriver driver;
// Need to add returns more vairables for this page
	private String mainSideBar_Orders = "Orders";
	private String mainSideBar_ProductCatalogues = "Product Catalogues";
	private String mainSideBar_Returns = " Returns";
	private String mainSideBar_Promotions = " Promotions";
	private String mainSideBar_Users = "Users";
	private String mainSideBar_Configurations = " Configurations";
	private String mainSideBar_Vendors = "Suppliers";
	private String mainSideBar_Reports = "Reports";
		
	@FindBy(xpath = "/html/body/header/nav/div[2]/ul/li")
	private WebElement userName;
	
	@FindBy(xpath = "/html/body/header/nav/div[2]/ul/li/div/ul/li[1]/a")
	private WebElement logOut;
	
	public CCSHomePage(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, 30);
	}

	public void navigateToOrders() {
		clickElement(mainSideBar_Orders);
	}

	public void navigateToVendors() {
		clickElement(mainSideBar_Vendors);
	}

	public void navigateToProductCatalogues() {
		clickElement(mainSideBar_ProductCatalogues);
	}
	
	public void navigateToReturns() {
		clickElement(mainSideBar_Returns);
	}

	public void navigateToPromotions() {
		clickElement(mainSideBar_Promotions);
	}

	public void navigateToUsers() {
		clickElement(mainSideBar_Users);
	}
	
	public void navigateToConfigurations() {
		clickElement(mainSideBar_Configurations);
	}

	public void navigateToReports() {
		clickElement(mainSideBar_Reports);
	}
	
	public void logOff() {
		clickElement(userName);
		clickElement(logOut);
	}
	
	public void logOffAndClose() {
		waitForSeconds(1);
		clickElement(userName);
		waitForSeconds(1);
		clickElement(logOut);
	}
}
