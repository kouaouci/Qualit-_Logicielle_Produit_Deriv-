package Esport_Tournament.Esport_Tournament.dao;

import Esport_Tournament.Esport_Tournament.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurDAO extends JpaRepository<Utilisateur, Long> {
    public Utilisateur findByEmail(String email);
}
