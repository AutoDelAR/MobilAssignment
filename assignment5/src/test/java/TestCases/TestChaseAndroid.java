
//Assignment 5 - Ankura Raval
package TestCases;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import ScrollUtil.ScrollUtil;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestChaseAndroid {

	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("chromedriverExecutable", "C:/Appium/Appium/Nexus-Chrome83/chromedriver.exe");

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5");

		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://chase.com");
		long sleepTimeout = 10000;
		driver.findElement(By.xpath("//*[@id=\"skip-sidemenu\"]")).click();

		driver.findElement(By.xpath("//*[@id=\"side-menu-header\"]/div[5]/div[2]/ul/li[1]/a")).click();
		Thread.sleep(sleepTimeout);
		//ScrollUtil.scrollToElement(By.xpath("//*[@id=\"SubHeaderOriginal\"]/ul"), driver).click();
	
		ScrollUtil.scrollToElement(
				By.xpath("//*[@id=\"popular\"]/div[2]/div/div/div/div[2]/div/div/div/div/div/ul/li[8]/a"), driver)
				.click();
		driver.findElementByXPath("/html/body/div/div[5]/main/div/div[3]/div/section/section[1]/div[4]/form/label/input").sendKeys("Test");
		
		driver.getKeyboard().sendKeys(Keys.ENTER);
		//driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));

		Thread.sleep(sleepTimeout);
		// Print the customer Reviews:
		String string = driver.findElementByXPath("//*[@id=\"Module0\"]/section/section[3]/div[2]/div/h3").getText();
		System.out.print(string);

		driver.findElement(By.xpath("//*[@id=\"skip-sidemenu\"]")).click();
		ScrollUtil.scrollToElement(By.xpath("//*[@id=\"side-menu-header\"]/div[5]/div[2]/ul/li[2]/a"), driver).click();
		Thread.sleep(sleepTimeout);
		//driver.switchTo().window("Feedback-Chase Online");
	
	
		Set<String> windows = driver.getWindowHandles();
		String childWindow = (String) windows.toArray()[windows.toArray().length-1];
		driver.switchTo().window(childWindow);  
		//driver.runAppInBackground(Duration.ofSeconds(10));
		
		//WebElement rating = driver.findElementByXPath("//*[@id=\"overall_3\"]");
		//.click();
		driver.findElementByXPath("//*[@id='comment_box']").sendKeys("Test Feedback");
		driver.close();
		driver.quit();

	}

}