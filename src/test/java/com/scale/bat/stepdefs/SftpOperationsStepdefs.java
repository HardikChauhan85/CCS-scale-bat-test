package com.scale.bat.stepdefs;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.scale.bat.context.ScenarioContext;
import com.scale.bat.framework.utility.ConfigurationReader;

import cucumber.api.java.en.Given;

public class SftpOperationsStepdefs {

	ScenarioContext scenarioContext;
	ConfigurationReader configurationReader;

	public SftpOperationsStepdefs(ScenarioContext scenarioContext) {
		this.scenarioContext = scenarioContext;
		configurationReader = new ConfigurationReader();
	}

	@Given("User uploads the file to s3 bucket")
	public void user_uploads_the_file_to_s_bucket() {
		try {
			ResultSet rs = scenarioContext.postgresSqlConnection.getData("SELECT * FROM public.spree_products\r\n" + 
					"ORDER BY id ASC LIMIT 100");
			while (rs.next() ) {
				String  name = rs.getString("name");	
				System.out.println("Name : "+name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
