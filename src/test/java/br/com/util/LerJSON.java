package br.com.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class LerJSON {
	private Object obj;
	private JSONObject js;
	
	public LerJSON(String path) throws IOException, ParseException{
		obj = new JSONParser().parse(new FileReader(path));
		js = (JSONObject) obj;				
	}
	
	public String retornaElementoJSON(String elemento) {
		return this.js.get(elemento).toString();
	}
}
