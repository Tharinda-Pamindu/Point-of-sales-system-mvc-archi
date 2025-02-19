/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpos.mvc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class DBConnection {

    private static DBConnection dBConnecction;
    private Connection connection;

    private DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newPos", "root", "Thari12345");
            //url, username, password
             } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public static DBConnection getInstance() {
        return dBConnecction == null ? dBConnecction = new DBConnection() : dBConnecction;
    }

}
