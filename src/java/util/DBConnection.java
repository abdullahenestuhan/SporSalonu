/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ABDULLAH
 */
public class DBConnection {

    private final String url = "jdbc:postgresql://localhost/SporSalonu";
    private final String user = "postgres";
    private final String password = "1905";

    public Connection connect() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException  | InstantiationException |IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }

        return con;
    }

}
