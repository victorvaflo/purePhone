/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aouattar
 */
public class CookieManager {
    
    public static Cookie getCookyByNom(HttpServletRequest request, String nom) {
        Cookie retour = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(nom)) {
                    retour = cookie;
                }
            }
        }
        return retour;
    }
}
