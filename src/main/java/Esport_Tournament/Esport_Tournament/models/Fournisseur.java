package Esport_Tournament.Esport_Tournament.models;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Fournisseur")
@Table(name = "Fournisseur")
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "fournisseur")
    private List<Produit> produits;
    public Fournisseur() {
    }
    public Fournisseur(String nom) {
        this.nom = nom;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public List<Produit> getProduits() {
        return produits;
    }
    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
    @Override

    public String toString() {
        final StringBuilder sb = new StringBuilder("Fournisseur{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
