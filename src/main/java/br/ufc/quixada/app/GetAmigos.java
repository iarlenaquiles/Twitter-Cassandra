package br.ufc.quixada.app;

import br.ufc.quixada.app.dao.Twitter;

public class GetAmigos {

	public static void main(String[] args) {
		Twitter t = new Twitter();
		t.getAmigos("joao");
	}

}
