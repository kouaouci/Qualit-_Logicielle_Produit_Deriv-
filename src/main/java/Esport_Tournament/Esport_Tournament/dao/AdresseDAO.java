package Esport_Tournament.Esport_Tournament.dao;

import Esport_Tournament.Esport_Tournament.models.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseDAO  extends JpaRepository<Adresse, Long> {
}
