/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import entities.Categorie;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import managers.CategorieManager;

/**
 *
 * @author aouattar
 */
public class CategorieAction {
    public static final String listeCategorieAttr = "listeCategorie";
    public static final String nomCategorieAttr = "nomCategorieAttribut";
    
    public static void afficherToutesLesCategorie(HttpServletRequest request){
        ArrayList<Categorie> listeCategorie = CategorieManager.getAllCategorie();
        request.setAttribute(listeCategorieAttr, listeCategorie);
    }
}
