package com.scale.bat.framework.utility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import cucumber.api.Scenario;




public class TakeScreenShot extends Actions {
	private WebDriver driver;

	public TakeScreenShot(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, 30);
	}
	
	
	public void takeSnapShot1() {
		// Code to take full page screenshot
		ByteArrayOutputStream imageStream = new ByteArrayOutputStream();
		scenario.write("URL - " + driver.getCurrentUrl());
		PageSnapshot snapshot = Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS, true);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");

		try {
			ImageIO.write(snapshot.getImage(), "png", imageStream);
			imageStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] source = imageStream.toByteArray();
		scenario.embed(source, "image/png");
	}
	
}
