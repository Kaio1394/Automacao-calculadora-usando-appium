package br.com.pages;
import br.com.util.LOCATOR;
import br.com.util.MASSADADOS;


public class FormularioPage extends PageObject{

		public FormularioPage() {
		super(null, "com.ctappium", "com.ctappium.MainActivity");
	}

	public void clickTelaFormulario() {
		this.retornaListaByClassName(LOCATOR.CLASS_NAME_FORMULARIO).get(1).click();
	}

	public String retornaTextoNome() {
		return this.retornaElementoByClasName(LOCATOR.CLASS_NAME_EDIT_TEXT);
	}

	public void clickComboBoxByAcessibilityId(String acessId) {
		this.retornaElementoByAcessibilityId(acessId).click();
	}
	
	public String retornaTextoDoConsole() {
		return this.retornaElementoByXPath(LOCATOR.XPATH_CAMPO_CONSOLE).getText();
	}

	public void clickCheckBox() {
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

	public String[] retornaListaTextoValidacao() {
		// TODO Auto-generated method stub
		String txtNome = this.retornaElementoByXPath("//android.widget.TextView[@text = 'Nome: Kaio']").getText();
		String txtConsole = this.retornaElementoByXPath("//android.widget.TextView[@text = 'Console: ps4']").getText();
		String txtSlider = this.retornaElementoByXPath("//android.widget.TextView[@text = 'Slider: 25']").getText();
		String txtSwitch = this.retornaElementoByXPath("//android.widget.TextView[@text = 'Switch: On']").getText();
		String txtCheckBox = this.retornaElementoByXPath("//android.widget.TextView[@text = 'Checkbox: Marcado']").getText();
		String txtData = this.retornaElementoByXPath("//android.widget.TextView[@text = 'Data: 01/01/2000']").getText();
		String txtHora = this.retornaElementoByXPath("//android.widget.TextView[@text = 'Hora: 06:00']").getText();
		
		return new String[] {txtNome, txtConsole, txtSlider, txtSwitch, 
				txtCheckBox, txtData, txtHora};
	}
	
	public void preencherCampoNome() {
		this.preencherCampoTextoByClassName(LOCATOR.CLASS_NAME_EDIT_TEXT, MASSADADOS.CAMPO_NOME, false);
	}
	

}
