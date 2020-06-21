// * Assignment 3: Drag and Drop -- Ankura Raval

package TestCases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DragNDropAppTest {

	private static final String AndroidKeycode = null;
	public static AppiumDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilites = new DesiredCapabilities();

		capabilites.setCapability("device", "Android");
		capabilites.setCapability("deviceName", "Pixel 2");
		capabilites.setCapability("platformName", "Android");

		capabilites.setCapability("appPackage", "com.mobeta.android.demodslv");
		capabilites.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");

		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilites);
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);

		
		
		
		//Dismiss alert if there are any alerts due to android version 
				if (driver.findElement(By.id("com.android.permissioncontroller:id/permissions_message")).isDisplayed()) {
			
				driver.findElement(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.Button[2]"))
						.click();
				
				}
			
				if (driver.findElement(By.id("android:id/message")).isDisplayed()) {
					
					driver.findElement(By.xpath(
							"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button"))
							.click();
					
					}
				
				
		Thread.sleep(5000);

		driver.findElement(By.id("com.mobeta.android.demodslv:id/activity_title")).click();

		List<WebElement> element = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle"));

		// Drag and Drop
		new TouchAction((MobileDriver) driver).press(ElementOption.element(element.get(0)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(ElementOption.element(element.get(4))).release().perform();

		Thread.sleep(5000);

		driver.quit();

	}

}
