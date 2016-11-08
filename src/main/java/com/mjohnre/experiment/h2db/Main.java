package com.mjohnre.experiment.h2db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JohnReMugar
 */
public class Main {
    
    public static void main(String[] args) {
	
	System.out.println("--- CREATE ---");
	try(Connection connection = DBHelper.getConnection()) {
	    String sqlQuery = "CREATE TABLE IF NOT EXISTS rat "
		    + "(r_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
		    + "r_name TEXT NOT NULL DEFAULT '');";
	    PreparedStatement prepStatement = connection.prepareStatement(sqlQuery);
//	    prepStatement.setString(1, "r_id INT PRIMARY KEY AUTOINCREMENT NOT NULL");
//	    prepStatement.setString(2, "r_name TEXT NOT NULL DEFAULT ''");
	    prepStatement.execute();
	} catch (SQLException ex) {
	    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	System.out.println("--- INSERT ---");
	try(Connection connection = DBHelper.getConnection()) {
	    String sqlQuery = "INSERT INTO rat VALUES (?,?);";
	    PreparedStatement prepStatement = connection.prepareStatement(sqlQuery);
	    prepStatement.setNull(1, Types.INTEGER);
	    prepStatement.setString(2, "Random Entry");
	    prepStatement.executeUpdate();
	} catch (SQLException ex) {
	    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	System.out.println("--- SELECT ---");
	try(Connection connection = DBHelper.getConnection()) {
	    String sqlQuery = "SELECT * FROM rat";
	    PreparedStatement prepStatement = connection.prepareStatement(sqlQuery);
	    try(ResultSet rs = prepStatement.executeQuery()) {
		while(rs.next()) {
		    System.out.println("r_id: "+rs.getInt(1));
		    System.out.println("r_name: "+rs.getString(2));
		}
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
}
