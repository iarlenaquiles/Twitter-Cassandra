package br.ufc.quixada.app;

import java.sql.Timestamp;

import br.ufc.quixada.app.dao.Twitter;

public class InserirFollowers {

	public static void main(String[] args) {
		Twitter t = new Twitter();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		t.inserirFollowers("Leandro", "Iarlen", timestamp);
	}

}
