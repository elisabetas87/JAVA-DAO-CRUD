/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendsmanager.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author elisabet
 */
public class DBConnect {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://"+"localhost/dax";
    public static final String USER = "daxusr"; 
    public static final String PASSWORD = "Daxpsw2."; 
    
    public DBConnect() throws ClassNotFoundException{
        Class.forName(this.DRIVER);
    }
    
    public Connection getConnection() throws SQLException{
        Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
        return conn;
    }
}
