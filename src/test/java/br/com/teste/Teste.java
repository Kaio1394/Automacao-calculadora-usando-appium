package br.com.teste;

import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Teste {

	AndroidDriver<MobileElement> driver;	
	@Before
	public void befora() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("appium:platformName", "Android");
	    desiredCapabilities.setCapability("appium:deviceName", "emulator");
	    desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appium:appPackage", "com.android.calculator2");
	    desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
	    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
	    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
	    driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
	    
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void TesteSomaCalculadora() {
	    MobileElement el3 = driver.findElementById("com.android.calculator2:id/digit_2");
	    el3.click();
	    MobileElement el4 =  driver.findElementByAccessibilityId("plus");
	    el4.click();
	    MobileElement el5 =  driver.findElementById("com.android.calculator2:id/digit_2");
	    el5.click();
	    
	    String result = driver.findElementById("com.android.calculator2:id/result").getText();
	    
	    Assert.assertEquals("4", result);
	}

}
