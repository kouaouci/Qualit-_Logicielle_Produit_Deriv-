package Esport_Tournament.Esport_Tournament.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "Produit")
@Table(name = "Produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "code")
    private String code;
    @Column(name = "prixAchat")
    private Double prixAchat;
    @Column(name = "prixVente")
    private Double prixVente;
    @Column(name = "quantiteEnStock")
    private Integer quantiteEnStock;
    @Column(name = "dateReaprovisionnementFournisseur")
    private LocalDate dateReaprovisionnementFournisseur;
    @ManyToOne
    @JoinColumn(name = "idFamille")
    private Famille famille;
    @ManyToOne
    @JoinColumn(name = "idFournisseur")
    private Fournisseur fournisseur;
    @OneToMany(mappedBy = "produit", fetch = FetchType.EAGER)
    private List<CommandeProduit> commandeProduits;


    public Produit() {
    }
    public Produit(String nom, String code, Double prixAchat, Double prixVente, Integer quantiteEnStock, LocalDate dateReaprovisionnementFournisseur, Famille famille, Fournisseur fournisseur) {
        this.nom = nom;
        this.code = code;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.quantiteEnStock = quantiteEnStock;
        this.dateReaprovisionnementFournisseur = dateReaprovisionnementFournisseur;
        this.famille = famille;
        this.fournisseur = fournisseur;
    }

    public Produit(String nom, String code, Double prixAchat, Double prixVente, Integer quantiteEnStock, LocalDate dateReaprovisionnementFournisseur) {
        this.nom = nom;
        this.code = code;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.quantiteEnStock = quantiteEnStock;
        this.dateReaprovisionnementFournisseur = dateReaprovisionnementFournisseur;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    public Double getPrixAchat() {
        return prixAchat;
    }
    public void setPrixAchat(Double prixAchat) {
        this.prixAchat = prixAchat;
    }
    public Double getPrixVente() {
        return prixVente;
    }
    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }
    public Integer getQuantiteEnStock() {
        return quantiteEnStock;
    }
    public void setQuantiteEnStock(Integer quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }
    public LocalDate getDateReaprovisionnementFournisseur() {
        return dateReaprovisionnementFournisseur;
    }
    public void setDateReaprovisionnementFournisseur(LocalDate dateReaprovisionnementFournisseur) {
        this.dateReaprovisionnementFournisseur = dateReaprovisionnementFournisseur;
    }
    public Famille getFamille() {
        return famille;
    }
    public void setFamille(Famille famille) {
        this.famille = famille;
    }
    public Fournisseur getFournisseur() {
        return fournisseur;
    }
    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
    public List<CommandeProduit> getCommandeProduits() {
        return commandeProduits;
    }
    public void setCommandeProduits(List<CommandeProduit> commandeProduits) {
        this.commandeProduits = commandeProduits;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Produit{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prixAchat=").append(prixAchat);
        sb.append(", prixVente=").append(prixVente);
        sb.append(", quantiteEnStock=").append(quantiteEnStock);
        sb.append(", dateReaprovisionnementFournisseur=").append(dateReaprovisionnementFournisseur);
        sb.append(", famille=").append(famille);
        sb.append(", fournisseur=").append(fournisseur);
        sb.append(", commandeProduits=").append(commandeProduits);
        sb.append('}');
        return sb.toString();
    }


}
