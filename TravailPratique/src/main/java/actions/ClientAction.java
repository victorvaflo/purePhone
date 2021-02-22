/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import entities.Client;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import managers.ClientManager;
import managers.SessionManager;

/**
 *
 * @author aouattar
 */
public class ClientAction {
    public static final String clientSessionAttr= "sessionClient";
    public static final String erreurClient = "erreurClient";
    
    public static boolean verifierSiUserExiste(HttpServletRequest request, Client clientToCheick) throws SQLException{
        boolean retour = false;
        Client clientRetour = ClientManager.checkClient(clientToCheick);
        if (clientRetour == null){
            request.setAttribute(erreurClient, "Utilisateur non non trouvee !");
            retour = false;
        }else{
            SessionManager.creerSessionClient(request, clientSessionAttr, clientRetour);
            retour = true;
        }
        
        return retour;
    }
}
