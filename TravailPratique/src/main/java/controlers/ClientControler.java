/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import actions.ClientAction;
import actions.CookieAction;
import entities.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.ClientManager;
import managers.CookieManager;

/**
 *
 * @author aouattar
 */
@WebServlet(name = "ClientControler", urlPatterns = {"/clientControler"})
public class ClientControler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");
        String souvenir = request.getParameter("souvenir");

        String url = "";

        //Cookie nom = CookieManager.getCookyByNom(request, "email");
        Client client = new Client(email, mdp);

        if (ClientAction.verifierSiUserExiste(request, client)) {
            if (souvenir == null || email.equals("") || mdp.equals("")) {
               CookieAction.supprimerCookie(request, response, "email");
               CookieAction.supprimerCookie(request, response, "mdp");
            } else {//si coche ajoute un cookie 
                CookieAction.ajouterCookie(response, "email", email);
                CookieAction.ajouterCookie(response, "mdp", mdp);
            }
            url = "WEB-INF/acceuil.jsp";
        } else {
            url = "login.jsp";
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
            Logger.getLogger(ClientControler.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ClientControler.class.getName()).log(Level.SEVERE, null, ex);
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
