package Esport_Tournament.Esport_Tournament.dao;

import Esport_Tournament.Esport_Tournament.models.ModeDePaiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ModePaimentDAO extends JpaRepository<ModeDePaiment, Long> {
    List<ModeDePaiment> findAll();
}
