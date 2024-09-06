package Esport_Tournament.Esport_Tournament.ServiceTEST;

import Esport_Tournament.Esport_Tournament.dao.*;
import Esport_Tournament.Esport_Tournament.models.*;
import Esport_Tournament.Esport_Tournament.pojo.VentesFamille;
import Esport_Tournament.Esport_Tournament.services.FamilleService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class FamilleServiceTest {



    @Autowired
    FamilleDAO familleDAO;

    @Autowired
    ProduitDAO produitDAO;

    @Autowired
    CommandeDAO commandeDAO;

    @Autowired
    CommandeProduitDAO commandeProduitDAO;

    @Autowired
    FournisseurDAO fournisseurDAO;

    @Autowired
    ModePaimentDAO modePaiementDAO;

    @Autowired
    AdresseDAO adresseDAO;

    @Autowired
    UtilisateurDAO utilisateurDAO;

    @Autowired
    RoleDAO roleDAO;

    @Autowired
    PaysDAO paysDAO;

    @Autowired
    FraisDePortDAO fraisDePortDAO;

    @Autowired
    FamilleService familleService;

    @BeforeEach

    public void delete() {
        commandeProduitDAO.deleteAll();
        commandeDAO.deleteAll();
        produitDAO.deleteAll();
        familleDAO.deleteAll();
        fournisseurDAO.deleteAll();
        modePaiementDAO.deleteAll();
        utilisateurDAO.deleteAll();
        adresseDAO.deleteAll();
        roleDAO.deleteAll();
        paysDAO.deleteAll();
        fraisDePortDAO.deleteAll();
    }

    @Test
    public void testGetVenteFamille() throws Exception {
        //given
        Famille famille = new Famille("figurine", "FIG");
        Famille getFamille = familleDAO.save(famille);

        Fournisseur fournisseur = new Fournisseur("F1");
        fournisseurDAO.save(fournisseur);

        ModeDePaiment modePaiement = new ModeDePaiment("carte bancaire");
        modePaiementDAO.save(modePaiement);

        FraisDePort fraisDePort = new FraisDePort(2.0);
        fraisDePortDAO.save(fraisDePort);

        Pays pays = new Pays("france", 1);
        pays.setFraisDePort(fraisDePort);
        paysDAO.save(pays);

        Adresse adresse;
        adresse = new Adresse("a", "b", "c");
        adresse.setPays(pays);
        adresseDAO.save(adresse);

        Role role = new Role("client");
        roleDAO.save(role);

        Utilisateur utilisateur = new Utilisateur("aaa", "bbb");
        utilisateur.setRole(role);
        utilisateur.setPays(pays);
        utilisateur.setAdresse(adresse);
        utilisateurDAO.save(utilisateur);

        Produit produit1 = new Produit("P1", "P1", 2.5, 8.0, 40, LocalDate.now());
        Produit produit2;
        produit2 = new Produit("P2", "P2", 3.5, 10.0, 30, LocalDate.now());
        produit1.setFamille(famille);
        produit2.setFamille(famille);
        produit1.setFournisseur(fournisseur);
        produit2.setFournisseur(fournisseur);
        produitDAO.save(produit1);
        produitDAO.save(produit2);

        Commande commandeOnlineValide1 = new Commande(LocalDate.now(), LocalDateTime.now(), true, true);
        Commande commandeNotOnlineValide = new Commande(LocalDate.now(), LocalDateTime.now(), false, true);
        Commande commandeOnlineNotValide = new Commande(LocalDate.now(), LocalDateTime.now(), true, false);
        commandeOnlineValide1.setModePaiement(modePaiement);
        commandeNotOnlineValide.setModePaiement(modePaiement);
        commandeOnlineNotValide.setModePaiement(modePaiement);
        commandeOnlineValide1.setAdresseLivraison(adresse);
        commandeOnlineValide1.setAdresseFacturation(adresse);
        commandeNotOnlineValide.setAdresseLivraison(adresse);
        commandeNotOnlineValide.setAdresseFacturation(adresse);
        commandeOnlineNotValide.setAdresseLivraison(adresse);
        commandeOnlineNotValide.setAdresseFacturation(adresse);
        commandeOnlineValide1.setUtilisateur(utilisateur);
        commandeNotOnlineValide.setUtilisateur(utilisateur);
        commandeOnlineNotValide.setUtilisateur(utilisateur);
        commandeDAO.save(commandeOnlineValide1);
        commandeDAO.save(commandeNotOnlineValide);
        commandeDAO.save(commandeOnlineNotValide);

        //commandeOnlineValide1
        CommandeProduit commandeProduitC1P1 = new CommandeProduit(2, commandeOnlineValide1, produit1);
        CommandeProduit commandeProduitC1P2 = new CommandeProduit(3, commandeOnlineValide1, produit2);
        //commandeNotOnlineValide
        CommandeProduit commandeProduitC2P1 = new CommandeProduit(1, commandeNotOnlineValide, produit1);
        //commandeOnlineNotValide
        CommandeProduit commandeProduitC3P2 = new CommandeProduit(1, commandeOnlineNotValide, produit2);

        commandeProduitDAO.save(commandeProduitC1P1);
        commandeProduitDAO.save(commandeProduitC1P2);
        commandeProduitDAO.save(commandeProduitC2P1);
        commandeProduitDAO.save(commandeProduitC3P2);

        //when
        Long idFamille = getFamille.getId();
        VentesFamille ventesFamille = familleService.getVentesFamille(idFamille);

        //then
        Assertions.assertThat(ventesFamille.famille.getId()).isEqualTo(getFamille.getId());
        Assertions.assertThat(ventesFamille.prixTotal).isEqualTo(0.0);
        Assertions.assertThat(ventesFamille.quantiteVendu).isEqualTo(0);
    }

    @Test
    public void testGetVenteFamille2() throws Exception {
        //given
        Famille famille = new Famille("figurine", "FIG");
        Famille getFamille = familleDAO.save(famille);

        Fournisseur fournisseur = new Fournisseur("F1");
        fournisseurDAO.save(fournisseur);

        ModeDePaiment modePaiement = new ModeDePaiment("carte bancaire");
        modePaiementDAO.save(modePaiement);

        FraisDePort fraisDePort = new FraisDePort(2.0);
        fraisDePortDAO.save(fraisDePort);

        Pays pays = new Pays("france", 1);
        pays.setFraisDePort(fraisDePort);
        paysDAO.save(pays);

        Adresse adresse;
        adresse = new Adresse("a", "b", "c");
        adresse.setPays(pays);
        adresseDAO.save(adresse);

        Role role = new Role("client");
        roleDAO.save(role);

        Utilisateur utilisateur = new Utilisateur("aaa", "bbb");
        utilisateur.setRole(role);
        utilisateur.setPays(pays);
        utilisateur.setAdresse(adresse);
        utilisateurDAO.save(utilisateur);

        Produit produit1 = new Produit("P1", "P1", 2.5, 8.0, 40, LocalDate.now());
        Produit produit2;
        produit2 = new Produit("P2", "P2", 3.5, 10.0, 30, LocalDate.now());
        produit1.setFamille(famille);
        produit2.setFamille(famille);
        produit1.setFournisseur(fournisseur);
        produit2.setFournisseur(fournisseur);
        produitDAO.save(produit1);
        produitDAO.save(produit2);

        Commande commandeOnlineValide1 = new Commande(LocalDate.now(), LocalDateTime.now(), true, true);
        Commande commandeNotOnlineValide = new Commande(LocalDate.now(), LocalDateTime.now(), false, true);
        Commande commandeOnlineNotValide = new Commande(LocalDate.now(), LocalDateTime.now(), true, false);
        commandeOnlineValide1.setModePaiement(modePaiement);
        commandeNotOnlineValide.setModePaiement(modePaiement);
        commandeOnlineNotValide.setModePaiement(modePaiement);


    }
    @Test
    public void testGetVenteFamilleNoSales() throws Exception {
        //given
        Famille famille = new Famille("figurine", "FIG");
        Famille getFamille = familleDAO.save(famille);

        Fournisseur fournisseur = new Fournisseur("F1");
        fournisseurDAO.save(fournisseur);

        ModeDePaiment modePaiement = new ModeDePaiment("carte bancaire");
        modePaiementDAO.save(modePaiement);

        FraisDePort fraisDePort = new FraisDePort(2.0);
        fraisDePortDAO.save(fraisDePort);

        Pays pays = new Pays("france", 1);
        pays.setFraisDePort(fraisDePort);
        paysDAO.save(pays);

        Adresse adresse = new Adresse("a", "b", "c");
        adresse.setPays(pays);
        adresseDAO.save(adresse);

        Role role = new Role("client");
        roleDAO.save(role);

        Utilisateur utilisateur = new Utilisateur("aaa", "bbb");
        utilisateur.setRole(role);
        utilisateur.setPays(pays);
        utilisateur.setAdresse(adresse);
        utilisateurDAO.save(utilisateur);

        Produit produit1 = new Produit("P1", "P1", 2.5, 8.0, 40, LocalDate.now());
        Produit produit2 = new Produit("P2", "P2", 3.5, 10.0, 30, LocalDate.now());
        produit1.setFamille(famille);
        produit2.setFamille(famille);
        produit1.setFournisseur(fournisseur);
        produit2.setFournisseur(fournisseur);
        produitDAO.save(produit1);
        produitDAO.save(produit2);

        // Création des commandes sans produits de la famille
        Commande commandeOnlineValide1 = new Commande(LocalDate.now(), LocalDateTime.now(), true, true);
        Commande commandeNotOnlineValide = new Commande(LocalDate.now(), LocalDateTime.now(), false, true);
        Commande commandeOnlineNotValide = new Commande(LocalDate.now(), LocalDateTime.now(), true, false);
        commandeOnlineValide1.setModePaiement(modePaiement);
        commandeNotOnlineValide.setModePaiement(modePaiement);
        commandeOnlineNotValide.setModePaiement(modePaiement);
        commandeOnlineValide1.setAdresseLivraison(adresse);
        commandeOnlineValide1.setAdresseFacturation(adresse);
        commandeNotOnlineValide.setAdresseLivraison(adresse);
        commandeNotOnlineValide.setAdresseFacturation(adresse);
        commandeOnlineNotValide.setAdresseLivraison(adresse);
        commandeOnlineNotValide.setAdresseFacturation(adresse);
        commandeOnlineValide1.setUtilisateur(utilisateur);
        commandeNotOnlineValide.setUtilisateur(utilisateur);
        commandeOnlineNotValide.setUtilisateur(utilisateur);
        commandeDAO.save(commandeOnlineValide1);
        commandeDAO.save(commandeNotOnlineValide);
        commandeDAO.save(commandeOnlineNotValide);

        // Création de CommandeProduit mais sans produits de la famille testée
        CommandeProduit commandeProduitC1Autre = new CommandeProduit(2, commandeOnlineValide1, produit2);
        CommandeProduit commandeProduitC2Autre = new CommandeProduit(1, commandeNotOnlineValide, produit2);
        CommandeProduit commandeProduitC3Autre = new CommandeProduit(1, commandeOnlineNotValide, produit2);

        commandeProduitDAO.save(commandeProduitC1Autre);
        commandeProduitDAO.save(commandeProduitC2Autre);
        commandeProduitDAO.save(commandeProduitC3Autre);

        //when
        Long idFamille = getFamille.getId();
        VentesFamille ventesFamille = familleService.getVentesFamille(idFamille);

        //then
        Assertions.assertThat(ventesFamille.famille.getId()).isEqualTo(getFamille.getId());
        Assertions.assertThat(ventesFamille.prixTotal).isEqualTo(0.0);
        Assertions.assertThat(ventesFamille.quantiteVendu).isEqualTo(0);
    }












}
