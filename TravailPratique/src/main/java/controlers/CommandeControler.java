/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import actions.ClientAction;
import actions.CommandeAction;
import actions.LigneCommandeAction;
import entities.Client;
import entities.Commande;
import entities.LigneComande;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.currentTimeMillis;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.CommandeManager;
import static managers.SessionManager.session;
import utils.Validation;

/**
 *
 * @author aouattar
 */
@WebServlet(name = "CommandeControler", urlPatterns = {"/commandeControler"})
public class CommandeControler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        //Recuperation des donnees
        HashMap<Integer, LigneComande> listeProduitPanier = (HashMap<Integer, LigneComande>) session.getAttribute("panier");
        //double prixTotalCommande = Double.parseDouble(request.getParameter("prixTotal"));
        Client client = (Client) session.getAttribute(ClientAction.clientSessionAttr);
        int idClient = client.getId_client();
        long millis = currentTimeMillis();
        Date dateCommande = new Date(millis);

        String url = "";
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("commandes")) {
                CommandeAction.afficherCommandeParClient(request, idClient);
                url = "WEB-INF/commandes.jsp";
            }
        } else if (listeProduitPanier != null) {
            double prixTotalCommande = Double.parseDouble(request.getParameter("prixTotal"));
            url = "WEB-INF/panier.jsp";
            CommandeAction.enregistrerCommande(idClient, dateCommande, prixTotalCommande);

            int idCommande = CommandeManager.getIdDerniereCommande();
            //LigneCommandeAction.enregistrerLigneCommande(idCommande, idClient, idClient);
            for (Map.Entry<Integer, LigneComande> p : listeProduitPanier.entrySet()) {
                int key = p.getKey();
                LigneComande ligne = p.getValue();
                LigneCommandeAction.enregistrerLigneCommande(idCommande, ligne.getId_produit(), ligne.getQte_produit());
            }
            request.setAttribute(Validation.msgInfoCommande, "Votre commande a bien été enregistrée !");

        } else {
            url = "WEB-INF/panier.jsp";
            request.setAttribute(Validation.msgInfoCommande, "Votre panier est vide");
        }

        request.getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CommandeControler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommandeControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CommandeControler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommandeControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
