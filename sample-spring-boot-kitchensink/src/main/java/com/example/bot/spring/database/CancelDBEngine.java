package com.example.bot.spring.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;


public class CancelDBEngine extends DBEngine {
	private ConfirmDBEngine CDB;
	/**
	 * function constructor
	 */
	public CancelDBEngine(){
		CDB=new ConfirmDBEngine();
	}
	/**
	 * get the confirmed tours ID
	 * @return
	 */
	public List<String> getAllUnconfirmedTours(){
		return CDB.getAllUnconfirmedTours(false);
	}
	/**
	 * get the users' information for the book table
	 * @param booktableid
	 * @return
	 */
	public Set<String> getAllContactors(String booktableid){
		boolean paid = true;
		return CDB.getAllContactors(booktableid, paid);
	}
	/**
	 * update the database about the canceled tours
	 * @param booktableid
	 * @throws Exception
	 */
	public void updateCanceledTours(String booktableid) throws Exception{	
		PreparedStatement stmt;	
		Connection connection;
		String statement = "UPDATE booking_table "
				+ "SET status = canceled "
				+ "WHERE bootableid = ?";
		try {
			connection=getConnection();
			stmt = connection.prepareStatement(statement);			
			stmt.setString(1,booktableid);
			stmt.executeUpdate();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
