package br.ufc.quixada.app.conection;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Conexao {
	private Cluster cluster;
	private Session session;

	public Conexao(String node) {
		this.cluster = Cluster.builder().addContactPoint(node).build();
		this.session = cluster.connect();
	}

	public void close() {
		this.cluster.close();
		this.session.close();
	}

	public Cluster getCluster() {
		return cluster;
	}

	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
