/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import entities.Commande;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import managers.CommandeManager;

/**
 *
 * @author aouattar
 */
public class CommandeAction {

    public static final String listeCommandeClientAttr = "listeCommandeClientAttribut";

    public static void enregistrerCommande(int idClient, Date dateCommande, double prixTotal) throws SQLException, ClassNotFoundException {
        CommandeManager.addLigneCommande(idClient, dateCommande, prixTotal);
    }

    public static void afficherCommandeParClient(HttpServletRequest request, int idClient) {
        ArrayList<Commande> listCommandeClient = CommandeManager.getAllCommandeByClient(idClient);
        request.setAttribute(listeCommandeClientAttr, listCommandeClient);
    }
}
