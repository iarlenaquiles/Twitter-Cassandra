package br.ufc.quixada.app;

import java.util.UUID;

import br.ufc.quixada.app.dao.Twitter;

public class InserirTimeline {

	public static void main(String[] args) {
		Twitter t = new Twitter();
		t.inserirTimeline("Leandro", UUID.fromString("0376c4b0-cbd4-11e7-a3a2-37d668091041"));
	}

}
