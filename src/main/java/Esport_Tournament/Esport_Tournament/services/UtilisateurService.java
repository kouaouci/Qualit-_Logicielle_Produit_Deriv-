package Esport_Tournament.Esport_Tournament.services;

import Esport_Tournament.Esport_Tournament.DTO.UtilisateurDTO;
import Esport_Tournament.Esport_Tournament.dao.UtilisateurDAO;
import Esport_Tournament.Esport_Tournament.models.Adresse;
import Esport_Tournament.Esport_Tournament.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurDAO utilisateurDAO;

}
