package br.com.caelum.goodbuy;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Resource;

@Resource
public class Mundo {
	public String boasVindas() {
		return ("Bem Vindo");
	}

	public List<String> paises() {

		List<String> result = new ArrayList<String>();
		result.add("Brasil");
		result.add("Japao");
		result.add("USA");

		return result;
	}
}
