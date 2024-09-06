package Esport_Tournament.Esport_Tournament.services;

import Esport_Tournament.Esport_Tournament.dao.ProduitDAO;
import Esport_Tournament.Esport_Tournament.models.CommandeProduit;
import Esport_Tournament.Esport_Tournament.models.Produit;
import Esport_Tournament.Esport_Tournament.pojo.VenteProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    private ProduitDAO produitDAO;
    public Produit findById(Long id) throws Exception {
        Optional<Produit> optionalProduit = produitDAO.findById(id);
        if (optionalProduit.isPresent()){
            return optionalProduit.get();
        }
        else{
            throw new Exception("Produit non trouvée.");
        }
    }

    public VenteProduit getVentesProduit(Long produitId) throws Exception {
        Integer quantiteVenduProduit = 0;
        Double prixTotalProduit = 0.0;
        Produit produit = findById(produitId);
        List<CommandeProduit> commandeProduits = produit.getCommandeProduits();
        for (CommandeProduit commandeProduit : commandeProduits) {
            if (commandeProduit.getCommande().isValide()) {
                quantiteVenduProduit += commandeProduit.getQuantite();
            }
        }
        prixTotalProduit += produit.getPrixVente() * quantiteVenduProduit;
        // objet de retour
        VenteProduit ventesProduit = new VenteProduit(produit, quantiteVenduProduit, prixTotalProduit);
        return ventesProduit;
    }
    /**
     * Renvoit les résultats de ventes de toutes les familles
     * @return VenteByFamille
     */
    public List<VenteProduit> getAllVentesProduit() throws Exception {
        List<Produit> produits = produitDAO.findAll();
        List<VenteProduit> ventesProduits = new ArrayList<>();
        for (Produit produit : produits){
            VenteProduit ventesProduit = getVentesProduit(produit.getId());
            ventesProduits.add(ventesProduit);
        }
        return ventesProduits;
    }


}