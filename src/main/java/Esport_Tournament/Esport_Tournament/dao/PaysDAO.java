package Esport_Tournament.Esport_Tournament.dao;

import Esport_Tournament.Esport_Tournament.models.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysDAO extends JpaRepository<Pays, Long> {

}
