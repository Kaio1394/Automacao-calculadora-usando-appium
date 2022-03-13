package br.com.pages;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraPage {
	
	public AndroidDriver driver;
	public DesiredCapabilities desiredCapabilities;
	public final String ID_BOTAO_2 = "com.android.calculator2:id/digit_2";
	public final String ID_BTN_PLUS = "com.android.calculator2:id/op_add";

	
	public CalculadoraPage() throws MalformedURLException {
		desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("appium:platformName", "Android");
		desiredCapabilities.setCapability("appium:deviceName", "emulator");
		desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
		desiredCapabilities.setCapability("appium:appPackage", "com.android.calculator2");
		desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
	}
	public void clicarBtnCalculadoraByID(String locator) {
		this.retornaElementoCalculadoraByID(locator).click();	    
	}
	

	public void clicarBtn2Calculadora() {
		this.clicarBtnCalculadoraByID(ID_BOTAO_2);
	}	
	
	public MobileElement retornaElementoCalculadoraByID(String locator){
		MobileElement element = (MobileElement) this.driver.findElementById(locator);
		return element;
	}
	

	public void encerraSessao() {
		// TODO Auto-generated method stub
		this.driver.quit();
	}
	public void clicarBtnPlusCalculadora() {
		// TODO Auto-generated method stub
		this.clicarBtnCalculadoraByID(ID_BTN_PLUS);
	}
	
	public String retornaTextoElementoByID(String locator) {
		return driver.findElementById(locator).getText();	
	}
	
	public String retornaResultadoString() {
		return this.retornaTextoElementoByID("com.android.calculator2:id/result");
	}
	
}
