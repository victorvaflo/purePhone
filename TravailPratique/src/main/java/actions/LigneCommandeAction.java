/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import entities.LigneComande;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import managers.LigneCommandeManager;

/**
 *
 * @author aouattar
 */
public class LigneCommandeAction {
    public static String detailCmdAttribut = "detailCmdAttribut";
    public static void enregistrerLigneCommande(int idCommande, int idProduit, int qteProduit) throws SQLException, ClassNotFoundException{
        LigneCommandeManager.addLigneCommande(idCommande, idProduit, qteProduit);
    }
    
    public static void afficherDetailCommande(HttpServletRequest request, int idCommande){
        ArrayList<LigneComande> ligne = LigneCommandeManager.getProduitCommande(idCommande);
        request.setAttribute(detailCmdAttribut, ligne);
    }
}
