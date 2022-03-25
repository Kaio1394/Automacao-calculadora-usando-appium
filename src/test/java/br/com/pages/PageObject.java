package br.com.pages;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import br.com.factory.DriverFactory;
import br.com.util.LOCATOR;
import br.com.util.MASSADADOS;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PageObject{
	public DriverFactory factory;
	
	public PageObject(AndroidDriver<MobileElement> driver, 
			String appPackage, 
			String appActivity) {
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

	public void preencherCampoNome(){
		this.preencherCampoTextoByClassName(LOCATOR.CLASS_NAME_EDIT_TEXT, MASSADADOS.CAMPO_NOME, false);
	}
	public String retornaElementoByClasName(String className) {
		// TODO Auto-generated method stub
		return this.factory.getDriver().findElement(By.className(className)).getText();
	}
		
	public MobileElement retornaElementoByAcessibilityId(String acessId) {
		// TODO Auto-generated method stub
		return this.factory.getDriver().findElement(MobileBy.AccessibilityId(acessId));
	}
	public List<MobileElement> retornaListaByClassName(String className){
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
		this.factory.getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='"+ console +"']")).click();
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
}
