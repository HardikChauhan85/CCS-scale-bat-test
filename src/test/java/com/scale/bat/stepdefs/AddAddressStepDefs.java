package com.scale.bat.stepdefs;

import com.scale.bat.businessPages.BuyersUIpage;
import com.scale.bat.context.ScenarioContext;
import com.scale.bat.context.TestContext;
import com.scale.bat.framework.utility.Log;
import com.scale.bat.framework.utility.PageObjectManager;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.apache.log4j.Logger;

import java.util.List;

public class AddAddressStepDefs {
    private Logger log = Log.getLogger(BuyersUIpage.class);

    private PageObjectManager objectManager;
    public ScenarioContext scenarioContext;

    public AddAddressStepDefs(TestContext testContextObj, ScenarioContext scenarioContext) {
        testContextObj.getDriver();
        objectManager = testContextObj.getObjectManager();
        this.scenarioContext = scenarioContext;
    }


    @When("I enter the following data:")
    public void i_enter_the_following_data(DataTable dataTable) throws Throwable {

        List<List<String>> data = dataTable.asLists();
        final String userFirstName = data.get(1).get(0);
        final String userLastName = data.get(1).get(1);
        final String userBuildingStreet = data.get(1).get(2);
        final String userCity = data.get(1).get(3);
        final String userPostcode = data.get(1).get(4);
        final String userPhoneNumber = data.get(1).get(5);

        objectManager.getAddAddressPage().enterText(objectManager.getAddAddressPage().getFirstName(), userFirstName);
        objectManager.getAddAddressPage().enterText(objectManager.getAddAddressPage().getLastName(), userLastName);
        objectManager.getAddAddressPage().enterText(objectManager.getAddAddressPage().getBuildingStreet(), userBuildingStreet);
        objectManager.getAddAddressPage().enterText(objectManager.getAddAddressPage().getCity(), userCity);
        objectManager.getAddAddressPage().enterText(objectManager.getAddAddressPage().getPostCode(), userPostcode);
        objectManager.getAddAddressPage().enterText(objectManager.getAddAddressPage().getPhoneNumber(), userPhoneNumber);

    }

    @When("User selects {string} from the country drop down option")
    public void user_selects_from_the_country_drop_down_option(String string) {
        objectManager.getAddAddressPage().selectCountry(string);
    }

    @When("User clicks on Add new address button")
    public void user_clicks_on_Add_new_address_button() {
        objectManager.getAddAddressPage().addNewAddressButton();
    }

    @When("User clicks on cancel add address button")
    public void user_clicks_on_cancel_add_address_button() {
        objectManager.getAddAddressPage().cancelButton();
    }

    @Then("I should see address validation error messages")
    public void i_should_see_address_validation_error_messages(){

        objectManager.getAddAddressPage().validateAddressFieldError()
        ;

    }

    @Then("I should see invalid postcode error messages")
    public void i_should_see_invalid_postcode_error_messages(){

        objectManager.getAddAddressPage().invalidPostcodeError()
        ;

    }
}
