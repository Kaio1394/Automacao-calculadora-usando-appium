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

import br.com.pages.CalculadoraPage;
import br.com.util.StartAndTearDown;

public class Teste implements StartAndTearDown {
	
	CalculadoraPage driver;	
	
	@Before
	public void before() throws MalformedURLException {
		// TODO Auto-generated method stub
		driver = new CalculadoraPage();
	}
	
	@After
	public void tearDown() {
		driver.encerraSessao();
	}
	
	@Test
	public void TesteSomaCalculadora() {
		driver.clicarBtn2Calculadora();
		driver.clicarBtnPlusCalculadora();
		driver.clicarBtn2Calculadora();
		
		Assert.assertEquals("4", driver.retornaResultadoString());
	}
	
//	@Test
//	public void TesteSubtracaoCalculadora() {
//	    MobileElement el3 = driver.findElementById("com.android.calculator2:id/digit_5");
//	    el3.click();
//	    MobileElement el4 =  driver.findElementByAccessibilityId("minus");
//	    el4.click();
//	    MobileElement el5 =  driver.findElementById("com.android.calculator2:id/digit_4");
//	    el5.click();
//	    
//	    String result = driver.findElementById("com.android.calculator2:id/result").getText();
//	    
//	    Assert.assertEquals("1", result);
//	}



}
