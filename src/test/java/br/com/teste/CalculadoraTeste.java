package br.com.teste;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.pages.CalculadoraPage;
import br.com.util.MASSADADOS;

public class CalculadoraTeste {
	
	CalculadoraPage page;	
	
	@Before
	public void before(){
		// TODO Auto-generated method stub
		page = new CalculadoraPage();
		
	}
	
	@After
	public void tearDown() {
		page.fecharApp(true);
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
		Assert.assertEquals(MASSADADOS.MENSAGEM_ERRO_DIV_ZERO, page.retornaResultadoString());
	}



}
