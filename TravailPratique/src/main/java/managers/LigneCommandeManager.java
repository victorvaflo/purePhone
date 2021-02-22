/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.LigneComande;
import entities.Produit;
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
public class LigneCommandeManager {

    private final static String addLigneCommande = "insert into ligne_commande (id_commande,id_produit, qte_produit) VALUES (?,?,?)";
    private final static String getLigneCommandeById = "select id_produit, qte_produit from ligne_commande where id_commande = ?";

    public static boolean addLigneCommande(int idCommande, int idProduit, int qteProduit)
            throws SQLException, ClassNotFoundException {

        int nbModDansBd = 0;
        try {
            PreparedStatement preparedStatement = ConnexionBd.getPs(addLigneCommande);
            preparedStatement.setInt(1, idCommande);
            preparedStatement.setInt(2, idProduit);
            preparedStatement.setInt(3, qteProduit);

            nbModDansBd = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LigneCommandeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBd.close();
        return nbModDansBd > 0;

    }
    
    
    public static ArrayList<LigneComande> getProduitCommande(int idCommande){
        ArrayList<LigneComande> retour = null;
        PreparedStatement preparedStatement = ConnexionBd.getPs(getLigneCommandeById);

        try {
            preparedStatement.setInt(1, idCommande);
            ResultSet result = preparedStatement.executeQuery();
           
            if (result.isBeforeFirst()) {
                retour = new ArrayList<>();
                while (result.next()) {//pour parcourir le resultset
                    LigneComande ligne = new LigneComande();
                    ligne.setId_produit(result.getInt("id_produit"));
                    ligne.setQte_produit(result.getInt("qte_produit"));
                    retour.add(ligne);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LigneCommandeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        //fermer la connection
        ConnexionBd.close();
        return retour;
    }
}
