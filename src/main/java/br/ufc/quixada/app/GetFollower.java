package br.ufc.quixada.app;

import br.ufc.quixada.app.dao.Twitter;

public class GetFollower {

	public static void main(String[] args) {
		Twitter t = new Twitter();
		t.getSeguidores("iarlen");
	}

}
