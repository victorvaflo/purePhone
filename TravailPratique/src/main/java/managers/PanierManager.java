/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.LigneComande;
import entities.Produit;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vvargasf
 */
public class PanierManager {

    public static void add(HttpServletRequest request, int idProduit, HashMap<Integer, LigneComande> panier) {
        HttpSession session = request.getSession();
        panier = (HashMap<Integer, LigneComande>) session.getAttribute("panier");
        if (panier == null) {
            panier = new HashMap<Integer, LigneComande>();
            session.setAttribute("panier", panier);
        }

        if (panier.containsKey(idProduit)) {
            LigneComande ligne = panier.get(idProduit);
            ligne.setQte_produit(ligne.getQte_produit() + 1);
            session.setAttribute("qte", ligne.getQte_produit());
        } else {
            LigneComande ligne = new LigneComande(idProduit, 1);
            panier.put(idProduit, ligne);
            session.setAttribute("qte", ligne.getQte_produit());
        }

    }

        public static void remove(HttpServletRequest request,int idProduit, HashMap<Integer, LigneComande> panier) {
         if (panier.containsKey(idProduit)){
            LigneComande ligne = panier.get(idProduit);
            if(ligne.getQte_produit()>1){           
            ligne.setQte_produit(ligne.getQte_produit() - 1);
            }else{
                panier.remove(idProduit);
            }
            
        }
    }
    public static void rrrrremove(int idProduit, HashMap<Integer, LigneComande> panier) {
        if (panier != null) {
            if (panier.containsKey(idProduit)) {
                LigneComande ligne = panier.get(idProduit);

                if (ligne.getQte_produit() - 1 > 0) {
                    ligne.setQte_produit(ligne.getQte_produit() - 1);
                } else {
                    panier.remove(idProduit);
                }
            }
        }
    }

    public static int getNbProduit(HashMap<Integer, LigneComande> panier) {
        int retour = 0;

        if (panier != null) {
            for (Map.Entry<Integer, LigneComande> ligne : panier.entrySet()) {
                int key = ligne.getKey();
                LigneComande value = ligne.getValue();
                retour += value.getQte_produit();
            }
        }
        return retour;
    }

}
