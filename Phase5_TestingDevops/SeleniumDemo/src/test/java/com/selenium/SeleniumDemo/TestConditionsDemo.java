package com.selenium.SeleniumDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestConditionsDemo {

	WebDriver driver; 
	@BeforeMethod
	  public void beforeMethod() {
		   driver = new ChromeDriver(); 
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.quit(); // will close all the windows opened by selenium
		  //driver.close();// will only close the current window
	  }

	  @BeforeClass
	  public void beforeClass() {
		  System.setProperty("webdriver.chrome.driver", "/Users/Shalini/Downloads/chromedriver_mac_arm64/chromedriver");
	  }

	  @Test
	  public void testAlertClick() throws InterruptedException
	  {
		 driver.get("file:///Users/Shalini/Desktop/Vodafone_Jan2023/Phase5_TestingDevops/SeleniumDemo/index.html");
		 driver.manage().window().maximize();
		 WebElement ele = driver.findElement(By.id("b1"));
		 WebElement checkbox = driver.findElement(By.id("c1"));
		 AssertJUnit.assertFalse(checkbox.isSelected());
		 AssertJUnit.assertFalse(ele.isEnabled());
		 
		 Thread.sleep(2000);
		
		 checkbox.click();
		 AssertJUnit.assertTrue(ele.isEnabled());
		 AssertJUnit.assertTrue(checkbox.isSelected());
		 Thread.sleep(2000);
		 
	  }
}
