package Esport_Tournament.Esport_Tournament.services;

import Esport_Tournament.Esport_Tournament.dao.AdresseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdresseService {
    @Autowired
    private AdresseDAO adresseDAO;
}
