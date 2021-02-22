/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import entities.Client;
import managers.InscriptionManager;

/**
 *
 * @author aouattar
 */
public class InscriptionAction {
    public static void enregistrerClientDansLaBd(Client client){
        InscriptionManager.add(client);
    }
}
