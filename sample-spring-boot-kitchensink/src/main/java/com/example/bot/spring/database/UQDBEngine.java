package com.example.bot.spring.database;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UQDBEngine extends DBEngine {

	public UQDBEngine() {
		// TODO Auto-generated constructor stub
	}
	
	public String uqQuery(String userId, String text) {

		Connection connection;
		try {
			connection = getConnection();
			//insert into the unanswered question table to store the question
			PreparedStatement stmt = connection.prepareStatement(
					"insert into table ###### values ######");
			stmt.close();
			connection.close();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Sorry, I can't answer your question. My colleague will follow up with you.";
	}
}