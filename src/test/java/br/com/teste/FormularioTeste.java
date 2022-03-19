package br.com.teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import br.com.pages.FormularioPage;
import br.com.util.MASSADADOS;


public class FormularioTeste {

	
	private FormularioPage page;

	@Before
	public void before() {
		page = new FormularioPage();
	}
	
	@After
	public void tearDown() {
		page.fecharApp(true);
	}
	
	@Test
	public void devePreencherCampoTexto(){
		page.clickTelaFormulario();
		page.preencherCampoNome();
		Assert.assertEquals(MASSADADOS.CAMPO_NOME, page.retornaTextoNome());
	}
	
	@Test
	public void testandoCOmboBOx() {
		page.clickTelaFormulario();
		page.clickComboBoxConsole(MASSADADOS.CONSOLE_NOME_PS4);
		Assert.assertEquals(MASSADADOS.CONSOLE_NOME_PS4, page.retornaTextoDoConsole());
	}
	
	@Test
	public void deveInteragirComCheckBox() {
		page.clickTelaFormulario();
		page.clickCheckBox();
		Assert.assertTrue(page.retornaStatusCheckBox());
	}
	
	@Test
	public void deveRealizarCadastroComSucesso() {
		page.clickTelaFormulario();
		page.preencherCampoNome();
		page.clickComboBoxConsole(MASSADADOS.CONSOLE_NOME_PS4);		
		page.clickCheckBox();
		
		page.clicarBtnSalvar(true);
		
	}
}
