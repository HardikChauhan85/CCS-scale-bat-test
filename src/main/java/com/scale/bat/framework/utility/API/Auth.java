package com.scale.bat.framework.utility.API;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.scale.bat.framework.utility.ConfigurationReader;

import cucumber.api.Scenario;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Auth extends APIBase {

    private ConfigurationReader configreader = new ConfigurationReader();
    public String ordertoken;
    public String access_hash;
    private WebDriver driver;
    
   /* public Auth(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, 30);
	}*/

    public  String getWishListResponse()
    {
         
        
         Response response = null;
        
                 //response = RestAssured.given().spec(setBaseURI()).contentType("application/x-www-form-urlencoded").body(obj).when().post("/spree_oauth/token");
         		response = RestAssured.given().spec(setBaseURI()).contentType("application/x-www-form-urlencoded").when().get("/spree_oauth/token");
                // response.prettyPrint();
         		System.out.println("response"+response.statusCode());
                 access_hash = response.then().extract().path("access_hash");
                 return access_hash;
     
    }
    
    public String Authenticaion() {
       // String username = configreader.adminPanelSupplierName("Supplier");                //.get("ccs.admin.panel.username.userrole.supplier");
        
        //String username = configreader.adminPanelUserName("supplier");  
        //String password = configreader.adminPanelPassword("supplier");                    //.get("ccs.admin.panel.password.userrole.supplier");
        
    	 //.get("ccs.admin.panel.apiusername.userrole.supplier");
        String username = configreader.apiUserName("supplier");  
        //.get("ccs.admin.panel.apipassword.userrole.supplier");
        String password = configreader.apiUserPassword("supplier");      
        
        String obj = "grant_type=password&username="+username+"&password="+password;
        System.out.println(obj);
        
       
        Response response = null;
       
                //response = RestAssured.given().spec(setBaseURI()).contentType("application/x-www-form-urlencoded").body(obj).when().post("/spree_oauth/token");
        		response = RestAssured.given().spec(setBaseURI()).contentType("application/x-www-form-urlencoded").body(obj).when().post("/spree_oauth/token");
               // response.prettyPrint();
        		System.out.println("response"+response.statusCode());
                ordertoken = response.then().extract().path("access_token");
                return ordertoken;
    }

}