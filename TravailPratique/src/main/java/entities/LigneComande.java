/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author vvargasf
 */
public class LigneComande {

    int id_produit;
    int id_ligne_comande;
    int qte_produit;

    public LigneComande() {
    }
    
    

    public LigneComande(int id_produit, int qte_produit) {
        this.id_produit = id_produit;
        this.qte_produit = qte_produit;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId_ligne_comande() {
        return id_ligne_comande;
    }

    public void setId_ligne_comande(int id_ligne_comande) {
        this.id_ligne_comande = id_ligne_comande;
    }

    public int getQte_produit() {
        return qte_produit;
    }

    public void setQte_produit(int qte_produit) {
        this.qte_produit = qte_produit;
    }

}
