/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author aouattar
 */
public class Commande {
    int id_commande;
    int id_client;
    Date date_commande;
    double prix_total_commande;

    public Commande() {
    }

    public Commande(int id_commande, int id_client, Date date_commande, double prix_total_commande) {
        this.id_commande = id_commande;
        this.id_client = id_client;
        this.date_commande = date_commande;
        this.prix_total_commande = prix_total_commande;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public double getPrix_total_commande() {
        return prix_total_commande;
    }

    public void setPrix_total_commande(double prix_total_commande) {
        this.prix_total_commande = prix_total_commande;
    }
    
    
}
