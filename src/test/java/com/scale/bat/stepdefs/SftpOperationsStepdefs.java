package com.scale.bat.stepdefs;

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
		 /*scenarioContext.awsS3Service.uploadFileToS3(configurationReader.awsS3fileUploadBucket(), "Test.text", "Test.text",
		 configurationReader.awsS3fileUploadFolder());*/
	}

}
