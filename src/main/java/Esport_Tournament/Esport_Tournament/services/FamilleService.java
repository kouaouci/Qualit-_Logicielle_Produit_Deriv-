package Esport_Tournament.Esport_Tournament.services;

import Esport_Tournament.Esport_Tournament.dao.FamilleDAO;
import Esport_Tournament.Esport_Tournament.models.CommandeProduit;
import Esport_Tournament.Esport_Tournament.models.Famille;
import Esport_Tournament.Esport_Tournament.models.Produit;
import Esport_Tournament.Esport_Tournament.pojo.VentesFamille;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FamilleService  {
    @Autowired
    private FamilleDAO familleDAO;

    public Famille findById(Long id) throws Exception {
        Optional<Famille> optionalFamille = familleDAO.findById(id);
        if (optionalFamille.isPresent()){
            return optionalFamille.get();
        }
        else{
            throw new Exception("Famille non trouvée.");
        }

    }
    /**
     * Renvoi les résultats de ventes d'une famille
     * @param familleId Id de la famille
     * @return VenteByFamille
     * Le code ci-dessus a pour but de calculer les ventes d'une famille de produits donnée.
     * Il parcourt tous les produits de la famille,
     * puis toutes les commandes associées à chaque produit pour calculer la quantité totale vendue et le prix total
     */
    public VentesFamille getVentesFamille(Long familleId) throws Exception{
        Integer quantiteVenduFamille = 0;
        Integer quantiteVenduProduit = 0;
        Double prixTotalFamille = 0.0;
        Famille famille = findById(familleId);
        List<Produit> produits = famille.getProduits();
        for (Produit produit : produits) {
            quantiteVenduProduit = 0;
            List<CommandeProduit> commandeProduits = produit.getCommandeProduits();
            for (CommandeProduit commandeProduit : commandeProduits) {
                if (commandeProduit.getCommande().isValide()) {
                    quantiteVenduFamille += commandeProduit.getQuantite();
                    quantiteVenduProduit += commandeProduit.getQuantite();
                }
            }
            prixTotalFamille += produit.getPrixVente() * quantiteVenduProduit;
        }
        // objet de retour
        VentesFamille ventesFamille = new VentesFamille(famille, quantiteVenduFamille, prixTotalFamille);
        return ventesFamille;
    }
    /**
     * Renvoit les résultats de ventes de toutes les familles
     * @return VenteByFamille
     */
    public List<VentesFamille> getAllVentesFamille() throws Exception {
        List<Famille> familles = familleDAO.findAll();
        List<VentesFamille> ventesFamilles = new ArrayList<>();
        for (Famille famille : familles) {
            ventesFamilles.add(getVentesFamille(famille.getId()));
        }
        return ventesFamilles;

}
}

