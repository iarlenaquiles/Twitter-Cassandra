package br.ufc.quixada.app;

import br.ufc.quixada.app.dao.Twitter;

public class GetUser {
	public static void main(String[] args) {
		Twitter t = new Twitter();
		t.getUser("Leandro");
	}
}
