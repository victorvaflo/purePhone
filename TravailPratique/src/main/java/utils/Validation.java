/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import managers.InscriptionManager;

/**
 *
 * @author aouattar
 */
public class Validation {

    public static final String errorNomAttribut = "errorNom";
    public static final String errorPrenomAttribut = "errorPrenom";
    public static final String errorEmailAttribute = "errorEmail";
    public static final String errorMdpAttribut = "errorMdp";
    public static final String inscriptionReussie = "InscriptionOk";
    public static final String listeErrorAttribut = "listeErreurs";
    
    public static final String msgInfoCommande = "msgInfoCommande";
 
    

    public static String validationEmail(String email) throws Exception {
        String retour = "ok";
        if (email != null && email.trim().length() != 0) {
            if (verifierSiEmailExiste(email)) {
                retour = "Ce email existe deja dans notre base de donnee";
            }
            
            /*if (!email.matches("([^.@]+)(\\\\.[^.@]+)*@([^.@]+\\\\.)+([^.@]+)")) {
                retour = "Votre adresse email n'est pas valide.";
                if (verifierSiEmailExiste(email)) {
                    retour = "Ce email existe deja dans notre base de donnee";
                }
            }*/
        } else {
            retour = "Ce champ est obligatoire";
        }

        return retour;
    }

    public static String validationNom(String nom) {
        String retour = "ok";
        if (nom != null && nom.trim().length() < 3) {
            retour = "Ce champ contenir au 3 lettres";
        }
        return retour;
    }

    public static String validationMdp(String mdp, String mdpConfirm) {
        String retour = "ok";
        if (mdp != null || mdpConfirm != null) {
            if (!mdpConfirm.equals(mdp)) {
                retour = "Les mots de passe ne sont pas identiques";
            }
        } else {
            retour = "Veuillez saisir les mots de passe !";
        }
        return retour;
    }

    public static boolean verifierSiEmailExiste(String email) {
        boolean retour = false;
        ArrayList<String> listEmailBd = InscriptionManager.getAllEmailClient();

        if (listEmailBd != null) {
            for (String e : listEmailBd) {
                if (e.equals(email)) {
                    retour = true;
                }
            }
        }
        return retour;
    }
}

//if validtion(email) != "" or validationMdp(mdp) != "" or validation != ""
//enregistrer
//else 
