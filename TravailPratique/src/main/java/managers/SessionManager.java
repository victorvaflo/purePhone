/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.Client;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aouattar
 */
public class SessionManager {

    public static HttpSession session = null;

    public static void creerSessionClient(HttpServletRequest request, String sessionAttribut, Client client) {
        session = request.getSession();
        session.setAttribute(sessionAttribut, client);
        //HashMap<Integer, Integer> panier = new HashMap<>();
        //session.setAttribute("panier", panier);
    }

    public static void supprimerSession(HttpServletRequest request) {
        session = request.getSession();
        session.invalidate();
    }

    public static HttpSession recuperer(HttpServletRequest request, boolean creerSession) {
        HttpSession session = null;
        if (creerSession) {
            session = request.getSession(true);
        } else {
            session = request.getSession(false);
        }
        return session;
    }

    public static boolean add(HttpServletRequest request, boolean creerSession, String key, Object value) {
        boolean retour = false;
        HttpSession session = recuperer(request, creerSession);
        if (creerSession || (!creerSession && session != null)) {
            session.setAttribute(key, value);
            retour = true;
        }
        return retour;
    }

    public static Object getByKey(HttpServletRequest request, boolean creer, String key) {
        Object retour = null;
        HttpSession session = recuperer(request, creer);
        if (creer || !creer && session != null) {
            retour = session.getAttribute(key);
        }
        return retour;
    }

}
