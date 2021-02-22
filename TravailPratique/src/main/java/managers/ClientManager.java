/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ConnexionBd;

/**
 *
 * @author aouattar
 */
public class ClientManager {
    
    public static final String getAllClientQuery = "select id_client, email, password from client where email like ? and password like ? ";
    
    public static Client checkClient(Client clientToCheick) throws SQLException{
        Client client = null;
        
        String emailToCheick = clientToCheick.getEmail();
        String pwdToCheick = clientToCheick.getPassword();

        PreparedStatement preparedStatement = ConnexionBd.getPs(getAllClientQuery);
        preparedStatement.setString(1, emailToCheick);
        preparedStatement.setString(2, pwdToCheick);
 
        try {
            ResultSet result = preparedStatement.executeQuery();
            if (result.isBeforeFirst()) {
                while (result.next()) {//pour parcourir le resultset
                    client = new Client();
                    client.setId_client(result.getInt("id_client"));
                    client.setEmail(result.getString("email"));
                    client.setPassword(result.getString("password"));            
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        //fermer la connection
        ConnexionBd.close();       
        return client;   
    } 
    
}
