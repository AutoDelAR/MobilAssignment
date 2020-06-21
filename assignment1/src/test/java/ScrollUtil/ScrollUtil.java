package ScrollUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollUtil {
	public static AndroidElement scrollToElement(By by, AndroidDriver driver) {
		AndroidElement element = null;
		int numberOfTimes = 10;
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.width / 2);
		// Swipe up to scroll down
		int startPoint = (int) (size.height - 10);
		int endPoint = 10;

		for (int i = 0; i < numberOfTimes; i++) {
			try {
				new TouchAction(driver).longPress(PointOption.point(anchor, startPoint)) // .press(point(anchor,
																							// startPoint)) if used
																							// press need proper waiting
																							// time
						// .waitAction(waitOptions(ofMillis(miliseconds)))
						.moveTo(PointOption.point(anchor, endPoint)).release().perform();
				element = (AndroidElement) driver.findElement(by);
				i = numberOfTimes;
			} catch (NoSuchElementException ex) {
				System.out.println(String.format("Element not available. Scrolling (%s) times…", i + 1));
			}
		}
		return element;
	}

}
