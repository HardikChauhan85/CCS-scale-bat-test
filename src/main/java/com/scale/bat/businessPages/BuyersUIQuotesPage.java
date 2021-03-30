package com.scale.bat.businessPages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
import com.scale.bat.framework.utility.API.APIBase;

import cucumber.api.Scenario;

public class BuyersUIQuotesPage extends Actions{
	
	
	private Logger log = Log.getLogger(BuyersUIPDPPage.class);
	private ConfigurationReader configReaderObj;
	APIBase apiBase=new APIBase();
	
	/**
	 * Class level variable decleration
	 */
	public static String firstRowQuoteNo;
	public static String quoteNameWithCurrenntday;
	public static String supplierNameBasketPage;
	public static String totalPriceBasketPage;
	public static String rejectreasonWithCurrenntday;
	
	
	/**
	 * Class level Objects decleration
	 */
	@FindBy(xpath = "//*[@id='name']")
	 private WebElement quoteName;
	
	@FindBy(xpath = "//table[@class='govuk-table bat-quotes__table']/tbody/tr[1]/td[1]/a")
	 private WebElement getFirstRowQuoteNo;
	
	@FindBy(xpath = "//table[@class='govuk-table bat-quotes__table']/tbody/tr[1]/td[2]")
	 private WebElement getFirstRowQuoteName;
	
	@FindBy(xpath = "//table[@class='govuk-table bat-quotes__table']/tbody/tr[1]/td[3]")
	 private WebElement getFirstRowdateQuoteRaised;
	
	@FindBy(xpath = "//table[@class='govuk-table bat-quotes__table']/tbody/tr[1]/td[4]")
	 private WebElement getFirstRowSupplierName;
	
	@FindBy(xpath = "//table[@class='govuk-table bat-quotes__table']/tbody/tr[1]/td[5]")
	 private WebElement getFirstRowType;
	
	@FindBy(xpath = "//table[@class='govuk-table bat-quotes__table']/tbody/tr[1]/td[6]")
	 private WebElement getFirstRowExpiryDate;
	
	@FindBy(xpath = "//table[@class='govuk-table bat-quotes__table']/tbody/tr[1]/td[7]")
	 private WebElement getFirstRowTotalValueIncVAT;
	
	@FindBy(xpath = "//table[@class='govuk-table bat-quotes__table']/tbody/tr[1]/td[8]")
	 private WebElement getFirstRowStatus;
	
	@FindBy(xpath = "//h3[@class='govuk-heading-s bat-basket-items-by-supplier__item__supplier__name']")
	 private WebElement getSupplierNameBasketPage;
	
	@FindBy(xpath = "//div[@class='bat-basket__footer']/div[2]/ul/li[3]/span[2]")
	 private WebElement getTotalPriceBasketPage;
	
	//Table data in Admin UI
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr[1]/td[1]/a")
	 private WebElement getFirstRowQuoteNoAdminUI;
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr[1]/td[2]")
	 private WebElement getDateQuoteRaisedAdminUI;
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr[1]/td[4]")
	 private WebElement getTotalValueIncVATAdminUI;
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr[1]/td[5]")
	 private WebElement getExpiryDateAdminUI;
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr[1]/td[6]")
	 private WebElement getQuoteStatusAdminUI;
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr[1]/td[7]/a")
	 private WebElement getQuoteStatusRejectedI;
	
	@FindBy(xpath = "//h1[@class='contextual-title px-0 mb-0 col']")
	 private WebElement rejectQuotePageTitleAdminUI;
	
	@FindBy(xpath = "//table[@class='table']/following-sibling::div/div[1]")
	 private WebElement rejectQuoteStatusInAdminUI;
	
	
	@FindBy(xpath = "//textarea[@name='scale_quote[rejection_reason]']")
	 private WebElement rejectReasonTextboxRejectQuotePageAdminUIWebElement;
	
	private String rejectReasonTextboxRejectQuotePageAdminUI = "//textarea[@name='scale_quote[rejection_reason]']";
	private String rejectButtonRejectQuotePageAdminUI = "//span[@class='translation_missing']";
	private String cancleButtonRejectQuotePageAdminUI = "//a[@class='btn btn-outline-secondary']";
	
	
	//Other Object
	@FindBy(xpath = "//*[@name='number']")
	 private WebElement quoteReference;
	
	@FindBy(xpath = "//a[@href='/admin/quotes']")
	 private WebElement quoteLinkAdminPanel;
	
	@FindBy(xpath = "//button[@class='btn btn-primary ']")
	 private WebElement searchButtonAdminPanel;
	
	
	
	private String manageQuoteColumHeaderSize = "//table[@class='govuk-table bat-quotes__table']/thead/tr";
	private String firmQuote = "//*[@id='kind']";
	private String indicativeQuote = "//*[@id='kind-2']";
	private String raiseQuote = "Raise quote";
	
	
	public BuyersUIQuotesPage(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(super.driver, 30);
		configReaderObj = new ConfigurationReader();
	}
	
	
	public void validateNewQuoteCreatedMsg(String Message) {
		
		assertEquals(getText(Message), Message);
		log.info("New Quote created message : " + Message + " is validated");
	}
	
	public void enterQuoteNameInQuoteTextbox(String QuoteName) {
		
		String Currenntday = new DateTimeUtils().dateWithSpecificFormatt("dd/MM/yyyy HH:mm:ss");
		quoteNameWithCurrenntday = QuoteName.concat("-").concat(Currenntday);
		enterText(quoteName, quoteNameWithCurrenntday);
		log.info("Quote name is entered as " + QuoteName);
		
	}
	
	public void getSupplierNameAndTotalAmountOnBasketPage() {
		
		supplierNameBasketPage = getText(getSupplierNameBasketPage);
		totalPriceBasketPage = getText(getTotalPriceBasketPage);
		log.info(" Supplier name " +supplierNameBasketPage+ " and Total price " +totalPriceBasketPage+ " in basket page ");
		
	}
	
	public void getNewQuoteRefrenceNo() {
		
		firstRowQuoteNo=getText(getFirstRowQuoteNo);
		log.info("New Quote refrence no : " + firstRowQuoteNo + " is validated");
	}
	
	public void enterQuoteNoInQuoteReferenceTextbox() {
		
		enterText(quoteReference, firstRowQuoteNo);
		
	}
	
	
	public void validateQuoteTableColumnHeaders() {
		
		int allValues = getElementsSizeByXpath(manageQuoteColumHeaderSize,driver);
		//Get the length
	    System.out.println(allValues);
	    //Creating arraylist with the column headers  
	    ArrayList<String> manageQuotePageTableHeaders=new ArrayList<String>();
	    //Adding object in arraylist 
	    manageQuotePageTableHeaders.add("Quote reference");
	    manageQuotePageTableHeaders.add("Quote name");    
	    manageQuotePageTableHeaders.add("Date quote raised");
	    manageQuotePageTableHeaders.add("Supplier name");
	    manageQuotePageTableHeaders.add("Type");
	    manageQuotePageTableHeaders.add("Expiry date");
	    manageQuotePageTableHeaders.add("Total value inc. VAT");
	    manageQuotePageTableHeaders.add("Status");

	    // Loop to print and validate Manage quote table headers one by one
	    for (int j = 0; j < allValues; j++) {
	    	System.out.println(getTextXpath("//table[@class='govuk-table bat-quotes__table']/thead/tr/th["+j+"]").equals(manageQuotePageTableHeaders.get(j)));
	    	assertEquals(getTextXpath("//table[@class='govuk-table bat-quotes__table']/thead/tr/th["+j+"]"), manageQuotePageTableHeaders.get(j));
	
	    }
	
	    log.info("Validated Manage Quotes Column Header on Manage quotes Page");
		
	}
	
	
	public void validateNewQuoteDetails(String quoteType, String statusAccepted) {
		
		String Currenntday = new DateTimeUtils().dateWithSpecificFormatt("dd/MM/yyyy");
		String supplierNameUI = getText(getFirstRowSupplierName);
		String[] splitSupplierName = supplierNameUI.split("\\r?\\n");
		String actualSupplierNameUI=splitSupplierName[0];
		
		assertEquals(getText(getFirstRowQuoteNo), firstRowQuoteNo);
		assertEquals(getText(getFirstRowQuoteName), quoteNameWithCurrenntday);
		assertEquals(getText(getFirstRowdateQuoteRaised), Currenntday);
		assertEquals(actualSupplierNameUI, supplierNameBasketPage);
		assertEquals(getText(getFirstRowType), quoteType);
		//assertEquals(getText(getFirstRowExpiryDate), );
		assertEquals(getText(getFirstRowTotalValueIncVAT), totalPriceBasketPage);
		assertEquals(getText(getFirstRowStatus), statusAccepted);
		
	    log.info("Validated Manage Quotes Column Header on Manage quotes Page");
		
	}
	
	
	public void validateNewQuoteDetailsOnAdminUI(String statusAccepted) {
		
		String Currenntday = new DateTimeUtils().dateWithSpecificFormatt("dd/MM/yyyy");
		
		assertEquals(getText(getFirstRowQuoteNoAdminUI), firstRowQuoteNo);
		assertEquals(getText(getDateQuoteRaisedAdminUI), Currenntday);
		assertEquals(getText(getTotalValueIncVATAdminUI), totalPriceBasketPage);
		//assertEquals(getText(getExpiryDateAdminUI), );
		assertEquals(getText(getQuoteStatusAdminUI), statusAccepted);
		assertEquals(getText(getQuoteStatusRejectedI), "Reject");
		
	    log.info("Validated Manage Quotes refrence "+getFirstRowQuoteNoAdminUI+" details on Admin UI");
		
	}
	
	public void validateRejectQuotePage(String rejectQuotePageTitle) {
		
		String rejectQuotePageTitleWithQuoteNo = rejectQuotePageTitle.concat(firstRowQuoteNo);
		assertEquals(getText(rejectQuotePageTitleAdminUI), rejectQuotePageTitleWithQuoteNo);
		log.info("Validated Reject Quotes page title : "+rejectQuotePageTitleAdminUI);
		
	}
	
	public void validateManageQuotePage(String manageQuotePageTitle) {
		
		String manageQuotePageTitleWithQuoteNo = manageQuotePageTitle.concat(" / ").concat(firstRowQuoteNo);
		assertEquals(getText(rejectQuotePageTitleAdminUI), manageQuotePageTitleWithQuoteNo);
		log.info("Validated Manage Quotes page title : "+rejectQuotePageTitleAdminUI);
		
	}
	
	public void validateRejectQuotePageTextBoxRejectAndCancleButton(String rejectButton, String cancleButton) {
		
		assertTrue("Reject Reason textbox exist ", existsElement(rejectReasonTextboxRejectQuotePageAdminUI));
		assertTrue("Reject Reason textbox exist ", existsElement(rejectButtonRejectQuotePageAdminUI));
		assertTrue("Reject Reason textbox exist ", existsElement(cancleButtonRejectQuotePageAdminUI));
		log.info("Validated Reject Quotes page Reject reason Textbox, Reject and cancle Button ");
		
	}
	
	public void enterRejectReasonInTextBox(String rejectreason) {
		String Currenntday = new DateTimeUtils().dateWithSpecificFormatt("dd/MM/yyyy HH:mm:ss");
		rejectreasonWithCurrenntday = rejectreason.concat("-").concat(Currenntday);
		enterText(rejectReasonTextboxRejectQuotePageAdminUIWebElement, rejectreasonWithCurrenntday);
		log.info("Quote name is entered as " + rejectreasonWithCurrenntday);
		
	}
	
	public void validateStatusAndRejectReasonOnManageQuote(String rejectStatus) {
		assertEquals(getText(rejectQuoteStatusInAdminUI), rejectStatus);
		//assertEquals(getText(rejectQuoteStatusInAdminUI), rejectreasonWithCurrenntday);
		log.info("Validated reject quote Status "+rejectQuoteStatusInAdminUI+ " and Reason "+rejectreasonWithCurrenntday +" on Manage Quote page");
		
	}
	
	
	
	public void enterQuoteNoInQuoteReferenceTextboxAdminUI() {
		
		enterText(quoteReference, firstRowQuoteNo);
		
	}
	
	public String getFirmQuoteElement() {
		return firmQuote;
	}
	
	public String getIndicativeQuoteElement() {
		return indicativeQuote;
	}
	
	public String getRaiseQuoteLink() {
		return raiseQuote ;
	}
	
	public WebElement getQuoteLinkAdminPanel() {
		return quoteLinkAdminPanel;
	}
	
	public WebElement getSearchButtonAdminPanel() {
		return searchButtonAdminPanel;
	}
	
	public WebElement getRejectLinkAdminUI() {
		return getQuoteStatusRejectedI;
	}
	
	public String getRejectButtonAdminUI() {
		return rejectButtonRejectQuotePageAdminUI;
	}

}
