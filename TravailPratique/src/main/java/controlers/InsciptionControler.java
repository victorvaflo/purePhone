/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import actions.InscriptionAction;
import entities.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Validation;

/**
 *
 * @author aouattar
 */
@WebServlet(name = "InsciptionControler", urlPatterns = {"/insciptionControler"})
public class InsciptionControler extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
     
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");
        String mdp2 = request.getParameter("mdp2");
        
        HashMap<String, String> listErreurs = new HashMap<String, String>();
        
        ///Validation des valeurs saisies dans le formulaire
        if (!Validation.validationNom(nom).equals("ok")){
            //listErreurs.put(Validation.errorNomAttribut, Validation.validationNom(nom));
            request.setAttribute(Validation.errorNomAttribut, Validation.validationNom(nom));
        }else if (!Validation.validationNom(prenom).equals("ok")){
            //listErreurs.put(Validation.errorPrenomAttribut, Validation.validationNom(prenom));
            request.setAttribute(Validation.errorPrenomAttribut, Validation.validationNom(prenom));
        }else if (!Validation.validationEmail(email).equals("ok")){
            //listErreurs.put(Validation.errorEmailAttribute, Validation.validationEmail(email));
            request.setAttribute(Validation.errorEmailAttribute, Validation.validationEmail(email) );
        }else if (!Validation.validationMdp(mdp, mdp2).equals("ok")){
            //listErreurs.put(Validation.errorMdpAttribut, Validation.validationMdp(mdp, mdp2));
            request.setAttribute(Validation.errorMdpAttribut, Validation.validationMdp(mdp, mdp2));
        }else{
            Client clientToAdd = new Client(nom, prenom, email, mdp);
            InscriptionAction.enregistrerClientDansLaBd(clientToAdd);
            request.setAttribute(Validation.inscriptionReussie, "Inscription reussie  ! Vous pouvez maintenant vous connecter !");
        }
        
        //request.setAttribute(Validation.listeErrorAttribut, listErreurs);
        request.getRequestDispatcher("inscription.jsp").forward(request, response);
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
        } catch (Exception ex) {
            Logger.getLogger(InsciptionControler.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(InsciptionControler.class.getName()).log(Level.SEVERE, null, ex);
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
