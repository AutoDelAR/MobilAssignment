//Assignment 1 : Ankura Raval

package TestCases;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



import ScrollUtil.ScrollUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.File;
import java.io.IOException;

import static io.appium.java_client.touch.offset.PointOption.point;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;



public class TestMultiTouch {

	//private static final String AndroidKeycode = null;
	public static AndroidDriver<WebElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

	
        DesiredCapabilities capabilites = new DesiredCapabilities();

		capabilites.setCapability("device", "Android");
		capabilites.setCapability("deviceName", "Pixel 2");
		capabilites.setCapability("platformName", "Android");

		capabilites.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		capabilites.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");

		
        //open the App
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilites);
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		
	    
		//Dismiss alert if there are any alerts due to android version 
		if (driver.findElement(By.id("android:id/title_template")).isDisplayed()) {
	
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")).click();
		
		}
				
		
		
		Thread.sleep(5000);

			 TouchAction action1 = new TouchAction(driver).tap(point(300, 175)).waitAction(waitOptions(Duration.ofMillis(250)));

			 TouchAction action2 = new TouchAction(driver).tap(point(500, 845)).waitAction(waitOptions(Duration.ofMillis(250)));

		     TouchAction action3 = new TouchAction(driver).tap(point(321, 205)).waitAction(waitOptions(Duration.ofMillis(250)));
		     
		     TouchAction action4 = new TouchAction(driver).tap(point(325, 255)).waitAction(waitOptions(Duration.ofMillis(250)));
		    
		     TouchAction action5 = new TouchAction(driver).tap(point(525, 155));


				 Thread.sleep(3000);
				 new MultiTouchAction(driver).add(action1).add(action2).add(action3).add(action4).add(action5).perform();;
				 
				takeScreenShot();
				
				 
				// File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 
				 Thread.sleep(5000);
				 
				 driver.quit();
				 
				 
				 
			}

	private static void takeScreenShot() {
		// TODO Auto-generated method stub
		
		String destDir = "screenshots";
		
		// Capture screenshot.
		  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  // Set date format to set It as screenshot file name.
		  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		  // Create folder under project with name "screenshots" provided to destDir.
		  File screenShotDir = new File(destDir);
		  screenShotDir.mkdirs();
		  System.out.println("Screenshot saved to: " + screenShotDir.getAbsolutePath());
		  // Set file name using current date time.
		  String destFile = dateFormat.format(new Date(0)) + ".png";

		  try {
		   // Copy paste file at destination folder location
		   FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		   String scrPath = destDir+ "/" + destFile;
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		 }

	
		
	}
			

		

		

	

