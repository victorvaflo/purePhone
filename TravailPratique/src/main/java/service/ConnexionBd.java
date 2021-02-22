package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aouattar
 */
public class ConnexionBd {
    private static String nomBd = "tpjava";
    private static String login = "root";
    private static String pwd = "abc123...";
    private static String urlConnection = "jdbc:mariadb://localhost:3310/"+nomBd;
    private static Connection connection;

    public static PreparedStatement getPs(String query) {
        PreparedStatement retour = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(urlConnection, login, pwd);            
            retour = connection.prepareStatement(query);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnexionBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retour;
    }

    
    public static void close(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
