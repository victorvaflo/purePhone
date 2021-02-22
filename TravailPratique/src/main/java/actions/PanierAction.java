/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import entities.LigneComande;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import managers.PanierManager;
import managers.SessionManager;

/**
 *
 * @author vvargasf
 */
public class PanierAction {

    public static final String nbProduit = "nbProduit";
    public static String panierAttribut = "panier";

    public static void ajouterAuPanier(HttpServletRequest request, int idProduit) {
        HashMap<Integer, LigneComande> panier = (HashMap<Integer, LigneComande>) SessionManager.getByKey(request, true, "panier");
        PanierManager.add(request, idProduit, panier);
        request.setAttribute(nbProduit, PanierManager.getNbProduit(panier));
    }
    
    public static void enleverAuPanier(HttpServletRequest request, int idProduit) {
        HashMap<Integer, LigneComande> panier = (HashMap<Integer, LigneComande>) SessionManager.getByKey(request, true, "panier");
        PanierManager.remove(request, idProduit, panier);
        request.setAttribute(panierAttribut, panier);

    }
}
