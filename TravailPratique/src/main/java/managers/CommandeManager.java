/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.Commande;
import entities.Produit;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ConnexionBd;

/**
 *
 * @author aouattar
 */
public class CommandeManager {

    public static final String addCommandeQuery = "insert into commande (id_client, date_commande, prix_total_commande) values (?,?,?)";
    public static final String getIdCommande = "select max(id_commande) from commande";
    public static final String getAllCommandeClient = "select id_commande, date_commande, prix_total_commande from commande where id_client = ?";

    public static boolean addLigneCommande(int idClient, Date dateCommande, double prixTotalCommande)
            throws SQLException, ClassNotFoundException {

        int nbModDansBd = 0;
        try {
            PreparedStatement preparedStatement = ConnexionBd.getPs(addCommandeQuery);
            preparedStatement.setInt(1, idClient);
            preparedStatement.setDate(2, dateCommande);
            preparedStatement.setDouble(3, prixTotalCommande);

            nbModDansBd = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommandeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBd.close();
        return nbModDansBd > 0;
    }

    public static int getIdDerniereCommande() {
        int retour = -1;

        try {
            PreparedStatement preparedStatement = ConnexionBd.getPs(getIdCommande);
            ResultSet result = preparedStatement.executeQuery();

            if (result.isBeforeFirst()) {
                result.next();
                retour = result.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProduitManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBd.close();
        return retour;
    }

    public static ArrayList<Commande> getAllCommandeByClient(int idClient) {

        ArrayList<Commande> listeCommande = null;
        PreparedStatement preparedStatement = ConnexionBd.getPs(getAllCommandeClient);

        try {
            preparedStatement.setInt(1, idClient);
            ResultSet result = preparedStatement.executeQuery();
            if (result.isBeforeFirst()) {
                listeCommande = new ArrayList<>();
                while (result.next()) {
                    Commande commande = new Commande();
                    commande.setId_commande(result.getInt("id_commande"));
                    commande.setDate_commande(result.getDate("date_commande"));
                    commande.setPrix_total_commande(result.getDouble("prix_total_commande"));
                    listeCommande.add(commande);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        //recetter la connection
        ConnexionBd.close();
        return listeCommande;
    }
}
