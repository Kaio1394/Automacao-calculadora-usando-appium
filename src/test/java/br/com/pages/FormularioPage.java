package br.com.pages;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.util.LOCATOR;
import br.com.util.MASSADADOS;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioPage{
	
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
		this.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public boolean fecharApp(boolean fechar) {
		if (fechar == true) {
			if (driver != null) {
				driver.quit();
				return true;
			}
		}
		return false;
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
	
	public MobileElement retornaElementoByAcessibilityId(String acessId) {
		return this.driver.findElement(MobileBy.AccessibilityId(acessId));		
	}
	
	public void clickComboBoxByAcessibilityId(String acessId) {
		// TODO Auto-generated method stub
		this.retornaElementoByAcessibilityId(acessId).click();
	}
	
	public void clickComboBoxConsole(String console) {
		this.clickComboBoxByAcessibilityId(MASSADADOS.ACESS_ID_CONSOLE);
		this.driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='"+ console +"']")).click();
	}
	
	public String retornaTextoDoConsole() {
		return this.retornaElementoByXPath(LOCATOR.XPATH_CAMPO_CONSOLE).getText();
	}

	private MobileElement retornaElementoById(String id) {
		// TODO Auto-generated method stub
		return this.driver.findElement(By.id(id));
	}
	
	private MobileElement retornaElementoByXPath(String xpath) {
		// TODO Auto-generated method stub
		return this.driver.findElement(By.xpath(xpath));
	}

	public void clickCheckBox() {
		// TODO Auto-generated method stub
		this.retornaElementoByAcessibilityId(LOCATOR.ACESS_ID_CHECK_BOX).click();
	}
	
	public boolean retornaStatusCheckBox() {
		return retornaElementoByAcessibilityId(LOCATOR.ACESS_ID_CHECK_BOX).isEnabled();
	}
	
	public boolean clicarBtnSalvar(boolean condicao) {
		if(condicao) {
			this.retornaElementoByXPath(LOCATOR.XPATH_BTN_SALVAR).click();
			return true;
		}else {
			return false;
		}
	}
}
