package Esport_Tournament.Esport_Tournament.services;

import Esport_Tournament.Esport_Tournament.dao.CommandeDAO;
import Esport_Tournament.Esport_Tournament.dao.CommandeProduitDAO;
import Esport_Tournament.Esport_Tournament.dao.UtilisateurDAO;
import Esport_Tournament.Esport_Tournament.models.Commande;
import Esport_Tournament.Esport_Tournament.models.CommandeProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {
    @Autowired
    private CommandeDAO commandeDAO;

    @Autowired
    private UtilisateurDAO utilisateurDAO;
    @Autowired
    private CommandeProduitDAO commandeProduitDAO;
    public double getSumPrixAchatOfCommandeOnline(){
        double sumCommandeOnline = 0d;
        List<Commande> commandes = commandeDAO.findAll();
        for (Commande commande : commandes) {
            if(commande.isPurchaseOnline()){
                List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                for (CommandeProduit commandeProduit : commandeProduits) {
                    sumCommandeOnline += commandeProduit.getProduit().getPrixAchat() * commandeProduit.getQuantite();
                }
            }
        }


        return sumCommandeOnline;
    }


    public double getSumPrixAchatOfCommandeNotOnline() {
        double sumCommandeOnline = 0d;
        List<Commande> commandes = commandeDAO.findAll();
        for (Commande commande : commandes) {
            if (!commande.isPurchaseOnline()) {
                List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                for (CommandeProduit commandeProduit : commandeProduits) {
                    sumCommandeOnline += commandeProduit.getProduit().getPrixAchat() * commandeProduit.getQuantite();
                }
            }
        }
        return sumCommandeOnline;
    }

    public double getSumPrixVenteOfCommandeOnline() {
        double sumCommandeNotOnline = 0d;

        List<Commande> commandes = commandeDAO.findAll();
        for (Commande commande : commandes) {
            if (commande.isPurchaseOnline()) {
                List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                for (CommandeProduit commandeProduit : commandeProduits) {
                    sumCommandeNotOnline += commandeProduit.getProduit().getPrixVente() * commandeProduit.getQuantite();
                }
            }
        }
        return sumCommandeNotOnline;
    }
}









