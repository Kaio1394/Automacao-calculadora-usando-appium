package br.com.teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.pages.FormularioPage;
import br.com.util.MASSADADOS;

public class FormularioTeste {

	private FormularioPage formularioPage;

	@Before
	public void before() {
		formularioPage = new FormularioPage();
		formularioPage.clickTelaFormulario();
	}

	@After
	public void tearDown() {
		formularioPage.takeScreenShot();
		formularioPage.fecharApp(true);
		//formularioPage.restarAppFormulario();
	}

	@Test
	public void devePreencherCampoTexto() {
		formularioPage.preencherCampoNome();
		Assert.assertEquals(MASSADADOS.CAMPO_NOME, formularioPage.retornaTextoNome());
	}

	@Test
	public void testandoComboBox() {
		formularioPage.clickComboBoxConsole(MASSADADOS.CONSOLE_NOME_PS4);
		Assert.assertEquals(MASSADADOS.CONSOLE_NOME_PS4, formularioPage.retornaTextoDoConsole());
	}

	@Test
	public void deveInteragirComCheckBox() {
		formularioPage.clickCheckBox();
		Assert.assertTrue(formularioPage.retornaStatusCheckBox());
	}

	@Test
	public void deveRealizarCadastroComSucesso() throws InterruptedException {
		formularioPage.preencherCampoNome();
		formularioPage.clickComboBoxConsole(MASSADADOS.CONSOLE_NOME_PS4);
		formularioPage.clickCheckBox();

		formularioPage.clicarBtnSalvar(true);

		Thread.sleep(2000);
		Assert.assertArrayEquals(MASSADADOS.LISTA_VALIDACAO, formularioPage.retornaListaTextoValidacao());

	}
}
