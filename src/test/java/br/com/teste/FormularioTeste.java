package br.com.teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import br.com.pages.FormularioPage;


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
	}

	

}
