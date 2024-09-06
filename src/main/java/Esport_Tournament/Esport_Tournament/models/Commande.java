package Esport_Tournament.Esport_Tournament.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "Commande")
@Entity(name = "Commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "dateLivraison")
    private LocalDate dateLivraison;
    @Column(name = "dateCommande")
    private LocalDate dateCommande;
    @Column(name = "prixTotal")
    private Double prixTotal;
  @Column(name="isPurchaseOnline")
    private boolean isPurchaseOnline;
  @Column(name="isValide")
    private boolean isValide;
  @ManyToOne
    @JoinColumn(name="idUtilisateur")
    private Utilisateur utilisateur;
    @ManyToOne
    @JoinColumn(name="idAdresse")
    private Adresse adresse;
    @ManyToOne
    @JoinColumn(name="idModePaiement")
    private ModeDePaiment modePaiement;
    @ManyToOne
    @JoinColumn(name="idAdresseFacturation")
    private Adresse adresseFacturation;
    @OneToMany(mappedBy = "commande", fetch = FetchType.EAGER)
    private List<CommandeProduit> commandeProduits;
    @ManyToOne
    @JoinColumn(name="idAdresseLivraison")
    private Adresse adresseLivraison;



    public Commande(LocalDate dateLivraison, LocalDate dateCommande, Double prixTotal, boolean isPurchaseOnline, boolean isValide) {
        this.dateLivraison = dateLivraison;
        this.dateCommande = dateCommande;
        this.prixTotal = prixTotal;
        this.isPurchaseOnline = isPurchaseOnline;
        this.isValide = isValide;
    }


    public Commande() {
    }

    public Commande(LocalDate now, LocalDateTime now1, boolean isPurchaseOnlineb, boolean isValide) {
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getDateLivraison() {
        return dateLivraison;
    }
    public void setDateLivraison(LocalDate dateLivraison) {
        this.dateLivraison = dateLivraison;
    }
    public LocalDate getDateCommande() {
        return dateCommande;
    }
    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }
    public Double getPrixTotal() {
        return prixTotal;
    }
    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }



    public boolean isValide() {
        return isValide;
    }

    public boolean isPurchaseOnline() {
        return isPurchaseOnline;
    }

    public void setPurchaseOnline(boolean purchaseOnline) {
        isPurchaseOnline = purchaseOnline;
    }

    public void setValide(boolean valide) {
        isValide = valide;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    public Adresse getAdresse() {
        return adresse;
    }
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public ModeDePaiment getModePaiement() {
        return modePaiement;
    }
    public void setModePaiement(ModeDePaiment modePaiement) {
        this.modePaiement = modePaiement;
    }
    public Adresse getAdresseFacturation() {
        return adresseFacturation;
    }
    public void setAdresseFacturation(Adresse adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }
    public List<CommandeProduit> getCommandeProduits() {
        return commandeProduits;
    }
    public void setCommandeProduits(List<CommandeProduit> commandeProduits) {
        this.commandeProduits = commandeProduits;
    }
    public Adresse getAdresseLivraison() {
        return adresseLivraison;
    }
    public void setAdresseLivraison(Adresse adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Commande{");
        sb.append("id=").append(id);
        sb.append(", dateLivraison=").append(dateLivraison);
        sb.append(", dateCommande=").append(dateCommande);
        sb.append(", prixTotal=").append(prixTotal);
        sb.append(", isPurchaseOnline=").append(isPurchaseOnline);
        sb.append(", isValide=").append(isValide);
        sb.append(", utilisateur=").append(utilisateur);
        sb.append(", adresse=").append(adresse);
        sb.append(", modePaiement=").append(modePaiement);
        sb.append(", adresseFacturation=").append(adresseFacturation);
        sb.append(", commandeProduits=").append(commandeProduits);
        sb.append(", adresseLivraison=").append(adresseLivraison);
        sb.append('}');
        return sb.toString();
    }




}
