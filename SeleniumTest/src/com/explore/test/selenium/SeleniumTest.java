package com.explore.test.selenium;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumTest {

	private static String baseUrl ;
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void oneTimeSetUp() {
		//Requires: Set the url variable by passing in -Durl="http://10.0.0.40" as a command line argument
		//          Set the path of chrome webdriver using -Dwebdriver.chrome.driver="/path/to/chromedriver"
		
		String url = System.getProperty("url");
//		baseUrl = "http://localhost:8080/Exploration/";	
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\577654\\workspace\\drivers\\chromedriver.exe");
		driver = new HtmlUnitDriver();
		
		baseUrl = url + "/Exploration";
		
	}
	
	@Test
	public void testHomePage() {
		driver.get(baseUrl);
		assertEquals(driver.getTitle(), "Home");
		
	}
	
	@Test
	public void testAboutPage() {
		driver.get(baseUrl+"/about");
		assertEquals(driver.getTitle(), "Home");
	}
	
	@Test
	public void testRegisterPage() {
		driver.get(baseUrl+"/register");
		assertEquals(driver.getTitle(), "Register");
	}
	@Test
	public void testLogin() {
		driver.get(baseUrl + "/login");
		
		WebElement element = driver.findElement(By.name("username"));
		element.sendKeys("kumar");
		
		WebElement passElem = driver.findElement(By.name("password"));
		passElem.sendKeys("kumar");
		
		element.submit();
		
		driver.get(baseUrl + "/user/profile");
		
		//verify the login occurred successfully.
		assertEquals(driver.getTitle(), "Profile");
	}
	
	@Test
	public void testReportsPage() {
		driver.get(baseUrl + "/reports");
		
		//Something wrong
		assertEquals(driver.getTitle(), "Home");
	}
	
	@AfterClass
	public static void tearDown() {
		driver.close();
	}

}
