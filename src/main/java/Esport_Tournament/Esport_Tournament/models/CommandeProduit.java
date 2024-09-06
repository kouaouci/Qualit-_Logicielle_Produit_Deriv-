package Esport_Tournament.Esport_Tournament.models;

import jakarta.persistence.*;

@Entity(name = "commandeProduit")
@Table(name = "commandeProduit")
public class CommandeProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "quantite")
    private Integer quantite;
    @ManyToOne
    @JoinColumn(name = "idCommande")
    private Commande commande;
    @ManyToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;

    public CommandeProduit(Integer quantite, Commande commande, Produit produit) {
        this.quantite = quantite;
        this.commande = commande;
        this.produit = produit;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

   ;

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CommandeProduit() {
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CommandeProduit{");
        sb.append("id=").append(id);
        sb.append(", quantite=").append(quantite);
        sb.append(", commande=").append(commande);
        sb.append(", produit=").append(produit);
        sb.append('}');
        return sb.toString();
    }

}
