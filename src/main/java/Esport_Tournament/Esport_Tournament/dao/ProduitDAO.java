package Esport_Tournament.Esport_Tournament.dao;

import Esport_Tournament.Esport_Tournament.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitDAO  extends JpaRepository<Produit, Long> {
}
