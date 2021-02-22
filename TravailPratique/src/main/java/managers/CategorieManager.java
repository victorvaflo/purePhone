package managers;

import entities.Categorie;
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
public class CategorieManager {

    public static final String getAllQuery = "select * from categorie;";
    public static final String getCategorieName = "select nom_categorie from categorie where id_categorie = ? ";

    public static ArrayList<Categorie> getAllCategorie() {
        ArrayList<Categorie> listeCategorie = null;
        PreparedStatement preparedStatement = ConnexionBd.getPs(getAllQuery);

        try {
            ResultSet result = preparedStatement.executeQuery();
            if (result.isBeforeFirst()) {
                listeCategorie = new ArrayList<>();
                while (result.next()) {
                    Categorie categorie = new Categorie();
                    categorie.setId_categorie(result.getInt("id_categorie"));
                    categorie.setNom_categorie(result.getString("nom_categorie"));
                    categorie.setUrlImg(result.getString("img_url"));
                    listeCategorie.add(categorie);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategorieManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBd.close();
        return listeCategorie;
    }

    public static String getCategorieName(int id) {
        String retour = null;
        PreparedStatement preparedStatement = ConnexionBd.getPs(getCategorieName);

        try {
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            if (result.isBeforeFirst()) {
                 
                while (result.next()) {
                    retour = result.getString("nom_categorie");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategorieManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBd.close();
        return retour;
    }
}
