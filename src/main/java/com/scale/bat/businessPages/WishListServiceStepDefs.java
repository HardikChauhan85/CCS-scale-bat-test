package com.scale.bat.businessPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.log4j.Logger;

import com.scale.bat.businessPages.BuyersUIpage;
import com.scale.bat.context.ScenarioContext;
import com.scale.bat.context.TestContext;
import com.scale.bat.framework.utility.ConfigurationReader;
import com.scale.bat.framework.utility.Log;
import com.scale.bat.framework.utility.PageObjectManager;
import com.scale.bat.framework.utility.API.APIBase;
import com.scale.bat.framework.utility.API.Auth;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WishListServiceStepDefs {
	
	public Auth auth=new Auth();
	public APIBase apibase=new APIBase();
	private Logger log = Log.getLogger(WishListServiceStepDefs.class);
	public String ordertoken;
	RequestSpecification requestspec;
	String strcontentype;
	public String access_hash;
	public int statusCode;
	public Response jsonResponse;
	public static Response jsonAllProductsResponse=null;
	String firstProduct;
	String firstProductVariantID;
	String secondProductVariantID;
	String thirdProductVariantID;
	
	
	
	@Given ("user get the Auth token")
	public void user_get_the_Auth_token() {
		
		ordertoken=auth.Authenticaion();
		System.out.println("1 ordertoken: " + ordertoken);
	}

		
	@Then("set the header")
	public void set_the_header() {
	    
	}

	@Then("user access the webservice of GetWishList")
	public void user_access_the_webservice_of_GetWishList() {
		jsonResponse=apibase.getRequest("/api/v2/storefront/wishlists/default?include=wished_products,wished_products.variant,wished_products.variant.product,wished_products.variant.product.manufacturer");
		access_hash = apibase.getvaluefromresponse("data.attributes.access_hash",jsonResponse);
        System.out.println("access_hash: "+ access_hash);
     
	}
	
		
	@Given("user add the WishList")
	public void user_add_the_WishList() throws FileNotFoundException {
		
		String strjson ="{\"wished_product\":{\"variant_id\":"+firstProductVariantID+",\"quantity\":1,\"remark\":\"test\"}}";
		apibase.Requestpost("/api/v2/storefront/wishlists/{access_hash}/wished_products", strjson, access_hash);
	}

	@Then("user retrive the value from the response")
	public void user_retrive_the_value_from_the_response() {
	    
	}
		
	@Given("deletes the products from the WishList")
	public void deletes_the_products_from_the_WishList() {
		
		apibase.Requestdel("/api/v2/storefront/wishlists/{access_hash}", access_hash);
	}
	
	
	@And("user gets all the available products list")
	public void user_gets_all_the_available_products_list() {
	    
		jsonResponse = apibase.getRequest("/api/v2/storefront/products?sort_by=available_on");
		jsonAllProductsResponse=jsonResponse;
		statusCode = apibase.getStatusCode(jsonResponse);
	}    

	@Given("identify products which needs to be add in the list.")
	public void identify_products_which_needs_to_be_add_in_the_list() {
	    
		firstProduct = apibase.getvaluefromresponse("data[0].id");
	}

	@Given("get the products variant ids")
	public void get_the_products_variant_ids() {
		
		jsonResponse = apibase.getRequest("/api/v2/storefront/products/"+firstProduct+"?include=default_variant,default_variant.vendor,variants,variants.option_values,documents,variants.delivery_charges,variants.vendor,variants.catalog,option_types,product_properties,images,manufacturer");
		statusCode = apibase.getStatusCode(jsonResponse);
		firstProductVariantID = apibase.getvaluefromresponse("data.relationships.default_variant.data.id");
		
	}


	@Given("user clears the basket")
	public void user_clears_the_basket() {
	   
		apibase.Requestpatch("/api/v2/storefront/cart/empty");
	}

	@Given("user adds a product to basket")
	public void user_adds_a_product_to_basket() {
		
		String strjson ="{\"variant_id\":"+firstProductVariantID+",\"quantity\": 1}";
		apibase.Requestpost("/api/v2/storefront/cart/add_item", strjson);
	    
	}

	@Given("user gets the multile products varient ids")
	public void user_gets_the_multile_products_varient_ids() {
	   
		jsonResponse = apibase.getRequest("/api/v2/storefront/products/"+apibase.getvaluefromresponse("data[1].id", jsonAllProductsResponse)+"?include=default_variant,default_variant.vendor,variants,variants.option_values,documents,variants.delivery_charges,variants.vendor,variants.catalog,option_types,product_properties,images,manufacturer");
			
		secondProductVariantID = apibase.getvaluefromresponse("data.relationships.default_variant.data.id");
			
		jsonResponse = apibase.getRequest("/api/v2/storefront/products/"+apibase.getvaluefromresponse("data[2].id", jsonAllProductsResponse)+"?include=default_variant,default_variant.vendor,variants,variants.option_values,documents,variants.delivery_charges,variants.vendor,variants.catalog,option_types,product_properties,images,manufacturer");
		thirdProductVariantID = apibase.getvaluefromresponse("data.relationships.default_variant.data.id");
	}

	@Given("user adds the multiple products to WishList")
	public void user_adds_the_multiple_products_to_WishList() {
		
		String strjsonProduct1 ="{\"wished_product\":{\"variant_id\":"+secondProductVariantID+",\"quantity\":1,\"remark\":\"test\"}}";
		Response strjsonProduct1Status = apibase.Requestpost("/api/v2/storefront/wishlists/{access_hash}/wished_products", strjsonProduct1, access_hash);
		
		String strjsonProduct2 ="{\"wished_product\":{\"variant_id\":"+thirdProductVariantID+",\"quantity\":1,\"remark\":\"test\"}}";
		Response strjsonProduct2Status=apibase.Requestpost("/api/v2/storefront/wishlists/{access_hash}/wished_products", strjsonProduct2, access_hash);
		System.out.println();
	}


	

}
