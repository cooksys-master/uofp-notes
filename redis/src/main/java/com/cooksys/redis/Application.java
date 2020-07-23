package com.cooksys.redis;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class Application {
	private static final int ONE_WEEK_IN_SECONDS = 7 * 86400;
	private static final int VOTE_SCORE = 432;
	
	
	public static void main(String[] args) {
		
		try {
			Jedis connection = new Jedis("localhost", 6379);
			
//			for (int i = 0; i < 1000000; i++) {
//				createArticle(connection, "user" + i, "Title of article " + i, "www.google.com");
//			}
			
//			for (int i = 1; i <= 100; i++) {
//				for (int j = 0; j < Math.ceil(Math.random() * 50); j++) {
//					vote(connection, "user:" + j, "article:" + 1);
//				}
//			}
			
			vote(connection, "user:4190", "article:342");
			
			connection.close();
		} catch(JedisConnectionException jedisConnectionException) {
			System.out.println(jedisConnectionException.getClass() + ":");
			System.out.println("Could not connect to Reddis database. Please ensure the database is running and the provided IP and PORT are correct!");
		}
		
		System.out.println("This code still runs");
		
	}
	
	public static String createArticle(Jedis conn, String user, String title, String link) {
		String articleID = String.valueOf(conn.incr("article:"));
		
		String votedKey = "voted:" + articleID;
		conn.sadd(votedKey, user);
		conn.expire(votedKey, ONE_WEEK_IN_SECONDS);
		
		long currentTime = System.currentTimeMillis() / 1000;
		String articleKey = "article:" + articleID;
		Map<String, String> articleData = new HashMap<>();
		articleData.put("title", title);
		articleData.put("link", link);
		articleData.put("user", user);
		articleData.put("postedTime", String.valueOf(currentTime));
		articleData.put("votes", "1");
		
		conn.hmset(articleKey, articleData);
		conn.zadd("score:", currentTime + VOTE_SCORE, articleKey);
		conn.zadd("time:", currentTime, articleKey);
		
		return articleKey;
	}
	
	public static void vote(Jedis conn, String user, String article) {
		long cutoff = (System.currentTimeMillis() / 1000) - ONE_WEEK_IN_SECONDS;
		if (conn.zscore("time:", article) < cutoff) {
			return;
		}
		
		String articleID = article.substring(article.indexOf(":") + 1);
		if (conn.sadd("voted:" + articleID, user) == 1) {
			conn.zincrby("score:", VOTE_SCORE, article);
			conn.hincrBy(article, "votes", 1);
		}
		
	}

}
