package Esport_Tournament.Esport_Tournament.controllers;

import Esport_Tournament.Esport_Tournament.pojo.VenteProduit;
import Esport_Tournament.Esport_Tournament.pojo.VentesFamille;
import Esport_Tournament.Esport_Tournament.services.CommandeService;
import Esport_Tournament.Esport_Tournament.services.FamilleService;
import Esport_Tournament.Esport_Tournament.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class ConsoleController {
 @Autowired
    FamilleService familleService;

    @Autowired
    CommandeService commandeService;
    @Autowired
    ProduitService produitService;
    public void printConsoleApp() throws Exception {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }

        this.printMenu();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Rentrer dans la page : ");

        //Lit l'entier écrit par l'utilisateur et l'affecte
        int pageToGo = scanner.nextInt();
        int valueToReturnToMenu = 0;

        while(
                pageToGo != 1 &&
                        pageToGo != 2 &&
                        pageToGo != 3
        )
        {
            System.out.print("MAUVAISE VALEUR RENTRE");
            this.printMenu();
            Scanner scanner2 = new Scanner(System.in);
            System.out.print("Rentrer dans la page : ");
            pageToGo = scanner2.nextInt();
        }
        switch (pageToGo){
            case 1 :
                valueToReturnToMenu = this.printPageCommandes();
                break;

            case 2 :
                valueToReturnToMenu = this.printPageFamille();
                break;

            case 3 :
                valueToReturnToMenu = this.printPageProduit();
                break;
        }
        if(valueToReturnToMenu == 1){
            this.printConsoleApp();
        }
    }




    public void printMenu(){
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }

        System.out.println("--------------------------------- ");
        System.out.println("--------------------------------- ");
        System.out.println("STASTISTIQUES DE PRODUITS DERIVE");
        System.out.println("--------------------------------- ");
        System.out.println("--------------------------------- ");
        System.out.println();
        System.out.println();
        System.out.println("------------------ MENU ------------------");
        System.out.println("(Pour naviguer dans le menu, entrer le numéro correspondant entre parenthèses) ");
        System.out.println();
        System.out.println();
        System.out.println("(1) : Statistiques des commandes faites");
        System.out.println("(2) : Statistiques des familles de produits");
        System.out.println("(3) : Statistiques des produits");
        System.out.println("--------------------");
    }

    //On retournera la valeur de retour au menu
    public int printPageFamille() throws Exception {

        List<VentesFamille> ventesFamilles = familleService.getAllVentesFamille();

        for (int i = 0; i < 30; i++) {
            System.out.println();
        }

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\tPAGE (2) STATISTIQUES FAMILLE");
        System.out.println("------------------------------------------------------------------------------------");

        System.out.printf("| %-20s | %-10s | %20s | %20s |%n", "NOM", "CODE","PRIX TOTAL","NOMBRE VENDUS");
        System.out.println("------------------------------------------------------------------------------------");

        for (VentesFamille ventesFamille : ventesFamilles) {
            System.out.printf("| %-20s | %-10s | %20s | %20s |%n",
                    ventesFamille.getFamille().getNom(),
                    ventesFamille.getFamille().getCode(),
                    ventesFamille.getPrixTotal(),
                    ventesFamille.getQuantiteVendu()
            );
            System.out.println("------------------------------------------------------------------------------------");
        }
        return returnValueUserInput();
    }

    public int returnValueUserInput(){
        System.out.println();
        Scanner scannerToExit = new Scanner(System.in);
        System.out.println("(1) Retour au menu ");

        System.out.print("Rentrer dans la page :");
        int valeurRetour = scannerToExit.nextInt();
        while(valeurRetour != 1){
            System.out.println("MAUVAISE VALEUR RENTRE");
            System.out.println("(1) Retour au menu ");
            Scanner scannerToExit2 = new Scanner(System.in);
            System.out.print("Rentrer dans la page :");
            valeurRetour = scannerToExit2.nextInt();
        }
        return valeurRetour;
    }
    public int printPageProduit() throws Exception {

        List<VenteProduit> ventesProduits = produitService.getAllVentesProduit();

        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.println("\tPAGE (3) STATISTIQUES PROODUIT");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");

        System.out.printf("| %-25s | %-10s | %20s | %20s | %20s |%n", "NOM", "CODE","FAMILLE","NOMBRE VENDUS","SOMME PRIX TOTAL");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");

        for (VenteProduit ventesProduit : ventesProduits) {
            System.out.printf("| %-25s | %-10s | %20s | %20s | %20s |%n",
                    ventesProduit.getProduit().getNom(),
                    ventesProduit.getProduit().getCode(),
                    ventesProduit.getProduit().getFamille().getNom(),
                    ventesProduit.getQuantiteVendu(),
                    ventesProduit.getPrixTotal()
            );
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
        }
        return returnValueUserInput();
    }

    public int  printPageCommandes(){

        double sumPrixAchatCommandeOnline = commandeService.getSumPrixAchatOfCommandeOnline();
        double sumPrixVenteOfCommandeOnline = commandeService.getSumPrixVenteOfCommandeOnline();

        double sumPrixAchatOfCommandeNotOnline = commandeService.getSumPrixAchatOfCommandeNotOnline();
        double sumPrixVenteOfCommandeNotOnline = commandeService.getSumPrixAchatOfCommandeNotOnline();


        for (int i = 0; i < 30; i++) {
            System.out.println();
        }

        System.out.println("----------------------------------------------------------------");
        System.out.println("\tPAGE (1) STATISTIQUES COMMANDES");
        System.out.println("----------------------------------------------------------------");

        System.out.printf("| %-20s | %-8s | %8s |%n", "", "SUR PLACE", "EN LIGNE");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("| %-20s | %-8s | %-8s |%n", "SOMME DE PRIX D'ACHAT", sumPrixAchatOfCommandeNotOnline, sumPrixAchatCommandeOnline );
        System.out.printf("| %-20s | %-8s | %-8s |%n", "SOMME DE PRIX DE VENTE", sumPrixVenteOfCommandeNotOnline, sumPrixVenteOfCommandeOnline );
        System.out.println("----------------------------------------------------------------");
        return returnValueUserInput();
    }



}
