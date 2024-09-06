package Esport_Tournament.Esport_Tournament.modelsTEST;

import Esport_Tournament.Esport_Tournament.DTO.AdresseDTO;
import Esport_Tournament.Esport_Tournament.DTO.UtilisateurDTO;
import Esport_Tournament.Esport_Tournament.dao.UtilisateurDAO;
import Esport_Tournament.Esport_Tournament.models.Utilisateur;
import Esport_Tournament.Esport_Tournament.services.UtilisateurService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UtilisateurTEST {
    @Mock
    private UtilisateurDAO utilisateurDAO;

    @InjectMocks
    private UtilisateurService utilisateurService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindUserByEmail() {

        // Given
        String email = "test@example.com";
        Utilisateur expectedUtilisateur = new Utilisateur("John Doe", email);

        when(utilisateurDAO.findByEmail(email)).thenReturn(expectedUtilisateur);

        // When
        Optional<Utilisateur> result = Optional.ofNullable(utilisateurDAO.findByEmail(email));

        // Then
        assertTrue(result.isPresent());
        assertEquals(expectedUtilisateur, result.get());
        verify(utilisateurDAO).findByEmail(email);
    }

    @Test
    void testFindUserByEmail_UserNotFound() {
        // Given
        String email = "nonexistent@example.com";

        when(utilisateurDAO.findByEmail(email)).thenReturn(null); // Or Optional.empty() if using Optional

        // When
        Optional<Utilisateur> result = Optional.ofNullable(utilisateurDAO.findByEmail(email)); // Or directly Optional.empty()

        // Then
        assertTrue(result.isEmpty());
        verify(utilisateurDAO).findByEmail(email);
    }
}


   /* @Test
    public void creerUtilisateurTEST() {
        // creer les dto
        UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
        utilisateurDTO.setEmail("test@exemple.com");
        utilisateurDTO.getMotDePasse();
        AdresseDTO adresseDTO = new AdresseDTO();
        adresseDTO.setRue("rue de la paix");
        adresseDTO.setVille("Paris");
        adresseDTO.setCodePostal("75000");
        adresseDTO.setPays("France");
        utilisateurDTO.setAdresse(adresseDTO);
        when(utilisateurDAO.save(any(Utilisateur.class))).thenReturn(new Utilisateur());
        // verifier que le service a bien appele la methode save du dao
        Utilisateur utilisateur = utilisateurService.creerUtilisateur(utilisateurDTO);
        // Appeler la methode du service

        Utilisateur utilisateur1 = utilisateurService.creerUtilisateur(utilisateurDTO);
        // verifier que le dao a bien ete appele
        assertNotNull(utilisateur);
        assertEquals("test@exemple.com", utilisateur1.getEmail());
        assertEquals("rue de la paix", utilisateur1.getAdresse().getRue());
        assertEquals("Paris", utilisateur1.getAdresse().getVille());
        assertEquals("75000", utilisateur1.getAdresse().getCodePostal());
        assertEquals("France", utilisateur1.getAdresse().getPays());
        verify(utilisateurDAO).save(any(Utilisateur.class));




    }*/

