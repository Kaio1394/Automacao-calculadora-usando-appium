package br.com.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.factory.DriverFactory;
import br.com.util.LOCATOR;
import br.com.util.MASSADADOS;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PageObject {
	
	// Setup Appium
	private DriverFactory factory;

	public PageObject(AndroidDriver<MobileElement> driver, String appPackage, String appActivity) {
		factory = new DriverFactory(driver, appPackage, appActivity);
		this.esperaPorXSegundos(10);
	}

	private void esperaPorXSegundos(int time) {
		this.factory.getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public boolean fecharApp(boolean fechar) {
		if (fechar == true) {
			if (factory.getDriver() != null) {
				factory.getDriver().quit();
				factory.setDriver(null);
				return true;
			}
		}
		return false;
	}

	public void preencherCampoTextoById(String id, String texto, boolean clear) {
		if (clear == false) {
			this.factory.getDriver().findElementById(id).sendKeys(texto);
		} else {
			this.factory.getDriver().findElementById(id).clear();
			this.factory.getDriver().findElementById(id).sendKeys(texto);
		}
	}

	public void preencherCampoTextoByClassName(String className, String texto, boolean clear) {
		if (clear == false) {
			this.factory.getDriver().findElement(By.className(className)).sendKeys(texto);
		} else {
			this.factory.getDriver().findElement(By.className(className)).clear();
			this.factory.getDriver().findElement(By.className(className)).sendKeys(texto);
		}
	}

	public String retornaElementoByClasName(String className) {
		// TODO Auto-generated method stub
		return this.factory.getDriver().findElement(By.className(className)).getText();
	}

	public MobileElement retornaElementoByAcessibilityId(String acessId) {
		// TODO Auto-generated method stub
		return this.factory.getDriver().findElement(MobileBy.AccessibilityId(acessId));
	}

	public List<MobileElement> retornaListaByClassName(String className) {
		List<MobileElement> elementos = this.factory.getDriver().findElements(By.className(className));
		return elementos;
	}

	protected MobileElement retornaElementoById(String id) {
		// TODO Auto-generated method stub
		return this.factory.getDriver().findElement(By.id(id));
	}

	public MobileElement retornaElementoByXPath(String xpath) {
		// TODO Auto-generated method stub
		return this.factory.getDriver().findElement(By.xpath(xpath));
	}

	public void clickComboBoxConsole(String console) {
		this.clickComboBoxByAcessibilityId(MASSADADOS.ACESS_ID_CONSOLE);
		this.factory.getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='" + console + "']"))
				.click();
	}

	public void clickComboBoxByAcessibilityId(String acessId) {
		// TODO Auto-generated method stub
		this.retornaElementoByAcessibilityId(acessId).click();
	}

	public String retornaTextoElementoByID(String locator) {
		return factory.getDriver().findElementById(locator).getText();
	}

	public void clicarBtnIgualCalculadora() {
//		this.clicarBtnNumCalculadora(ID_PADRAO + "eq"); 
		this.factory.getDriver().findElementById(LOCATOR.ID_BTN_IGUAL).click();
	}

	public void clickBtnMinusCalculadora() {
		// TODO Auto-generated method stub
		this.factory.getDriver().findElementById(LOCATOR.ID_SUBTRACAO).click();
	}
	
	public void restartApp() {
		// TODO Auto-generated method stub
		this.factory.getDriver().resetApp();
	}
	
	public void takeScreenShot() {
		File screenshotAs = ((TakesScreenshot) this.factory.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotAs, new File("target/screenshots/img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
