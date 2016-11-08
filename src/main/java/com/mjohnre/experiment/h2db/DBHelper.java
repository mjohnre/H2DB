package com.mjohnre.experiment.h2db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JohnReMugar
 */
public class DBHelper {
    
    public static Connection getConnection() throws SQLException {
	Connection connection = null;
	
	try {
	    Class.forName("org.h2.Driver");
//	    create db at home path e.g.: C:/Users/[user]/
//	    connection = DriverManager.
//		    getConnection("jdbc:h2:~/lab_db", "admin", "1234");
	    
//	    create db at project home directory
	    connection = DriverManager.
		    getConnection("jdbc:h2:./lab_db;CIPHER=AES", "admin", "filepw 1234");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return connection;
    }
    
}
