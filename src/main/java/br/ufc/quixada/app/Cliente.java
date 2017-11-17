package br.ufc.quixada.app;

import java.sql.Timestamp;
import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;

import br.ufc.quixada.app.conection.Conexao;
import br.ufc.quixada.app.dao.Twitter;

public class Cliente {
	private Cluster cluster;
	private Session session;

	public void conect(String node) {
		cluster = Cluster.builder().addContactPoint(node).build();
		session = cluster.connect();
	}

	public void close() {
		cluster.close();
		session.close();
	}

	public void inserirUsuario(String user, String pass) {
		String stmt = "insert into twissandra.users (username, password) values (?, ?)";
		PreparedStatement ps = session.prepare(stmt);
		BoundStatement bs = new BoundStatement(ps);
		bs.bind(user, pass);
		session.execute(bs);
	}

	public void inserirTweet(String user, String body) {
		String stmt = "insert into twissandra.tweets (tweet_id, username, body) values (now(), ?, ?)";
		PreparedStatement ps = session.prepare(stmt);
		BoundStatement bs = new BoundStatement(ps);
		bs.bind(user, body);
		session.execute(bs);
	}

	public void inserirUserLine(String user, UUID tweet_id) {
		String stmt = "insert into twissandra.userline (username, time, tweet_id) values (?, now(), ?)";
		PreparedStatement ps = session.prepare(stmt);
		BoundStatement bs = new BoundStatement(ps);
		bs.bind(user, tweet_id);
		session.execute(bs);
	}

	public void inserirTimeline(String user, UUID tweet_id) {
		String stmt = "insert into twissandra.timeline (username, time, tweet_id) values (?, now(), ?)";
		PreparedStatement ps = session.prepare(stmt);
		BoundStatement bs = new BoundStatement(ps);
		bs.bind(user, tweet_id);
		session.execute(bs);
	}

	public void inserirFriend(String user, String friend, Timestamp since) {
		String stmt = "insert into twissandra.friends (username, friend, since) values (?, ?, ?)";
		PreparedStatement ps = session.prepare(stmt);
		BoundStatement bs = new BoundStatement(ps);
		bs.bind(user, friend, since);
		session.execute(bs);
	}

	public void inserirFollowers(String user, String friend, Timestamp since) {
		String stmt = "insert into twissandra.followers (username, follower, since) values (?, ?, ?)";
		PreparedStatement ps = session.prepare(stmt);
		BoundStatement bs = new BoundStatement(ps);
		bs.bind(user, friend, since);
		session.execute(bs);
	}

	public void removerFriend(String user, String friend) {
		String stmt = "DELETE FROM twissandra.friends WHERE username=? AND friend=?";
		PreparedStatement ps = session.prepare(stmt);
		BoundStatement bs = new BoundStatement(ps);
		bs.bind(user, friend);
		session.execute(bs);
	}

	public void removerFollowers(String user, String follower) {
		String stmt = "DELETE FROM twissandra.followers WHERE username=? AND follower=?";
		PreparedStatement ps = session.prepare(stmt);
		BoundStatement bs = new BoundStatement(ps);
		bs.bind(user, follower);
		session.execute(bs);
	}

	public static void main(String[] args) {
		Twitter t = new Twitter();
		t.inserirUsuario("marilene", "123");
		// cli.inserirTweet("Leandro", "Testando com java");
		// cli.inserirUserLine("Leandro",
		// UUID.fromString("0376c4b0-cbd4-11e7-a3a2-37d668091041"));

		// cli.inserirTimeline("Leandro",
		// UUID.fromString("0376c4b0-cbd4-11e7-a3a2-37d668091041"));
		// cli.inserirFriend("Leandro", "Iarlen", );
		// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		// cli.inserirFriend("Leandro", "Iarlen", timestamp);

		// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		// cli.inserirFollowers("Leandro", "Rodrigo", timestamp);

		// cli.removerFriend("Leandro", "Iarlen");

		// cli.removerFollowers("Leandro", "Rodrigo");
		//cli.close();

	}
}
