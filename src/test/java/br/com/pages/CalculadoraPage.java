package br.com.pages;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.util.LOCATOR;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraPage {

	private AndroidDriver<MobileElement> driver;
	private DesiredCapabilities desiredCapabilities;

	public CalculadoraPage() throws MalformedURLException {
		//Setup
		desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("appium:platformName", "Android");
		desiredCapabilities.setCapability("appium:deviceName", "emulator");
		desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
		desiredCapabilities.setCapability("appium:appPackage", "com.android.calculator2");
		desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	}

	public void clicarBtnCalculadoraByID(String locator) {
		this.retornaElementoCalculadoraByID(locator).click();
	}

	public void clicarBtnNumCalculadora(String num) {
		this.clicarBtnCalculadoraByID(LOCATOR.ID_PADRAO + num);
	}

	public MobileElement retornaElementoCalculadoraByID(String locator) {
		MobileElement element = (MobileElement) this.driver.findElementById(locator);
		return element;
	}

	public void encerraSessao() {
		// TODO Auto-generated method stub
		this.driver.quit();
	}

	public void clicarBtnPlusCalculadora() {
		// TODO Auto-generated method stub
		this.clicarBtnCalculadoraByID(LOCATOR.ID_BTN_PLUS);
	}

	public String retornaTextoElementoByID(String locator) {
		return driver.findElementById(locator).getText();
	}

	public String retornaResultadoString() {
		return this.retornaTextoElementoByID(LOCATOR.ID_RESULTADO);
	}

	public void clickBtnMinusCalculadora() {
		// TODO Auto-generated method stub
		this.driver.findElementById(LOCATOR.ID_SUBTRACAO).click();
	}

	public void clickBtnDivCalculadora() {
		// TODO Auto-generated method stub
		this.retornaElementoCalculadoraByID(LOCATOR.ID_DIVISAO).click();
	}

	public void clicarBtnIgualCalculadora() {
//		this.clicarBtnNumCalculadora(ID_PADRAO + "eq"); 
		this.driver.findElementById(LOCATOR.ID_BTN_IGUAL).click();
		
	}

}
