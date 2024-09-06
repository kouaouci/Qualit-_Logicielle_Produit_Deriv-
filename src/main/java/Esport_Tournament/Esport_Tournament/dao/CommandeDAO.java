package Esport_Tournament.Esport_Tournament.dao;

import Esport_Tournament.Esport_Tournament.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDAO  extends JpaRepository<Commande, Long> {
//    @Query("SELECT c FROM Commande c WHERE c.utilisateur.id = ?1")
//    public Commande findByUtilisateurId(Long id);

    @Query(value = "SELECT c FROM Commande c")
    List<Commande> findAll() ;


}
