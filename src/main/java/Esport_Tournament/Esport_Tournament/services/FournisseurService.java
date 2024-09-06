package Esport_Tournament.Esport_Tournament.services;

import Esport_Tournament.Esport_Tournament.dao.FournisseurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FournisseurService {
    @Autowired
    private FournisseurDAO fournisseurDAO;
}
