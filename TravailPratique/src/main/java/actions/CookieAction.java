/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.CookieManager;

/**
 *
 * @author aouattar
 */
public class CookieAction {
    
    public static void ajouterCookie(HttpServletResponse response, String nom, String valeur) {
        Cookie cookie = new Cookie(nom, valeur);
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
    }
        
    public static void supprimerCookie(HttpServletRequest request, HttpServletResponse response, String key){
        Cookie cookieToDelete = CookieManager.getCookyByNom(request, key);
        if(cookieToDelete != null){
            cookieToDelete.setMaxAge(0);
            response.addCookie(cookieToDelete);
        }
    }
}
