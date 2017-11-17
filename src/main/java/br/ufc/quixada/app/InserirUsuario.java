package br.ufc.quixada.app;

import br.ufc.quixada.app.dao.Twitter;

public class InserirUsuario {
	public static void main(String[] args) {
		Twitter t = new Twitter();
		t.inserirUsuario("rede", "123");
	}
}
