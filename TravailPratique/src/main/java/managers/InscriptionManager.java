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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ConnexionBd;

/**
 *
 * @author aouattar
 */
public class InscriptionManager {

    private static String queryAdd = "insert into client (nom, prenom, email, password) values (?,?,?,?)";
    private static String queryGetAllEmail = "select email from client";

    public static boolean add(Client clientToAdd) {
        int nbModDansBd = 0;
        try {
            PreparedStatement preparedStatement = ConnexionBd.getPs(queryAdd);
            preparedStatement.setString(1, clientToAdd.getNom());
            preparedStatement.setString(2, clientToAdd.getPrenom());
            preparedStatement.setString(3, clientToAdd.getEmail());
            preparedStatement.setString(4, clientToAdd.getPassword());

            nbModDansBd = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBd.close();
        return nbModDansBd > 0;
    }

    public static ArrayList<String> getAllEmailClient() {
        ArrayList<String> listEmail = null;
        PreparedStatement preparedStatement = ConnexionBd.getPs(queryGetAllEmail);

        try {
            ResultSet result = preparedStatement.executeQuery();
            if (result.isBeforeFirst()) {
                listEmail = new ArrayList<>();
                while (result.next()) {
                    listEmail.add(result.getString("email"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategorieManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        //fermer la connexion
        ConnexionBd.close();
        return listEmail;
    }

}
