package br.ufc.quixada.app;

import br.ufc.quixada.app.dao.Twitter;

public class InserirTweet {
	public static void main(String[] args) {
		Twitter t = new Twitter();
		t.inserirTweet("Leandro", "Testando com java");

	}
}
