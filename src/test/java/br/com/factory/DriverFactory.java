package br.com.factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {
	private AndroidDriver<MobileElement> driver;
	private DesiredCapabilities desiredCapabilities;

	public DriverFactory(AndroidDriver<MobileElement> driver, String appPackage, String appActivity) {
		if (driver == null) {
			try {
//				this.desiredCapabilities = new DesiredCapabilities();
//				this.desiredCapabilities.setCapability("appium:platformName", "Android");
//				this.desiredCapabilities.setCapability("appium:deviceName", "emulator");
//				this.desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
//				this.desiredCapabilities.setCapability(MobileCapabilityType.APP,
//						"/Users/kaios/eclipse-workspace/CursoAppium/src/test/resources/CTAppium_1_2.apk");
//				this.driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
//						desiredCapabilities);
//				this.esperaPorXSegundos(10);

				desiredCapabilities = new DesiredCapabilities();
				desiredCapabilities.setCapability("appium:platformName", "Android");
				desiredCapabilities.setCapability("appium:deviceName", "emulator");
				desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
				desiredCapabilities.setCapability("appium:appPackage", appPackage);
				desiredCapabilities.setCapability("appium:appActivity", appActivity);
				desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
				desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
				this.driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
						desiredCapabilities);
				this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}else {
			this.driver = driver;
		}
	}

	public AndroidDriver<MobileElement> getDriver() {
		return driver;
	}

	public void setDriver(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	

}
