/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

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
public class ProduitManager {

    private static String queryGetAll = "select * from produit";
    private static String queryByCategorie = "select * from produit where id_Categorie = ?";
    private static String queryGetProductById = "select * from produit where id_produit = ?";

    public static ArrayList<Produit> getAll() {
        ArrayList<Produit> retour = null;
        PreparedStatement preparedStatement = ConnexionBd.getPs(queryGetAll);
        try {
            ResultSet result = preparedStatement.executeQuery();
            if (result.isBeforeFirst()) {
                retour = new ArrayList<>();
                while (result.next()) {
                    Produit produit = new Produit();
                    produit.setIdProduit(result.getInt("id_produit"));
                    produit.setTitre(result.getString("titre"));
                    produit.setCouleur(result.getString("couleur"));
                    produit.setStokage(result.getInt("stockage"));
                    produit.setDescription(result.getString("description"));
                    produit.setImgUrl(result.getString("img_url"));
                    produit.setPrix(result.getDouble("prix"));
                    produit.setIdCategorie(result.getInt("id_categorie"));
                    retour.add(produit);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        //fermer la connection
        ConnexionBd.close();
        return retour;
    }

    public static ArrayList<Produit> getByCategorie(int categorie) {
        ArrayList<Produit> retour = null;

        try {
            PreparedStatement preparedStatement = ConnexionBd.getPs(queryByCategorie);
            preparedStatement.setInt(1, categorie);
            ResultSet result = preparedStatement.executeQuery();

            if (result.isBeforeFirst()) {
                retour = new ArrayList<>();

                while (result.next()) {//pour parcourir le resultset
                    Produit produit = new Produit();
                    produit.setIdProduit(result.getInt("id_produit"));
                    produit.setTitre(result.getString("titre"));
                    produit.setCouleur(result.getString("couleur"));
                    produit.setStokage(result.getInt("stockage"));
                    produit.setDescription(result.getString("description"));
                    produit.setImgUrl(result.getString("img_url"));
                    produit.setPrix(result.getDouble("prix"));
                    produit.setIdCategorie(result.getInt("id_categorie"));
                    retour.add(produit);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBd.close();
        return retour;
    }

    public static Produit getProduitById(int id) {
        Produit retour = null;
        PreparedStatement preparedStatement = ConnexionBd.getPs(queryGetProductById);

        try {
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            if (result.isBeforeFirst()) {
               retour = new Produit();
                while (result.next()) {//pour parcourir le resultset
                    //Produit produit = new Produit();
                    retour.setIdProduit(result.getInt("id_produit"));
                    retour.setTitre(result.getString("titre"));
                    retour.setCouleur(result.getString("couleur"));
                    retour.setStokage(result.getInt("stockage"));
                    retour.setDescription(result.getString("description"));
                    retour.setImgUrl(result.getString("img_url"));
                    retour.setPrix(result.getDouble("prix"));
                    retour.setIdCategorie(result.getInt("id_categorie"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBd.close();
        return retour;

    }
}
