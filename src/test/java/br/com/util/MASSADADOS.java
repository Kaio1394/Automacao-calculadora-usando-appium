package br.com.util;

public abstract class MASSADADOS {
	public static final String CAMPO_NOME = "Kaio";
	public static final String MENSAGEM_ERRO_DIV_ZERO = "Can't divide by 0";
	public static final String ACESS_ID_CONSOLE = "console";
	public static final String CONSOLE_NOME_PS4 = "PS4";
	public static final String SLIDER_NAME = "25";
	public static final String SWITCH_VALUE = "On";
	public static final String CHECKBOX_MARCADO = "Marcado";
	public static final String DATA = "01/01/2000";
	public static final String HORA = "06:00";
	public static final String[] LISTA_VALIDACAO = 
		{"Nome: " + CAMPO_NOME, 
				"Console: " + CONSOLE_NOME_PS4.toLowerCase(), 
				"Slider: " + SLIDER_NAME,
				"Switch: " + SWITCH_VALUE,
				"Checkbox: " + CHECKBOX_MARCADO,
				"Data: " + DATA,
				"Hora: " + HORA}; 
}
