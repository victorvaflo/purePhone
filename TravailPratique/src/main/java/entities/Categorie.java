package entities;

/**
 *
 * @author aouattar
 */
public class Categorie {
    int id_categorie;
    String nom_categorie;
    String urlImg;

    public Categorie() {
    }

    public Categorie(int id_categorie, String nom_categorie, String urlImg) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
        this.urlImg = urlImg;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    
}
