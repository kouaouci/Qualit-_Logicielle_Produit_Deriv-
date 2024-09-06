package Esport_Tournament.Esport_Tournament.ControllerTEST;

import Esport_Tournament.Esport_Tournament.DTO.UtilisateurDTO;
import Esport_Tournament.Esport_Tournament.models.Utilisateur;
import Esport_Tournament.Esport_Tournament.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
    @Autowired
    UtilisateurService utilisateurService;



}
