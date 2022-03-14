package br.com.teste;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

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
	
	CalculadoraPage page;	
	
	@Before
	public void before() throws MalformedURLException {
		// TODO Auto-generated method stub
		page = new CalculadoraPage();
		
	}
	
	@After
	public void tearDown() {
		page.encerraSessao();
	}
	
	@Test
	public void TesteSomaCalculadora() {
		page.clicarBtnNumCalculadora("2");
		page.clicarBtnPlusCalculadora();
		page.clicarBtnNumCalculadora("2");
		
		Assert.assertEquals("4", page.retornaResultadoString());
	}
	
	@Test
	public void TesteSubtracaoCalculadora() {
		page.clicarBtnNumCalculadora("5");
		page.clickBtnMinusCalculadora();
		page.clicarBtnNumCalculadora("4");
		
		Assert.assertEquals("1", page.retornaResultadoString());
	}
	
	@Test
	public void TesteDiviPorZeroCalculadora() {
//		Random random = new Random();
//		int numero = random.nextInt();
//		String numeroRandom = "";
//		if(numero != 0) {
//			numeroRandom = String.valueOf(numero);
//		}
		page.clicarBtnNumCalculadora("3");
		page.clickBtnDivCalculadora();
		page.clicarBtnNumCalculadora("0");
		page.clicarBtnIgualCalculadora();
		Assert.assertEquals("Can't divide by 0", page.retornaResultadoString());
	}



}
