/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import entities.Produit;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import managers.ProduitManager;

/**
 *
 * @author aouattar
 */
public class ProduitAction {

    public static final String listeDeProduit = "attributListeDeProduit";
    public static final String produitAttribut = "attributProduit";

    public static void afficherTousLesProduit(HttpServletRequest request) {
        //1 appele manager
        ArrayList<Produit> produit = ProduitManager.getAll();
        // ajouter a la requette
        request.setAttribute(listeDeProduit, produit);
    }

    public static void afficherLesProduitsParcategorie(HttpServletRequest request, int categorie) {
        //1 appeler manager
        ArrayList<Produit> produit = ProduitManager.getByCategorie(categorie);
        // ajouter a la requette
        request.setAttribute(listeDeProduit, produit);
    }
    
    public static void afficherDetailProduit(HttpServletRequest request, int idProduit){
        Produit produit = ProduitManager.getProduitById(idProduit);
        
        request.setAttribute(produitAttribut, produit);
    }
}
