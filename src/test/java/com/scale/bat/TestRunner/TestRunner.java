package com.scale.bat.TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = false,
        features = {"src/test/resources/FeatureFiles/"},
        glue={"com.scale.bat.stepdefs", "com.scale.bat.context"},
        monochrome = false,
        plugin = { "pretty", "html:target/cucumber-html-reports", "json:target/cucumber-html-reports/cucumber.json"}
        , tags = "@test",dryRun = false)


public class TestRunner {
}
