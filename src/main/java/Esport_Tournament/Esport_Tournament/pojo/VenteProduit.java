package Esport_Tournament.Esport_Tournament.pojo;

import Esport_Tournament.Esport_Tournament.models.Produit;

public class VenteProduit {
    public Produit produit;
    public Integer quantiteVendu;
    public Double prixTotal;

    public VenteProduit(Produit produit, Integer quantiteVendu, Double prixTotal) {
        this.produit = produit;
        this.quantiteVendu = quantiteVendu;
        this.prixTotal = prixTotal;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Integer getQuantiteVendu() {
        return quantiteVendu;
    }

    public void setQuantiteVendu(Integer quantiteVendu) {
        this.quantiteVendu = quantiteVendu;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }
    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }



}
