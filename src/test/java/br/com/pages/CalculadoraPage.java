package br.com.pages;

import br.com.util.LOCATOR;
import io.appium.java_client.MobileElement;


public class CalculadoraPage extends PageObject {

	public CalculadoraPage() {
		super(null, "com.android.calculator2", "com.android.calculator2.Calculator");
		// TODO Auto-generated constructor stub
	}

	public void clicarBtnCalculadoraByID(String locator) {
		this.retornaElementoCalculadoraByID(locator).click();
	}

	public void clicarBtnNumCalculadora(String num) {
		this.clicarBtnCalculadoraByID(LOCATOR.ID_PADRAO + num);
	}

	public MobileElement retornaElementoCalculadoraByID(String locator) {
		MobileElement element = (MobileElement) this.retornaElementoById(locator);
		return element;
	}

	public void clicarBtnPlusCalculadora() {
		// TODO Auto-generated method stub
		this.clicarBtnCalculadoraByID(LOCATOR.ID_BTN_PLUS);
	}

	public String retornaResultadoString() {
		return this.retornaTextoElementoByID(LOCATOR.ID_RESULTADO);
	}

	public void clickBtnDivCalculadora() {
		// TODO Auto-generated method stub
		this.retornaElementoCalculadoraByID(LOCATOR.ID_DIVISAO).click();
	}

}
