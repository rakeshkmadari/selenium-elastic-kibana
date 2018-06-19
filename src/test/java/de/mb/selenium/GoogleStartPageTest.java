package de.mb.selenium;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
@Listeners(ExecutionListener.class)
public class GoogleStartPageTest {

	private WebDriver driver;

	@BeforeSuite
	public void setUp() throws MalformedURLException {
		String serverUrl = System.getProperty("grid.server.url");
		String gridServerUrl = "http://seleniumhub:4444/wd/hub";
		if (serverUrl != null) {
			gridServerUrl = serverUrl;
		}
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		URL gridUrl = new URL(gridServerUrl);
		driver = new RemoteWebDriver(gridUrl, capability);
		driver.get("http://tomcat:10000");
	}

	@AfterSuite
	public void tearDownWebDriver() {
		driver.quit();
	}


	@Test(description = "pagebody is not null")
	public void pageBodyIsNotNull() throws MalformedURLException {
		String bodyText = driver.findElement(By.tagName("body")).getText();
		assertTrue(bodyText != null);  
		assertFalse(bodyText == null);
	
	}
@Test(description = "login")
    public void login(){
	Assert.assertTrue(false, "login failure");
    }

    @Test(description = "search for flights", dependsOnMethods = "login")
    public void search(){

    }

    @Test(description = "select flight", dependsOnMethods = "search")
    public void select(){

    }

    @Test(description = "book flight", dependsOnMethods = "select")
    public void book(){

    }

    @Test(description = "logout", dependsOnMethods = "book")
    public void logout(){

    }

}
