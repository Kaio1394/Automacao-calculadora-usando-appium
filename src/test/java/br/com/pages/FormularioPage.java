package br.com.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.util.LOCATOR;
import br.com.util.JSON;
import br.com.util.MASSADADOS;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioPage{
	JSON json;
	private AndroidDriver<MobileElement> driver;
	private DesiredCapabilities desiredCapabilities;

	

	public FormularioPage() {
		try {
			this.desiredCapabilities = new DesiredCapabilities();
			this.desiredCapabilities.setCapability("appium:platformName", "Android");
			this.desiredCapabilities.setCapability("appium:deviceName", "emulator");
			this.desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
			this.desiredCapabilities.setCapability(MobileCapabilityType.APP,
					"/Users/kaios/eclipse-workspace/CursoAppium/src/test/resources/CTAppium_1_2.apk");
			this.driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
					desiredCapabilities);
			this.esperaPorXSegundos(10);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void esperaPorXSegundos(int time) {
		// TODO Auto-generated method stub
		this.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void fecharApp(boolean fechar) {
		if (fechar == true) {
			if (driver != null) {
				driver.quit();
			}
		}
	}

	public void preencherCampoTextoById(String id, String texto, boolean clear) {
		if (clear == false) {
			this.driver.findElementById(id).sendKeys(texto);
		} else {
			this.driver.findElementById(id).clear();
			this.driver.findElementById(id).sendKeys(texto);
		}
	}


	public void preencherCampoTextoByClassName(String className, String texto, boolean clear) {
		if (clear == false) {
			this.driver.findElement(By.className(className)).sendKeys(texto);
		} else {
			this.driver.findElement(By.className(className)).clear();
			this.driver.findElement(By.className(className)).sendKeys(texto);
		}
	}

	public void preencherCampoNome(){
		this.preencherCampoTextoByClassName(LOCATOR.CLASS_NAME_EDIT_TEXT, MASSADADOS.CAMPO_NOME, false);
	}

	public void clickTelaFormulario() {
		List<MobileElement> elementos = this.driver.findElements(By.className(LOCATOR.CLASS_NAME_FORMULARIO));
		elementos.get(1).click();
	}

	public String retornaTextoNome() {
		// TODO Auto-generated method stub
		return this.retornaElementoByClasName(LOCATOR.CLASS_NAME_EDIT_TEXT);
	}

	private String retornaElementoByClasName(String className) {
		// TODO Auto-generated method stub
		return this.driver.findElement(By.className(className)).getText();
	}

	

}
