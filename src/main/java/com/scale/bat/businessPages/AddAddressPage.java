package com.scale.bat.businessPages;

import com.scale.bat.framework.utility.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.scale.bat.framework.utility.Actions;
import com.scale.bat.framework.utility.Log;

import cucumber.api.Scenario;

public class AddAddressPage extends Actions {

    public AddAddressPage(WebDriver driver, Scenario scenario) {
        super.driver = driver;
        this.scenario = scenario;
    }

    public void customSendKeys(WebElement element, String value){
        element.sendKeys(value);
    }

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@name='address1']")
    private WebElement addressLineOne;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement city;

    @FindBy(xpath = "//input[@name='zipcode']")
    private WebElement postcode;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneNumber;


    public WebElement getFirstName(){
        return firstName;
    }

    public WebElement getLastName(){
        return lastName;
    }

    public WebElement getBuildingStreet(){
        return addressLineOne;
    }
    //
    public WebElement getCity(){
        return city;
    }

    public WebElement getPostCode(){
        return postcode;
    }

//	public WebElement getPhoneNumber(){
//		return phoneNumber();
//	}


}
