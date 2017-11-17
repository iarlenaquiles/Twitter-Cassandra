package br.ufc.quixada.app.dao;

import java.sql.Timestamp;
import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;

import br.ufc.quixada.app.conection.Conexao;

public class Twitter implements TwitterDAO {

	Conexao con = new Conexao("localhost");

	public void inserirUsuario(String user, String pass) {
		String stmt = "insert into twissandra.users (username, password) values (?, ?)";
		PreparedStatement ps = con.getSession().prepare(stmt);
		BoundStatement bs = new BoundStatement(ps);
		bs.bind(user, pass);
		con.getSession().execute(bs);
		con.close();
	}

	public void inserirTweet(String user, String body) {
		String stmt = "insert into twissandra.tweets (tweet_id, username, body) values (now(), ?, ?)";
		PreparedStatement ps = con.getSession().prepare(stmt);
		BoundStatement bs = new BoundStatement(ps);
		bs.bind(user, body);
		con.getSession().execute(bs);
		con.close();
	}

	public void inserirUserLine(String user, UUID tweet_id) {
		String stmt = "insert into twissandra.userline (username, time, tweet_id) values (?, now(), ?)";
		PreparedStatement ps = con.getSession().prepare(stmt);
		BoundStatement bs = new BoundStatement(ps);
		bs.bind(user, tweet_id);
		con.getSession().execute(bs);
		con.close();
	}

	public void inserirTimeline(String user, UUID tweet_id) {
		String stmt = "insert into twissandra.timeline (username, time, tweet_id) values (?, now(), ?)";
		PreparedStatement ps = con.getSession().prepare(stmt);
		BoundStatement bs = new BoundStatement(ps);
		bs.bind(user, tweet_id);
		con.getSession().execute(bs);
		con.close();
	}

	public void inserirFriend(String user, String friend, Timestamp since) {
		String stmt = "insert into twissandra.friends (username, friend, since) values (?, ?, ?)";
		PreparedStatement ps = con.getSession().prepare(stmt);
		BoundStatement bs = new BoundStatement(ps);
		bs.bind(user, friend, since);
		con.getSession().execute(bs);
		con.close();
	}

	public void inserirFollowers(String user, String friend, Timestamp since) {
		String stmt = "insert into twissandra.followers (username, follower, since) values (?, ?, ?)";
		PreparedStatement ps = con.getSession().prepare(stmt);
		BoundStatement bs = new BoundStatement(ps);
		bs.bind(user, friend, since);
		con.getSession().execute(bs);
		con.close();
	}

	public void removerFriend(String user, String friend) {
		String stmt = "DELETE FROM twissandra.friends WHERE username=? AND friend=?";
		PreparedStatement ps = con.getSession().prepare(stmt);
		BoundStatement bs = new BoundStatement(ps);
		bs.bind(user, friend);
		con.getSession().execute(bs);
		con.close();
	}

	public void removerFollowers(String user, String follower) {
		String stmt = "DELETE FROM twissandra.followers WHERE username=? AND follower=?";
		PreparedStatement ps = con.getSession().prepare(stmt);
		BoundStatement bs = new BoundStatement(ps);
		bs.bind(user, follower);
		con.getSession().execute(bs);
		con.close();
	}

}