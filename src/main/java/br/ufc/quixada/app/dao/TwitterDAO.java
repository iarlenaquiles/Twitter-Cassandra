package br.ufc.quixada.app.dao;

import java.sql.Timestamp;
import java.util.UUID;

public interface TwitterDAO {

	public void inserirUsuario(String user, String pass);

	public void inserirTweet(String user, String body);

	public void inserirUserLine(String user, UUID tweet_id);

	public void inserirTimeline(String user, UUID tweet_id);

	public void inserirFriend(String user, String friend, Timestamp since);

	public void inserirFollowers(String user, String friend, Timestamp since);

	public void removerFriend(String user, String friend);

	public void removerFollowers(String user, String follower);
	
	public void getTweet(String id);
}
