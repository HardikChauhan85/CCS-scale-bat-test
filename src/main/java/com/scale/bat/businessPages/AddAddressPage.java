package com.scale.bat.businessPages;

import com.scale.bat.framework.utility.Actions;
import com.scale.bat.framework.utility.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.scale.bat.framework.utility.Log;

import cucumber.api.Scenario;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddAddressPage extends Actions {

    private Logger log = Log.getLogger(AddAddressPage.class);
    private ConfigurationReader configReaderObj;

    public AddAddressPage(WebDriver driver, Scenario scenario) {
        super.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(super.driver, 30);
    }

    @FindBy(xpath = "//*[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//*[@name='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//*[@name='address1']")
    private WebElement addressLineOne;

    @FindBy(xpath = "//*[@name='city']")
    private WebElement city;

    @FindBy(xpath = "//*[@name='zipcode']")
    private WebElement postcode;

    @FindBy(xpath = "//*[@name='phone']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//select[@id='state']")
    private WebElement walesDropdownOption;

    @FindBy(xpath = "//button[@class='govuk-button govuk-!-margin-right-6']")
    private WebElement addressButton;

    @FindBy(xpath = "//button[@class='govuk-button govuk-!-margin-right-6']")
    private WebElement addressCancelButton;

    @FindBy(xpath = "//a[@class='govuk-button govuk-button--secondary']")
    private WebElement addressFieldValidationError;

    @FindBy(xpath = "//ul[@class='govuk-list govuk-error-summary__list']/li[1]")
    private WebElement firstNameErrorMessage;

    @FindBy(xpath = "//ul[@class='govuk-list govuk-error-summary__list']/li[2]")
    private WebElement lastNameErrorMessage;

    @FindBy(xpath = "//ul[@class='govuk-list govuk-error-summary__list']/li[3]")
    private WebElement addressStreetErrorMessage;

    @FindBy(xpath = "//ul[@class='govuk-list govuk-error-summary__list']/li[4]")
    private WebElement townErrorMessage;

    @FindBy(xpath = "//ul[@class='govuk-list govuk-error-summary__list']/li[5]")
    private WebElement countryErrorMessage;

    @FindBy(xpath = "//ul[@class='govuk-list govuk-error-summary__list']/li[6]")
    private WebElement postcodeErrorMessage;

    @FindBy(xpath = "//span[@id='zipcode-error']")
    private WebElement invalidPostcodeMessage;

    String addressError = "//ul[@class='govuk-list govuk-error-summary__list']";

    public void enterText(WebElement element, String text) {
        waitForSeconds(1);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(text);
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getBuildingStreet() {
        return addressLineOne;
    }

    //
    public WebElement getCity() {
        return city;
    }

    public WebElement getPostCode() {
        return postcode;
    }

    public WebElement getPhoneNumber() {
        return phoneNumber;
    }

    public void selectCountry(String country) {
        waitForSeconds(1);
        selectItemFromDropDown(walesDropdownOption, country);
        waitForSeconds(1);
    }

    public void addNewAddressButton() {
        clickElementXpath(addressButton);
    }

    public void cancelButton() {
        clickElementXpath(addressCancelButton);
    }

    public void validateAddressFieldError() {

        assertTrue(getText(firstNameErrorMessage).equals("First name is not allowed to be empty"));
        assertTrue(getText(lastNameErrorMessage).equals("Last name is not allowed to be empty"));
        assertTrue(getText(addressStreetErrorMessage).equals("Building and street line 1 of 2 is not allowed to be empty"));
        assertTrue(getText(townErrorMessage).equals("Town or city is not allowed to be empty"));
        assertTrue(getText(countryErrorMessage).equals("Country is not allowed to be empty"));
        assertTrue(getText(postcodeErrorMessage).equals("Postcode is not allowed to be empty"));

    }

    public void invalidPostcodeError() {

        assertTrue(getText(invalidPostcodeMessage).equals("Postcode is invalid"));
    }


}



